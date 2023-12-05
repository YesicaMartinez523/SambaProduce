import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ATipoCategoriaRoutingModule } from './a-tipo-categoria-routing.module';
import { APaginaComponent } from './A_pagina/a-pagina.component';
import { ASeccionUnoComponent } from './A_pagina/A_componentes/A_seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './A_pagina/A_componentes/B_seccion-dos/b-seccion-dos.component';
import { LeerTipoCategoriasServiceService } from 'src/app/C_sevicios/A_leerTipoCategorias/leer-tipo-categorias-service.service';
import { HttpClientModule } from '@angular/common/http';
import { CSeccionTresComponent } from './A_pagina/A_componentes/C_seccion-tres/c-seccion-tres.component';
import { GuardarLocalIdCategoriaService } from 'src/app/C_sevicios/C_guardarLocalIdCategoria/guardar-local-id-categoria.service';


@NgModule({
  declarations: [
    APaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent,
    CSeccionTresComponent
  ],
  imports: [
    CommonModule,
    ATipoCategoriaRoutingModule,
    HttpClientModule
  ],
  providers: [
    LeerTipoCategoriasServiceService,
    GuardarLocalIdCategoriaService
  ]
})
export class ATipoCategoriaModule { }
