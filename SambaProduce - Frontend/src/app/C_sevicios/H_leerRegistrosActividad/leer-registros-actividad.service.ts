import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LEER_REGISTROS_ACTIVIDAD, RUTA_PRINCIPAL } from 'src/app/A_modelo/B_constantes/A_URL/C_registroActividad/RegistroActividadURL';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';

@Injectable({
  providedIn: 'root'
})
export class LeerRegistrosActividadService {

  constructor(private http: HttpClient) { }

  leerRegistrosActividad():Observable<RespuestaGeneral>{
    return this.http.get<RespuestaGeneral>(RUTA_PRINCIPAL + LEER_REGISTROS_ACTIVIDAD);
  }
}
