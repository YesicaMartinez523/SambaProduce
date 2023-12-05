import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EPaginaComponent } from './E_pagina/e-pagina.component';

const routes: Routes = [
  {path:'', component: EPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ERegistroMantenimientoRoutingModule { }
