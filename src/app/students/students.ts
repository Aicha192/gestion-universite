import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-students',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './students.html',
  styleUrls: ['./students.css']
})
export class Students {

  students: any[] = [];

  newStudent = {
    ine: '',
    nom: '',
    prenom: ''
  };

  isEdit = false;
  editId: number | null = null;

  constructor(private studentService: StudentService) {}

  ngOnInit() {
    this.loadStudents();
  }

  // READ
  loadStudents() {
    this.studentService.getAllStudents().subscribe((data: any) => {
      this.students = data;
    });
  }

  // CREATE
  addStudent() {
    this.studentService.addStudent(this.newStudent).subscribe(() => {
      this.loadStudents();
      this.resetForm();
    });
  }

  // DELETE
  deleteStudent(id: number) {
    this.studentService.deleteStudent(id).subscribe(() => {
      this.loadStudents();
    });
  }

  // EDIT (charger les données)
  editStudent(student: any) {
    this.isEdit = true;
    this.editId = student.id;

    this.newStudent = {
      ine: student.ine,
      nom: student.nom,
      prenom: student.prenom
    };
  }

  // UPDATE
  updateStudent() {
    if (this.editId !== null) {
      this.studentService.updateStudent(this.editId, this.newStudent)
        .subscribe(() => {
          this.loadStudents();
          this.resetForm();
        });
    }
  }

  // RESET FORM
  resetForm() {
    this.newStudent = {
      ine: '',
      nom: '',
      prenom: ''
    };
    this.isEdit = false;
    this.editId = null;
  }
}
