import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GPaginaComponent } from './G-pagina/g-pagina.component';

const routes: Routes = [
  {path:'', component: GPaginaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GIniciarSesionRoutingModule { }
