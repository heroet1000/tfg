import { Component } from '@angular/core';
import { LogoComponent } from "../logo/logo.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  imports: [LogoComponent,CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

}
