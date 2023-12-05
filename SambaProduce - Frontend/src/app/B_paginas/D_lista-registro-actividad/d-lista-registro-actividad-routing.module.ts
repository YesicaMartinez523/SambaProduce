import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DPaginaComponent } from './D_pagina/d-pagina.component';

const routes: Routes = [
  {path:'', component: DPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DListaRegistroActividadRoutingModule { }
