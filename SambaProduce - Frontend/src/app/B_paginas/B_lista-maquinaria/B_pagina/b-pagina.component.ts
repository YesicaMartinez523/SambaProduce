import { Component } from '@angular/core';
import { GuardarLocalIdCategoriaService } from 'src/app/C_sevicios/C_guardarLocalIdCategoria/guardar-local-id-categoria.service';

@Component({
  selector: 'app-b-pagina',
  templateUrl: './b-pagina.component.html',
  styleUrls: ['./b-pagina.component.scss']
})
export class BPaginaComponent {
  idCategoria!: number;

  constructor(private guardarLocalIdCategoriaService: GuardarLocalIdCategoriaService){
    this.guardarLocalIdCategoria();
  }
  
  guardarLocalIdCategoria(){
    const ID_CATEGORIA = this.guardarLocalIdCategoriaService.obtenerIdCategoria();
    if (ID_CATEGORIA !== null) {
      this.idCategoria = parseInt(ID_CATEGORIA, 10);
    } else {
      this.idCategoria = 0;
    }
  }

  enviarCategoriaId(categoriaId : number){
    const NUMERO = categoriaId.toString();
    this.guardarLocalIdCategoriaService.guardarIdCategoria(NUMERO)

    const ID_CATEGORIA = this.guardarLocalIdCategoriaService.obtenerIdCategoria();
    if (ID_CATEGORIA !== null) {
      this.idCategoria = parseInt(ID_CATEGORIA, 10);
    } else {
      this.idCategoria = 0;
    }
  }
}