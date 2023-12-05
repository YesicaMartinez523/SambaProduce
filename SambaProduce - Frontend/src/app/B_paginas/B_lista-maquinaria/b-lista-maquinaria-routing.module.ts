import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BPaginaComponent } from './B_pagina/b-pagina.component';

const routes: Routes = [
  {path:'', component: BPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BListaMaquinariaRoutingModule { }
