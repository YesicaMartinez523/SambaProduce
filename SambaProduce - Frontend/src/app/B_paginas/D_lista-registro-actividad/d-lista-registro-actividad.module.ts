import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DListaRegistroActividadRoutingModule } from './d-lista-registro-actividad-routing.module';
import { DPaginaComponent } from './D_pagina/d-pagina.component';
import { ASeccionUnoComponent } from './D_pagina/D_componentes/A_seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './D_pagina/D_componentes/B_seccion-dos/b-seccion-dos.component';
import { LeerRegistrosActividadService } from 'src/app/C_sevicios/H_leerRegistrosActividad/leer-registros-actividad.service';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    DPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent
  ],
  imports: [
    CommonModule,
    DListaRegistroActividadRoutingModule,
    HttpClientModule
  ],
  providers: [
    LeerRegistrosActividadService
  ]
})
export class DListaRegistroActividadModule { }
