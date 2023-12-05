import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CPaginaComponent } from './C_pagina/c-pagina.component';

const routes: Routes = [
  {path:'', component: CPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CRegistroActividadRoutingModule { }
