import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { HttpErrorResponse } from '@angular/common/http';
import { RegisterFormComponent } from '../register-form/register-form.component';

@Component({
  selector: 'app-login-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  loginData = {
    usuario: '',
    contrasena: ''
  };
  
  // Estados del formulario
  formSubmitted = false;
  isLoading = false;
  errorMessage = "";
  
  constructor(
    private service: AuthService, 
    private dialogRef: MatDialogRef<LoginFormComponent>,
    private dialog: MatDialog
  ) {}

  onSubmit() {
    this.formSubmitted = true;
    
    // Validaciones básicas
    if (!this.loginData.usuario || this.loginData.usuario.length < 4 || 
        !this.loginData.contrasena || this.loginData.contrasena.length < 6) {
      return;
    }

    this.isLoading = true;
    this.errorMessage = "";
    
    this.service.login(this.loginData).subscribe({
      next: () => {
        this.dialogRef.close(true); // Cierra con éxito
      },
      error: (error: HttpErrorResponse) => {
        this.isLoading = false;
        
        if (error.status === 401 || error.status === 404) {
          this.errorMessage = "Usuario o contraseña incorrectos";
        } else if (error.status === 403) {
          this.errorMessage = "Error de conexión con el servidor";
        } else if (error.status === 0) {
          this.errorMessage = "No hay conexión a internet";
        } else {
          this.errorMessage = "Error desconocido. Intente nuevamente";
        }
      }
    });
  }

  onRegister() {
    const dialogRef = this.dialog.open(RegisterFormComponent, {
      width: '400px'
    });
    this.dialogRef.close('register');
  }
  
}