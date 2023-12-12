import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';
import { USUARIO_SERVICIO } from 'src/app/A_modelo/B_constantes/A_URL/F_usuario/usuarioURL';
import { IngresarUsuarioService } from 'src/app/C_sevicios/J_ingresarUsuario/ingresar-usuario.service';
import { InicioDeSesionService } from 'src/app/C_sevicios/K_inicioDeSesion/inicio-de-sesion.service';
import { UsuarioEntidad } from 'src/app/A_modelo/A_dominios/G_usuario/UsuarioEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';


@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent {
  imageLogo = rutaImagenes.IMAGE_LOGO;
  usuarios: FormGroup;
  usuario!: UsuarioEntidad;

  constructor(private userServiceService: InicioDeSesionService, private formUser: FormBuilder, private router: Router){
    this.usuarios = this.formUser.group({
      usuarioEmail: ['', [Validators.required, Validators.email]],
      usuarioContrasenia: ['', [Validators.required]]
    })
  }
  

  iniciarSesion(){
    this.usuario = {
      usuarioId: 0, 
      usuarioNombre: '', 
      usuarioApellido: '',
      usuarioEmail:  this.usuarios.get("usuarioEmail")?.value,
      usuarioContrasenia: this.usuarios.get("usuarioContrasenia")?.value,
      usuarioNumeroTelefono: '',
      usuarioIdentificacion: ''
    }


    this.userServiceService.usuarioServicio(this.usuario).subscribe(
      (res: RespuestaGeneral) => {
        if(res.mensajeIndicativo == 'OK se Inicio Sesion correctamente'){
          this.router.navigateByUrl('/tipo-categoria');
        }
      }
    );
    
  }
}

