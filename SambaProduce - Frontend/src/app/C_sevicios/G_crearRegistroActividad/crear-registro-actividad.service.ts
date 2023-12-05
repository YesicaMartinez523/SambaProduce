import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistroActividadEntidad } from 'src/app/A_modelo/A_dominios/C_registroActividad/RegistroActividadEntidad';
import { CREAR_REGISTRO_ACTIVIDAD, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/C_registroActividad/RegistroActividadURL';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class CrearRegistroActividadService {

  constructor(private http: HttpClient) { }

  crearRegistroActividad(registroActividad : RegistroActividadEntidad): Observable<RespuestaGeneral>{
    return this.http.post<RespuestaGeneral>(RUTA_PRINCIPAL + CREAR_REGISTRO_ACTIVIDAD, registroActividad);
  }
}
