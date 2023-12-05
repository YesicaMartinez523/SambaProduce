package SambaProduce.D_controlador.D_implementos;

import SambaProduce.A_modelo.B_constantes.A_URL.D_implementos.ImplementosURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.D_implementos.ImplementosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ImplementosURL.RUTA_PRINCIPAL)
public class ImplementosControlador {

    @Autowired
    private ImplementosServicio implementosServicio;

    @GetMapping(ImplementosURL.LEER_IMPLEMENTOS)
    public ResponseEntity<RespuestaGeneral> leerImplementos(){
        return this.implementosServicio.leerImplementos();
    }
}