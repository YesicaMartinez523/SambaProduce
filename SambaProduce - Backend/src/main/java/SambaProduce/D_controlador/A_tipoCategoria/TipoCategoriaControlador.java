package SambaProduce.D_controlador.A_tipoCategoria;

import SambaProduce.A_modelo.B_constantes.A_URL.A_tipoCategoria.TipoCategoriaURL;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.C_servicio.A_tipoCategoria.TipoCategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TipoCategoriaURL.RUTA_PRINCIPAL)
public class TipoCategoriaControlador {

    @Autowired
    private TipoCategoriaServicio tipoCategoriaServicio;

    @GetMapping(TipoCategoriaURL.LEER_CATEGORIA_ID)
    public ResponseEntity<RespuestaGeneral> leerTipoCategoriaPorId (@PathVariable Integer tipoCategoriaId){
        return this.tipoCategoriaServicio.leerTipoCategoriaPorId(tipoCategoriaId);
    }

    @GetMapping(TipoCategoriaURL.LEER_CATEGORIAS)
    public ResponseEntity<RespuestaGeneral> leerTodasCategorias (){
        return this.tipoCategoriaServicio.leerTodasCategorias();
    }
}