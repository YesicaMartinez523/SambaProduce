import { Component } from '@angular/core';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';

@Component({
  selector: 'app-d-seccion-cuatro',
  templateUrl: './d-seccion-cuatro.component.html',
  styleUrls: ['./d-seccion-cuatro.component.scss']
})
export class DSeccionCuatroComponent {
  imgUno = rutaImagenes.IMAGE_C1;
  imgDos = rutaImagenes.IMAGE_C2;
  imgTres = rutaImagenes.IMAGE_C3;
}