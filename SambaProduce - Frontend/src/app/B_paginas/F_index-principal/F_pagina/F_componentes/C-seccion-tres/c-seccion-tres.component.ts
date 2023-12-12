import { Component } from '@angular/core';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';

@Component({
  selector: 'app-c-seccion-tres',
  templateUrl: './c-seccion-tres.component.html',
  styleUrls: ['./c-seccion-tres.component.scss']
})
export class CSeccionTresComponent {
  imgUno = rutaImagenes.IMAGE_C1;
  imgDos = rutaImagenes.IMAGE_C2;
  imgTres = rutaImagenes.IMAGE_C3;
}
