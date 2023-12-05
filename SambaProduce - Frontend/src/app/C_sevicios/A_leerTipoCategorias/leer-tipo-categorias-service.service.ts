import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LEER_CATEGORIAS, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/A_tipoCategoria/TipoCategoriaURL';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class LeerTipoCategoriasServiceService {
  constructor(private http: HttpClient) { }

  leerTodasCategorias(): Observable<RespuestaGeneral>{
    return this.http.get<RespuestaGeneral>(RUTA_PRINCIPAL + LEER_CATEGORIAS);
  }
}