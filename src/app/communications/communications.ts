import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CommunicationService } from '../services/communication.service';

@Component({
  selector: 'app-communications',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './communications.html',
  styleUrls: ['./communications.css'],
})
export class Communications {
  communications: any[] = [];

  newCommunication = {
    titre: '',
    message: '',
  };

  isEdit = false;
  editId: number | null = null;

  constructor(private communicationService: CommunicationService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.communicationService.getAll().subscribe((data: any) => {
      this.communications = data;
    });
  }

  add() {
    this.communicationService.add(this.newCommunication).subscribe(() => {
      this.load();
      this.reset();
    });
  }

  delete(id: number) {
    this.communicationService.delete(id).subscribe(() => {
      this.load();
    });
  }

  edit(c: any) {
    this.isEdit = true;
    this.editId = c.id;

    this.newCommunication = {
      titre: c.titre,
      message: c.message,
    };
  }

  update() {
    if (this.editId !== null) {
      this.communicationService.update(this.editId, this.newCommunication).subscribe(() => {
        this.load();
        this.reset();
      });
    }
  }

  reset() {
    this.newCommunication = { titre: '', message: '' };
    this.isEdit = false;
    this.editId = null;
  }
}
