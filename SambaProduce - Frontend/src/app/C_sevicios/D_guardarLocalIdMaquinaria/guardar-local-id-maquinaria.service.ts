import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GuardarLocalIdMaquinariaService {

  constructor() { }

  guardarIdMaquinaria( message: string ): void {
    localStorage.setItem('maquinariaId', message);
  }
  obtenerIdMaquinaria() {
      return localStorage.getItem('maquinariaId');
  }
  EliminarIdMaquinaria(): void {
      localStorage.removeItem('maquinariaId');
  }
}