import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LogoComponent } from "../logo/logo.component";
import { CommonModule } from '@angular/common';
import { RegisterFormComponent } from '../../form/register-form/register-form.component';
import { LoginFormComponent } from '../../form/login-form/login-form.component';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [LogoComponent, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  user={
    username:"usuario",
    img:"",
  }
  constructor(private dialog: MatDialog, private service:AuthService) {}

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
  islogin(){
    console.log(this.service.isLoggedIn());
    if(this.service.isLoggedIn()){
      this.user.username=this.service.getUsername();

    }
    return this.service.isLoggedIn();
  }
  logOut(){
    this.service.logout();
  }
}