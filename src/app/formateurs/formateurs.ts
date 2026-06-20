import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FormateurService } from '../services/formateur.service';

@Component({
  selector: 'app-formateurs',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './formateurs.html',
  styleUrls: ['./formateurs.css'],
})
export class Formateurs {
  formateurs: any[] = [];

  newFormateur = {
    nom: '',
    specialite: '',
  };

  isEdit = false;
  editId: number | null = null;

  constructor(private formateurService: FormateurService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.formateurService.getAll().subscribe((data: any) => {
      this.formateurs = data;
    });
  }

  add() {
    this.formateurService.add(this.newFormateur).subscribe(() => {
      this.load();
      this.reset();
    });
  }

  delete(id: number) {
    this.formateurService.delete(id).subscribe(() => {
      this.load();
    });
  }

  edit(f: any) {
    this.isEdit = true;
    this.editId = f.id;

    this.newFormateur = {
      nom: f.nom,
      specialite: f.specialite,
    };
  }

  update() {
    if (this.editId !== null) {
      this.formateurService.update(this.editId, this.newFormateur).subscribe(() => {
        this.load();
        this.reset();
      });
    }
  }

  reset() {
    this.newFormateur = { nom: '', specialite: '' };
    this.isEdit = false;
    this.editId = null;
  }
}
