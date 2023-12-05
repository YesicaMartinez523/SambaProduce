import { Component } from '@angular/core';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';

@Component({
  selector: 'app-a-seccion-uno',
  templateUrl: './a-seccion-uno.component.html',
  styleUrls: ['./a-seccion-uno.component.scss']
})
export class ASeccionUnoComponent {
  imageLogo = rutaImagenes.IMAGE_LOGO;

  activarCerrar: boolean = true;

  activarCerrarSesion(){
    this.activarCerrar = !this.activarCerrar;
  }
}