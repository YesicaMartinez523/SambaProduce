import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BListaMaquinariaRoutingModule } from './b-lista-maquinaria-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ASeccionUnoComponent } from './B_pagina/B_componentes/A_seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './B_pagina/B_componentes/B_seccion-dos/b-seccion-dos.component';
import { BPaginaComponent } from './B_pagina/b-pagina.component';
import { LeerListaMaquinariaPorIdCategoriaServiceService } from 'src/app/C_sevicios/B_leerMaquinariaPorTipoCategoria/leer-lista-maquinaria-por-id-categoria-service.service';
import { LeerTipoCategoriasServiceService } from 'src/app/C_sevicios/A_leerTipoCategorias/leer-tipo-categorias-service.service';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';


@NgModule({
  declarations: [
    BPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent
  ],
  imports: [
    CommonModule,
    BListaMaquinariaRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [
    LeerListaMaquinariaPorIdCategoriaServiceService,
    LeerTipoCategoriasServiceService,
    GuardarLocalIdMaquinariaService
  ]
})
export class BListaMaquinariaModule { }