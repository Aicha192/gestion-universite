import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FormationService } from '../services/formation.service';

@Component({
  selector: 'app-formations',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './formations.html',
  styleUrls: ['./formations.css'],
})
export class Formations {
  formations: any[] = [];

  newFormation = {
    titre: '',
    description: '',
  };

  isEdit = false;
  editId: number | null = null;

  constructor(private formationService: FormationService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.formationService.getAll().subscribe((data: any) => {
      this.formations = data;
    });
  }

  add() {
    this.formationService.add(this.newFormation).subscribe(() => {
      this.load();
      this.reset();
    });
  }

  delete(id: number) {
    this.formationService.delete(id).subscribe(() => {
      this.load();
    });
  }

  edit(f: any) {
    this.isEdit = true;
    this.editId = f.id;

    this.newFormation = {
      titre: f.titre,
      description: f.description,
    };
  }

  update() {
    if (this.editId !== null) {
      this.formationService.update(this.editId, this.newFormation).subscribe(() => {
        this.load();
        this.reset();
      });
    }
  }

  reset() {
    this.newFormation = { titre: '', description: '' };
    this.isEdit = false;
    this.editId = null;
  }
}
