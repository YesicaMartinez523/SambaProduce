import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ASeccionUnoComponent } from './H_pagina/H_componentes/A-seccion-uno/a-seccion-uno.component';
import { HPaginaComponent } from './H_pagina/h-pagina.component';
import { HRegistrarseRoutingModule } from './h-registrarse-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { IngresarUsuarioService } from 'src/app/C_sevicios/J_ingresarUsuario/ingresar-usuario.service';
import { BSeccionDosComponent } from './H_pagina/H_componentes/B-seccion-dos/b-seccion-dos.component';


@NgModule({
  declarations: [
    HPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent
  ],
  imports: [
    CommonModule,
    HRegistrarseRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    IngresarUsuarioService
  ]
})
export class HRegistrarseModule { }
