import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./elemento/navbar/navbar.component";
import { LogoComponent } from "./elemento/logo/logo.component";
import { LoginFormComponent } from "./form/login-form/login-form.component";
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RegisterFormComponent } from "./form/register-form/register-form.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, LoginFormComponent, HttpClientModule, RegisterFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FrontEnd';
}
