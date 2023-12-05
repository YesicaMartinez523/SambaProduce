import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CRegistroActividadRoutingModule } from './c-registro-actividad-routing.module';
import { CPaginaComponent } from './C_pagina/c-pagina.component';
import { ASeccionUnoComponent } from './C_pagina/C_componentes/A_seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './C_pagina/C_componentes/B_seccion-dos/b-seccion-dos.component';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';
import { HttpClientModule } from '@angular/common/http';
import { LeerMaquinariaPorIdService } from 'src/app/C_sevicios/E_leerMaquinariaPorId/leer-maquinaria-por-id.service';
import { LeerImplementosService } from 'src/app/C_sevicios/F_leerImplementos/leer-implementos.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CrearRegistroActividadService } from 'src/app/C_sevicios/G_crearRegistroActividad/crear-registro-actividad.service';


@NgModule({
  declarations: [
    CPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent
  ],
  imports: [
    CommonModule,
    CRegistroActividadRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    GuardarLocalIdMaquinariaService,
    LeerMaquinariaPorIdService,
    LeerImplementosService,
    CrearRegistroActividadService
  ]
})
export class CRegistroActividadModule { }
