import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FPaginaComponent } from './F_pagina/f-pagina.component';

const routes: Routes = [
  {path:'', component: FPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FIndexPrincipalRoutingModule { }
