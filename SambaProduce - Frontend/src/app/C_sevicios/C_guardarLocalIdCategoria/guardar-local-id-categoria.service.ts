import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GuardarLocalIdCategoriaService {
  constructor() { }

  guardarIdCategoria( message: string ): void {
    localStorage.setItem('categoriaId', message);
  }
  obtenerIdCategoria() {
      return localStorage.getItem('categoriaId');
  }
  EliminarIdCategoria(): void {
      localStorage.removeItem('categoriaId');
  }
}