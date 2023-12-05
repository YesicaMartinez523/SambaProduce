package SambaProduce.C_servicio.C_registroActividad;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.B_repositorio.B_maquinaria.MaquinariaRepositorio;
import SambaProduce.B_repositorio.C_registroActividad.RegistroActividadRepositorio;
import SambaProduce.C_servicio.B_maquinaria.MaquinariaServicio;
import SambaProduce.C_servicio.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroActividadServicio {

    @Autowired
    private RelacionMantenimientosMaquinaServicio relacionMantenimientosMaquinaServicio;
    @Autowired
    private MaquinariaServicio maquinariaServicio;
    @Autowired
    private RegistroActividadRepositorio registroActividadRepositorio;
    @Autowired
    private MaquinariaRepositorio maquinariaRepositorio;

    public ResponseEntity<RespuestaGeneral> crearRegistroActividad(RegistroActividadEntidad registroActividadEntidad) {
        try {
            Optional<RegistroActividadEntidad> registroActividadEntidadExiste =
                    this.registroActividadRepositorio.findById(registroActividadEntidad.getRegistroActividadId());
            if (registroActividadEntidadExiste.isEmpty()) {
                Optional<MaquinariaEntidad> maquinariaEntidad =
                        this.maquinariaRepositorio.findById(registroActividadEntidad.getMaquinariaEntidad().getMaquinariaId());
                registroActividadEntidad.setMaquinariaEntidad(maquinariaEntidad.get());
                this.registroActividadRepositorio.save(registroActividadEntidad);
                this.relacionMantenimientosMaquinaServicio.crearRelacionMantenimientoMaquina(registroActividadEntidad);
                //probrar esta parte
                this.maquinariaServicio.leerMaquinariaPorId(registroActividadEntidad.getMaquinariaEntidad().getMaquinariaId());
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

    public ResponseEntity<RespuestaGeneral> leerRegistroActividadPorId(Integer registroActividadId) {
        try {
            Optional<RegistroActividadEntidad> registroActividadEntidad =
                    this.registroActividadRepositorio.findById(registroActividadId);
            if (registroActividadEntidad.isPresent()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        registroActividadEntidad.get(),
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

    public ResponseEntity<RespuestaGeneral> leerRegistrosActividad() {
        try {
            List<RegistroActividadEntidad> listaRegistroActividadEntidad =
                    this.registroActividadRepositorio.findAll();
            if (!listaRegistroActividadEntidad.isEmpty()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        listaRegistroActividadEntidad,
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