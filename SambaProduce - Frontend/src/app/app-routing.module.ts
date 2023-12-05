import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/tipo-categoria', pathMatch: 'full' },
  { path: 'tipo-categoria', loadChildren: () =>import('./B_paginas/A_tipo-categoria/a-tipo-categoria.module').then( m => m.ATipoCategoriaModule)},
  { path: 'lista-maquinaria', loadChildren: () =>import('./B_paginas/B_lista-maquinaria/b-lista-maquinaria.module').then( m => m.BListaMaquinariaModule)},
  { path: 'registro-actividad', loadChildren: () =>import('./B_paginas/C_registro-actividad/c-registro-actividad.module').then( m => m.CRegistroActividadModule)},
  { path: 'lista-registro-actividad', loadChildren: () =>import('./B_paginas/D_lista-registro-actividad/d-lista-registro-actividad.module').then( m => m.DListaRegistroActividadModule)},
  { path: 'registro-mantenimiento', loadChildren: () =>import('./B_paginas/E_registro-mantenimiento/e-registro-mantenimiento.module').then( m => m.ERegistroMantenimientoModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
