package SambaProduce.D_controlador.B_maquinaria;

import SambaProduce.A_modelo.B_constantes.A_URL.B_maquinaria.MaquinariaURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.B_maquinaria.MaquinariaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MaquinariaURL.RUTA_PRINCIPAL)
public class MaquinariaControlador {

    @Autowired
    private MaquinariaServicio maquinariaServicio;

    @GetMapping(MaquinariaURL.LEER_MAQUINARIA_ID)
    public ResponseEntity<RespuestaGeneral> leerMaquinariaPorId(@PathVariable Integer maquinariaId) {
        return this.maquinariaServicio.leerMaquinariaPorId(maquinariaId);
    }

    @GetMapping(MaquinariaURL.LEER_MAQUINARIA_CATEGORIA_ID)
    public ResponseEntity<RespuestaGeneral> leerListaMaquinariaPorIdCategoria (@PathVariable Integer categoriaId){
        return this.maquinariaServicio.leerListaMaquinariaPorIdCategoria(categoriaId);
    }
}