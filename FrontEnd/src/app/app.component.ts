import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./elemento/navbar/navbar.component";
import { LogoComponent } from "./elemento/logo/logo.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, LogoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FrontEnd';
}
