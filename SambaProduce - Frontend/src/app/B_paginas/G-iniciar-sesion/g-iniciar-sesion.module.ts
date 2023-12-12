import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GIniciarSesionRoutingModule } from './g-iniciar-sesion-routing.module';
import { GPaginaComponent } from './G-pagina/g-pagina.component';
import { ASeccionUnoComponent } from './G-pagina/G_componentes/A-seccion-uno/a-seccion-uno.component';
import { BSeccionDosComponent } from './G-pagina/G_componentes/B-seccion-dos/b-seccion-dos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { IngresarUsuarioService } from 'src/app/C_sevicios/J_ingresarUsuario/ingresar-usuario.service';
import { InicioDeSesionService } from 'src/app/C_sevicios/K_inicioDeSesion/inicio-de-sesion.service';

@NgModule({
  declarations: [
    GPaginaComponent,
    ASeccionUnoComponent,
    BSeccionDosComponent,
  ],
  imports: [
    CommonModule,
    GIniciarSesionRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    InicioDeSesionService
  ]
})
export class GIniciarSesionModule { }
