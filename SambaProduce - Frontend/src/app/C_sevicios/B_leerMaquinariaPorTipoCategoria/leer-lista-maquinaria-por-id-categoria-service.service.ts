import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LEER_MAQUINARIA_CATEGORIA_ID, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/B_maquinaria/MaquinariaURL';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class LeerListaMaquinariaPorIdCategoriaServiceService {
  
  constructor(private http: HttpClient) { }

  leerListaMaquinariaPorIdCategoria(categoriaId: number): Observable<RespuestaGeneral>{
    return this.http.get<RespuestaGeneral>(RUTA_PRINCIPAL + LEER_MAQUINARIA_CATEGORIA_ID + categoriaId);
  }
}