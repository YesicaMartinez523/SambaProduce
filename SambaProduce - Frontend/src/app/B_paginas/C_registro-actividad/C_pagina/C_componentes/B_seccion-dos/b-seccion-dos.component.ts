import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MaquinariaEntidad } from 'src/app/A_modelo/A_dominios/B_maquinaria/MaquinariaEntidad';
import { RegistroActividadEntidad } from 'src/app/A_modelo/A_dominios/C_registroActividad/RegistroActividadEntidad';
import { ImplementosEntidad } from 'src/app/A_modelo/A_dominios/D_implementos/ImplementosEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';
import { LeerMaquinariaPorIdService } from 'src/app/C_sevicios/E_leerMaquinariaPorId/leer-maquinaria-por-id.service';
import { LeerImplementosService } from 'src/app/C_sevicios/F_leerImplementos/leer-implementos.service';
import { CrearRegistroActividadService } from 'src/app/C_sevicios/G_crearRegistroActividad/crear-registro-actividad.service';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent implements OnInit{
  
  idMaquinaria!: number;
  maquinaria!: MaquinariaEntidad;
  registroActividad!: RegistroActividadEntidad;
  listaImplementos: ImplementosEntidad [] = [];
  implementoFormulario!: FormGroup;
  registroActividadFormulario!: FormGroup;
  fecha!: string;
  textEstado: string = ' oo ';

  constructor(private guardarLocalIdMaquinariaService: GuardarLocalIdMaquinariaService,
              private leerMaquinariaPorIdService: LeerMaquinariaPorIdService,
              private leerImplementosService: LeerImplementosService,
              private crearRegistroActividadService: CrearRegistroActividadService,
              private router: Router,
              public formulario: FormBuilder){
    const today = new Date();
    const year = today.getFullYear();
    const month = (today.getMonth() + 1).toString().padStart(2, '0');
    const day = today.getDate().toString().padStart(2, '0');
    this.fecha = year + '-' + month + '-' + day;

    this.implementoFormulario = formulario.group({
      implemento: ['', [Validators.required]]
    });

    this.registroActividadFormulario = formulario.group({
      nombreOperario: ['', [Validators.required]],
      lugarTrabajo: ['', [Validators.required]],
      trabajoDesempeñado: ['', [Validators.required]],
      horasTrabajadas: ['', [Validators.required]],
      combustible: ['', [Validators.required]],
      eventualidades: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.guardarLocalIdMaquinaria();
    this.leerMaquinariaPorId();
    this.leerImplementos();
  }

  guardarLocalIdMaquinaria(){
    const ID_MAQUINARIA = this.guardarLocalIdMaquinariaService.obtenerIdMaquinaria();
    if (ID_MAQUINARIA !== null) {
      this.idMaquinaria = parseInt(ID_MAQUINARIA, 10);
    } else {
      this.idMaquinaria = 0;
    }
  }

  leerMaquinariaPorId(){
    this.leerMaquinariaPorIdService.leerMaquinariaPorId(this.idMaquinaria).subscribe(
      (res: RespuestaGeneral) => {
        this.maquinaria = res.objectoRespuesta;
      }
    );
  }

  leerImplementos(){
    this.leerImplementosService.leerImplementos().subscribe(
      (res: RespuestaGeneral) => {
        for (let implemento of res.objectoRespuesta){
          this.listaImplementos.push(implemento);
        }
      }
    );
  }

  crearRegistroActividad(){


    this.registroActividad = {
      registroActividadId: 0,
      registroActividadFecha: this.fecha,
      registroActividadOperario: this.registroActividadFormulario.controls['nombreOperario'].value,
      registroActividadTrabajoRealizado: this.registroActividadFormulario.controls['trabajoDesempeñado'].value,
      registroActividadSitioTrabajo: this.registroActividadFormulario.controls['lugarTrabajo'].value,
      registroActividadEventualidades: this.registroActividadFormulario.controls['eventualidades'].value,
      registroActividadHora: this.registroActividadFormulario.controls['horasTrabajadas'].value,
      maquinariaEntidad: this.maquinaria,
    }


    this.crearRegistroActividadService.crearRegistroActividad(this.registroActividad).subscribe(
      (res: RespuestaGeneral) =>{
        if(res.codigoEstado === 200){
          this.router.navigateByUrl("lista-maquinaria")
        }
      }
    );
  }
}