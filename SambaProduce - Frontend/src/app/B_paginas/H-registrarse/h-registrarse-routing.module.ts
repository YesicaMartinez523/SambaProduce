import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HPaginaComponent } from './H_pagina/h-pagina.component';

const routes: Routes = [
  {path: '', component: HPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HRegistrarseRoutingModule { }
