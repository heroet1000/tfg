import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { LoginFormComponent } from '../login-form/login-form.component';

@Component({
  selector: 'app-register-form',
  imports: [FormsModule,CommonModule],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})
export class RegisterFormComponent {
registerData = {
    usuario: '',
    contrasena: '',
    contrasena2: '',
    nombre: '',
    ap1: '',
    ap2: '',
    email: '',
    tel: ''
  };
  constructor(private service: AuthService, 
    private dialogRef: MatDialogRef<RegisterFormComponent>,
    private dialog: MatDialog){
    
  }

  onSubmit(form: any) {
    if (form.valid && this.passwordsMatch() && this.validPhone()) {
      const usuario=this.registerData.usuario;
      const contrasena=this.registerData.contrasena;
      this.service.register(this.registerData).subscribe({
        next:(values)=>{
          this.service.login({usuario,contrasena})
        }
      })
      console.log('Datos registrados:', this.registerData);
      alert('Registro exitoso!');
    } else {
      console.log('Formulario inválido');
    }
  }

  passwordsMatch(): boolean {
    return this.registerData.contrasena === this.registerData.contrasena2;
  }

  validPhone(): boolean {
    if (!this.registerData.tel) return false;
    return /^[6-8]\d{8}$/.test(this.registerData.tel);
  }

  formatPhone(event: Event) {
    const input = event.target as HTMLInputElement;
    let value = input.value.replace(/[^0-9]/g, '');
    if (value.length > 9) {
      value = value.substring(0, 9);
    }
    this.registerData.tel = value;
    input.value = value; // Actualizar el valor visual
  }
  openLogin(): void {
      const dialogRef = this.dialog.open(LoginFormComponent, {
        width: '400px'
      });
      
  
      dialogRef.afterClosed().subscribe(result => {
        console.log('El diálogo de login se cerró');
      });
    }

}