import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FIndexPrincipalRoutingModule } from './f-index-principal-routing.module';
import { FPaginaComponent } from './F_pagina/f-pagina.component';
import { ASeccionUnoComponent } from './F_pagina/F_componentes/A-seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './F_pagina/F_componentes/B-seccion-dos/b-seccion-dos.component';
import { CSeccionTresComponent } from './F_pagina/F_componentes/C-seccion-tres/c-seccion-tres.component';
import { DSeccionCuatroComponent } from './F_pagina/F_componentes/D-seccion-cuatro/d-seccion-cuatro.component';
import { ESeccionCincoComponent } from './F_pagina/F_componentes/E-seccion-cinco/e-seccion-cinco.component';
import { InicioDeSesionService } from 'src/app/C_sevicios/K_inicioDeSesion/inicio-de-sesion.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    FPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent,
    CSeccionTresComponent,
    DSeccionCuatroComponent,
    ESeccionCincoComponent
  ],
  imports: [
    CommonModule,
    FIndexPrincipalRoutingModule
  ]
})
export class FIndexPrincipalModule { }