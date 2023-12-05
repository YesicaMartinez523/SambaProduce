package SambaProduce.C_servicio.E_registroMantenimientos;

import SambaProduce.A_modelo.A_dominios.E_registroMantenimientos.RegistroMantenimientosEntidad;
import SambaProduce.A_modelo.A_dominios.F_mantenimientos.MantenimientosEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.B_repositorio.E_registroMantenimientos.RegistroMantenimientosRepositorio;
import SambaProduce.B_repositorio.F_mantenimientos.MantenimientosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroMantenimientosServicio {

    @Autowired
    private RegistroMantenimientosRepositorio registroMantenimientosRepositorio;
    @Autowired
    private MantenimientosRepositorio mantenimientosRepositorio;

    public ResponseEntity<RespuestaGeneral> crearRegistroMantenimientos (
            RegistroMantenimientosEntidad registroMantenimientosEntidad){
        try {
            return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.CREADO_FALLIDA);
        }catch (Exception e){
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    public ResponseEntity<RespuestaGeneral> leerMantenimientosPorMaquina(Integer maquinariaId){
        try {
            List<MantenimientosEntidad> listaMantenimientosEntidad =
                    this.mantenimientosRepositorio.listaMantenimientosEntidad(maquinariaId);
            if (!listaMantenimientosEntidad.isEmpty()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        listaMantenimientosEntidad,
                        RespuestaInformacion.LECTURA_CORRECTAMENTE,
                        null
                );
            }else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LECTURA_FALLIDA);
            }
        }catch (Exception e){
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }
}