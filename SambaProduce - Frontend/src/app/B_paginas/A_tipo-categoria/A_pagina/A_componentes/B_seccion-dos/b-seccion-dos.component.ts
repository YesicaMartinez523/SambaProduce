import { Component } from '@angular/core';
import { TipoCategoriaEntidad } from 'src/app/A_modelo/A_dominios/A_tipoCategoria/TipoCategoriaEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';
import { LeerTipoCategoriasServiceService } from 'src/app/C_sevicios/A_leerTipoCategorias/leer-tipo-categorias-service.service';
import { GuardarLocalIdCategoriaService } from 'src/app/C_sevicios/C_guardarLocalIdCategoria/guardar-local-id-categoria.service';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent {
  imageN1 = rutaImagenes.IMAGE_N1;
  imageLogo = rutaImagenes.IMAGE_LOGO;
  
  tipoCategoriaEntidad:TipoCategoriaEntidad [] = [];
  
  constructor(private leerTipoCategoriasService: LeerTipoCategoriasServiceService,
    private guardarLocalIdCategoriaService: GuardarLocalIdCategoriaService){
    this.leerTipoCategorias();
  }

  leerTipoCategorias(){
    this.leerTipoCategoriasService.leerTodasCategorias().subscribe(
      (res: RespuestaGeneral) => {
        for(let categoria of res.objectoRespuesta){
          this.tipoCategoriaEntidad.push(categoria);
        }
      }
    );
  }

  enviarIdCategoria( id : number ){
    const NUMERO = (id + 1);
    const ID_CATEGORIA = NUMERO.toString();
    this.guardarLocalIdCategoriaService.guardarIdCategoria(ID_CATEGORIA);
  }
}