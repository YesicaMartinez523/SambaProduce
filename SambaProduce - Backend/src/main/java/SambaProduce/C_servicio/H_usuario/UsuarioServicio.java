package SambaProduce.C_servicio.H_usuario;

import SambaProduce.A_modelo.A_dominios.H_usuario.UsuarioEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.B_repositorio.H_usuario.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public ResponseEntity<RespuestaGeneral> crearUsuario (UsuarioEntidad usuarioEntidad) {
        try {
            Optional<UsuarioEntidad> usuarioExiste =
                    this.usuarioRepositorio.findById(usuarioEntidad.getUsuarioId());
            if (usuarioExiste.isEmpty()) {
               this.usuarioRepositorio.save(usuarioEntidad);
                return RespuestaConstruida.OPERACION_EXITOSA(
                        null,
                        RespuestaInformacion.CREADO_EXITOSAMENTE,
                        null
                );
            } else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.CREADO_FALLIDA);
            }
        } catch (Exception e) {
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    public ResponseEntity<RespuestaGeneral> servicioUsuario (UsuarioEntidad usuarioEntidad) {
        try {
            List<UsuarioEntidad> usuarioExiste =
                    this.usuarioRepositorio.findByUsuarioEmail(usuarioEntidad.getUsuarioEmail());
            if (!usuarioExiste.isEmpty()) {
                for (UsuarioEntidad usuario : usuarioExiste){
                    if (usuario.getUsuarioEmail().equals(usuarioEntidad.getUsuarioEmail()) &&
                            usuario.getUsuarioContrasenia().equals(usuarioEntidad.getUsuarioContrasenia())){
                        return RespuestaConstruida.OPERACION_EXITOSA(
                                RespuestaInformacion.OPERACION_EXITOSA,
                                RespuestaInformacion.LOGIN_CORRECTAMENTE,
                                null
                        );
                    } else {
                        return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LOGIN_FALLIDA);
                    }
                }
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LOGIN_FALLIDA);
            } else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.CREADO_FALLIDA);
            }
        } catch (Exception e) {
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }
}

