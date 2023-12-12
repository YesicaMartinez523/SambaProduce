package SambaProduce.D_controlador.F_usuario;

import SambaProduce.A_modelo.A_dominios.H_usuario.UsuarioEntidad;
import SambaProduce.A_modelo.B_constantes.A_URL.G_usuario.UsuariosURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.H_usuario.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UsuariosURL.BASE_URL_USUARIO)
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping(UsuariosURL.CREAR_USER)
    public ResponseEntity<RespuestaGeneral> crearUsuario (
            @RequestBody UsuarioEntidad usuarioEntidad){
        return this.usuarioServicio.crearUsuario(usuarioEntidad);
    }

    @PostMapping(UsuariosURL.SERVICIO_VALIDACION_USUARIO)
    public ResponseEntity<RespuestaGeneral> servicioUsuario (
            @RequestBody UsuarioEntidad usuarioEntidad){
        return this.usuarioServicio.servicioUsuario(usuarioEntidad);
    }
}

