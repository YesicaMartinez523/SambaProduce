import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LEER_REGISTRO_MANTENIMIENTO, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/E_registroMantenimientos/RegistroMantenimientos';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class LeerMantenimientosPorMaquinaService {

  constructor(private http: HttpClient) { }

  leerMantenimientosPorMaquina(idMaquina : number):Observable<RespuestaGeneral>{
    return this.http.get<RespuestaGeneral>(RUTA_PRINCIPAL + LEER_REGISTRO_MANTENIMIENTO + idMaquina);
  }
}
