import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-login-form',
  imports: [FormsModule,CommonModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  loginData={
    usuario:"",
    contrasena:""
  }
    constructor(private service:AuthService ){
    }
    onSubmit(){
      this.service.login(this.loginData).subscribe({
        next:(response)=>{
          console.log(response);
        }
      })
    }
    
}
