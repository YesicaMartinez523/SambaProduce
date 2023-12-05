package SambaProduce.D_controlador.C_registroActividad;

import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import SambaProduce.A_modelo.B_constantes.A_URL.C_registroActividad.RegistroActividadURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.C_registroActividad.RegistroActividadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RegistroActividadURL.RUTA_PRINCIPAL)
public class RegistroActividadControlador {

    @Autowired
    private RegistroActividadServicio registroActividadServicio;

    @PostMapping(RegistroActividadURL.CREAR_REGISTRO_ACTIVIDAD)
    public ResponseEntity<RespuestaGeneral> crearRegistroActividad(@RequestBody RegistroActividadEntidad registroActividadEntidad) {
        return this.registroActividadServicio.crearRegistroActividad(registroActividadEntidad);
    }

    @GetMapping(RegistroActividadURL.LEER_REGISTRO_ACTIVIDAD)
    public ResponseEntity<RespuestaGeneral> leerRegistroActividadPorId(@PathVariable Integer registroActividadId) {
        return this.registroActividadServicio.leerRegistroActividadPorId(registroActividadId);
    }

    @GetMapping(RegistroActividadURL.LEER_REGISTROS_ACTIVIDAD)
    public ResponseEntity<RespuestaGeneral> leerRegistrosActividad() {
        return this.registroActividadServicio.leerRegistrosActividad();
    }
}