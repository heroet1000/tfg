import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../elemento/tienda/tienda.component';
import { AuthService } from './auth.service';

interface Request {
  idUsuario: number | null;
  idProducto: number | null;
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient, private service: AuthService) { }
  
  private apiUrl = 'http://localhost:8080/producto';

  findAll() {
    return this.http.get<Producto[]>(this.apiUrl + "/findall");
  }

  anadirCarrito(producto: Producto) {
    const carrito: Request = {
      idUsuario: this.service.getUserId(),
      idProducto: producto.id
    };
    return this.http.post("http://localhost:8080/usuario/anadirCarro", carrito);
  }
}