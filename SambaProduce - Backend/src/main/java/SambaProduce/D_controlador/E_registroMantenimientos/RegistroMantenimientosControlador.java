package SambaProduce.D_controlador.E_registroMantenimientos;

import SambaProduce.A_modelo.A_dominios.E_registroMantenimientos.RegistroMantenimientosEntidad;
import SambaProduce.A_modelo.B_constantes.A_URL.E_registroMantenimientos.RegistroMantenimientoURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.E_registroMantenimientos.RegistroMantenimientosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RegistroMantenimientoURL.RUTA_PRINCIPAL)
public class RegistroMantenimientosControlador {

    @Autowired
    private RegistroMantenimientosServicio registroMantenimientosServicio;

    @PostMapping(RegistroMantenimientoURL.CREAR_REGISTRO_MANTENIMIENTO)
    public ResponseEntity<RespuestaGeneral> crearRegistroMantenimientos (
            @RequestBody RegistroMantenimientosEntidad registroMantenimientosEntidad){
        return this.registroMantenimientosServicio.crearRegistroMantenimientos(registroMantenimientosEntidad);
    }

    @GetMapping(RegistroMantenimientoURL.LEER_REGISTRO_MANTENIMIENTO)
    public ResponseEntity<RespuestaGeneral> leerMantenimientosPorMaquina(@PathVariable Integer maquinariaId){
        return this.registroMantenimientosServicio.leerMantenimientosPorMaquina(maquinariaId);
    }
}