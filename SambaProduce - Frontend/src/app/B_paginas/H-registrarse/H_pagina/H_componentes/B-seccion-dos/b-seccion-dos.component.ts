import { Component } from '@angular/core';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent {
  imageRegister = rutaImagenes.IMAGE_REGISTER;
}
