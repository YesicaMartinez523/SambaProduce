import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LEER_IMPLEMENTOS, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/D_implementos/ImplementosURL';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class LeerImplementosService {

  constructor(private http: HttpClient) { }

  leerImplementos():Observable<RespuestaGeneral>{
    return this.http.get<RespuestaGeneral>(RUTA_PRINCIPAL + LEER_IMPLEMENTOS);
  }
}
