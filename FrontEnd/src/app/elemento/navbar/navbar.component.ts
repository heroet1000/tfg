import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LogoComponent } from "../logo/logo.component";
import { CommonModule } from '@angular/common';
import { RegisterFormComponent } from '../../form/register-form/register-form.component';
import { LoginFormComponent } from '../../form/login-form/login-form.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [LogoComponent, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private dialog: MatDialog) {}

  openRegister(): void {
    const dialogRef = this.dialog.open(RegisterFormComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('El diálogo de registro se cerró');
    });
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