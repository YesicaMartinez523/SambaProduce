import { Component, OnInit } from '@angular/core';
import { RegistroActividadEntidad } from 'src/app/A_modelo/A_dominios/C_registroActividad/RegistroActividadEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import { LeerRegistrosActividadService } from 'src/app/C_sevicios/H_leerRegistrosActividad/leer-registros-actividad.service';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent implements OnInit{

  listaRegistroActividad: RegistroActividadEntidad [] = [];

  constructor(private leerRegistrosActividadService: LeerRegistrosActividadService){}

  ngOnInit(): void {
    this.leerRegistrosActividad();
  }

  leerRegistrosActividad(){
    this.leerRegistrosActividadService.leerRegistrosActividad().subscribe(
      (res: RespuestaGeneral) => {
        for (let registroActividad of res.objectoRespuesta){
          this.listaRegistroActividad.push(registroActividad);
        }
      }
    );
  }

  eliminarRegistroActividad(i : number){
    console.log("Eliminar Registro Id " + this.listaRegistroActividad[i].registroActividadId);
  }
}