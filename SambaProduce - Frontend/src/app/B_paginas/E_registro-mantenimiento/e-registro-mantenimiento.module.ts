import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ERegistroMantenimientoRoutingModule } from './e-registro-mantenimiento-routing.module';
import { EPaginaComponent } from './E_pagina/e-pagina.component';
import { ASeccionUnoComponent } from './E_pagina/E_componentes/A_seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './E_pagina/E_componentes/B_seccion-dos/b-seccion-dos.component';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';
import { LeerMaquinariaPorIdService } from 'src/app/C_sevicios/E_leerMaquinariaPorId/leer-maquinaria-por-id.service';
import { HttpClientModule } from '@angular/common/http';
import { CSeccionTresComponent } from './E_pagina/E_componentes/C_seccion-tres/c-seccion-tres.component';
import { LeerMantenimientosPorMaquinaService } from 'src/app/C_sevicios/I_leerMantenimientosPorMaquina/leer-mantenimientos-por-maquina.service';


@NgModule({
  declarations: [
    EPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent,
    CSeccionTresComponent
  ],
  imports: [
    CommonModule,
    ERegistroMantenimientoRoutingModule,
    HttpClientModule
  ],
  providers: [
    GuardarLocalIdMaquinariaService,
    LeerMaquinariaPorIdService,
    LeerMantenimientosPorMaquinaService
  ]
})
export class ERegistroMantenimientoModule { }
