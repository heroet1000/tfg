import { Component } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { CommonModule } from '@angular/common';

// Primero define la interfaz fuera del componente
export interface Producto {
  id: number;
  nombre: string;
  descripcion:string;
  precio:number;
  cantidad:number;
  categoria:any
  imagen:string;
  agregando?: boolean;
}

@Component({
  selector: 'app-tienda',
  templateUrl: './tienda.component.html',
  imports: [CommonModule],
  styleUrls: ['./tienda.component.css']  // Corregido a styleUrls (array)
})
export class TiendaComponent {
  productos: Producto[] = [];  // Cambiado a público para usar en el template

  constructor(private service: ProductService) {
    this.cargarProductos();
  }

  cargarProductos(): void {
  this.service.findAll().subscribe({
    next: (data: Producto[]) => {
      this.productos = data;
    },
    error: (error) => {
      console.error('Error al cargar productos:', error);
    }
    // complete handler is optional and can be omitted if not needed
  });
}
  agregarAlCarrito(Producto:Producto){
    Producto.agregando = true; // Activa el estado de carga
  
  this.service.anadirCarrito(Producto)
    .subscribe({
      next: () => {
        Producto.agregando = false; // Desactiva al finalizar
      },
      error: () => {
        Producto.agregando = false; // También en caso de error
      }
    });

  }
}