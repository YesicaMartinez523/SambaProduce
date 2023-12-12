import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioEntidad } from 'src/app/A_modelo/A_dominios/G_usuario/UsuarioEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import rutaImagenes from 'src/app/A_modelo/B_constantes/C_rutaImagen/rutaImagenes';
import { IngresarUsuarioService } from 'src/app/C_sevicios/J_ingresarUsuario/ingresar-usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-a-seccion-uno',
  templateUrl: './a-seccion-uno.component.html',
  styleUrls: ['./a-seccion-uno.component.scss']
})
export class ASeccionUnoComponent{
  imageLogo = rutaImagenes.IMAGE_LOGO;
  users:FormGroup;
  userModel!:UsuarioEntidad;

  constructor(private userCreate: IngresarUsuarioService, private formUser: FormBuilder, private router: Router){
    this.users = this.formUser.group({
      usuarioNombre: ['', [Validators.required]],
      usuarioApellido:['', [Validators.required]],
      usuarioEmail: ['', [Validators.required, Validators.email]],
      usuarioContrasenia: ['', [Validators.required]],
      usuarioNumeroTelefono: ['', [Validators.required]],
      usuarioIdentificacion: ['', [Validators.required]]
    })
  }

  createUser(){
    this.userModel = {
      usuarioId:0, 
      usuarioNombre:this.users.get("usuarioNombre")?.value,
      usuarioApellido: this.users.get("usuarioApellido")?.value,
      usuarioEmail:this.users.get("usuarioEmail")?.value,
      usuarioContrasenia: this.users.get("usuarioContrasenia")?.value,
      usuarioNumeroTelefono: this.users.get("usuarioNumeroTelefono")?.value,
      usuarioIdentificacion:this.users.get("usuarioIdentificacion")?.value
    }

    this.userCreate.ingresarUsuarios(this.userModel).subscribe(
      (res: RespuestaGeneral) => {
        console.log(res);
        Swal.fire(
          '',
          'Usuario creado con exito',
          'success',
        )
        this.router.navigateByUrl( '/iniciar-sesion')
      }
    );
  }
}