package SambaProduce.C_servicio.G_relacionMantenimientosMaquina;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import SambaProduce.A_modelo.A_dominios.F_mantenimientos.MantenimientosEntidad;
import SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.A_modelo.B_constantes.C_enum.Estado;
import SambaProduce.B_repositorio.B_maquinaria.MaquinariaRepositorio;
import SambaProduce.B_repositorio.C_registroActividad.RegistroActividadRepositorio;
import SambaProduce.B_repositorio.F_mantenimientos.MantenimientosRepositorio;
import SambaProduce.B_repositorio.G_relacionMantenimientoMaquina.RelacionMantenimientosMaquinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RelacionMantenimientosMaquinaServicio {

    @Autowired
    private RelacionMantenimientosMaquinaRepositorio relacionMantenimientosMaquinaRepositorio;
    @Autowired
    private RegistroActividadRepositorio registroActividadRepositorio;
    @Autowired
    private MantenimientosRepositorio mantenimientosRepositorio;
    @Autowired
    private MaquinariaRepositorio maquinariaRepositorio;

    public ResponseEntity<RespuestaGeneral> crearRelacionMantenimientoMaquina(RegistroActividadEntidad registroActividadEntidad) {
        try {
            List<MantenimientosEntidad> listaMantenimientosEntidad = mantenimientosRepositorio.findAll();

            for (MantenimientosEntidad mantenimiento : listaMantenimientosEntidad) {
                Optional<RelacionMantenimientosMaquinaEntidad> relacionMantenimientosMaquinaEntidad =
                        this.relacionMantenimientosMaquinaRepositorio.buscarUltimaRelacionPorMantenimientoMaquina(
                                registroActividadEntidad.getMaquinariaEntidad().getMaquinariaId(),
                                mantenimiento.getMantenimientosId()
                        );

                if (relacionMantenimientosMaquinaEntidad.isPresent()) {
                    procesarRelacionExistente(
                            relacionMantenimientosMaquinaEntidad.get(),
                            mantenimiento,
                            registroActividadEntidad.getRegistroActividadHora(),
                            registroActividadEntidad.getMaquinariaEntidad()
                    );
                } else {
                    procesarRelacionNoExistente(
                            mantenimiento,
                            registroActividadEntidad.getRegistroActividadHora(),
                            registroActividadEntidad.getMaquinariaEntidad()
                    );
                }
            }
            return RespuestaConstruida.OPERACION_EXITOSA(
                    null,
                    RespuestaInformacion.CREADO_EXITOSAMENTE,
                    null);
        } catch (Exception e) {
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    private void procesarRelacion(MantenimientosEntidad mantenimiento,
                                  Integer registroHora,
                                  MaquinariaEntidad maquinariaEntidad,
                                  String estado) {

        RelacionMantenimientosMaquinaEntidad nuevaRelacion = new RelacionMantenimientosMaquinaEntidad();
        nuevaRelacion.setRelacionMantenimientosMaquinaHora(registroHora);
        nuevaRelacion.setRelacionMantenimientosMaquinaEstado(estado);
        nuevaRelacion.setMaquinariaEntidad(maquinariaEntidad);
        nuevaRelacion.setMantenimientosEntidad(mantenimiento);

        relacionMantenimientosMaquinaRepositorio.save(nuevaRelacion);
    }

    private void procesarRelacionExistente(RelacionMantenimientosMaquinaEntidad relacionEntidad,
                                           MantenimientosEntidad mantenimiento,
                                           Integer registroHora,
                                           MaquinariaEntidad maquinariaEntidad) {
        Integer horas = relacionEntidad.getRelacionMantenimientosMaquinaHora() - registroHora;
        Integer diferenciaHora = horas - mantenimiento.getMantenimientosHoraFija();

        if (diferenciaHora > 0 && diferenciaHora <= 50) {
            procesarRelacion(mantenimiento, registroHora, maquinariaEntidad, Estado.PENDIENTE);
        } else if (diferenciaHora <= 0) {
            procesarRelacion(mantenimiento, registroHora, maquinariaEntidad, Estado.URGENTE);
        }
    }

    private void procesarRelacionNoExistente(MantenimientosEntidad mantenimiento,
                                             Integer registroHora,
                                             MaquinariaEntidad maquinariaEntidad) {
        Integer diferenciaHora = mantenimiento.getMantenimientosHoraFija() - registroHora;

        if (diferenciaHora > 0 && diferenciaHora <= 50) {
            procesarRelacion(mantenimiento, registroHora, maquinariaEntidad, Estado.PENDIENTE);
        } else if (diferenciaHora <= 0) {
            procesarRelacion(mantenimiento, registroHora, maquinariaEntidad, Estado.URGENTE);
        }
    }
}