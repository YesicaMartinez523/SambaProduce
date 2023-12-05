import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { APaginaComponent } from './A_pagina/a-pagina.component';

const routes: Routes = [
  {path:'', component: APaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ATipoCategoriaRoutingModule { }
