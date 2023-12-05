package SambaProduce.C_servicio.D_implementos;

import SambaProduce.A_modelo.A_dominios.D_implementos.ImplementosEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.B_repositorio.D_implementos.ImplementosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImplementosServicio {

    @Autowired
    private ImplementosRepositorio implementosRepositorio;

    public ResponseEntity<RespuestaGeneral> leerImplementos() {
        try {
            List<ImplementosEntidad> listaImplementos = this.implementosRepositorio.findAll();
            if (!listaImplementos.isEmpty()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        listaImplementos,
                        RespuestaInformacion.LECTURA_CORRECTAMENTE,
                        null
                );
            }
            else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LECTURA_FALLIDA);
            }
        } catch (Exception e) {
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }
}