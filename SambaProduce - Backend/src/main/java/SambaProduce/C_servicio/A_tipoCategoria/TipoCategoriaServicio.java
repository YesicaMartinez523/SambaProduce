package SambaProduce.C_servicio.A_tipoCategoria;

import SambaProduce.A_modelo.A_dominios.A_tipoCategoria.TipoCategoriaEntidad;
import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaEntidad;
import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida.RespuestaConstruida;
import SambaProduce.A_modelo.B_constantes.C_enum.Estado;
import SambaProduce.B_repositorio.A_tipoCategoria.TipoCategoriaRepositorio;
import SambaProduce.B_repositorio.B_maquinaria.MaquinariaRepositorio;
import SambaProduce.B_repositorio.G_relacionMantenimientoMaquina.RelacionMantenimientosMaquinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCategoriaServicio {

    @Autowired
    private TipoCategoriaRepositorio tipoCategoriaRepositorio;
    @Autowired
    private MaquinariaRepositorio maquinariaRepositorio;
    @Autowired
    private RelacionMantenimientosMaquinaRepositorio relacionMantenimientosMaquinaRepositorio;


    public ResponseEntity<RespuestaGeneral> leerTipoCategoriaPorId (Integer tipoCategoriaId){
        try {
            Optional<TipoCategoriaEntidad> tipoCategoriaEntidad = this.tipoCategoriaRepositorio.findById(tipoCategoriaId);
            if (tipoCategoriaEntidad.isPresent()){

                return RespuestaConstruida.OPERACION_EXITOSA(
                        tipoCategoriaEntidad.get(),
                        RespuestaInformacion.LECTURA_CORRECTAMENTE,
                        null);
            }else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LECTURA_FALLIDA);
            }
        }catch (Exception e){
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    public ResponseEntity<RespuestaGeneral> leerTodasCategorias (){
        try {
            verificarEstadoMaquinaria();
            List<TipoCategoriaEntidad> listaTipoCategoriaEntidad = this.tipoCategoriaRepositorio.findAll();
            if (!listaTipoCategoriaEntidad.isEmpty()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        listaTipoCategoriaEntidad,
                        RespuestaInformacion.LECTURA_CORRECTAMENTE,
                        null);
            }else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LECTURA_FALLIDA);
            }
        }catch (Exception e){
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    public void verificarEstadoMaquinaria() {

        List<MaquinariaEntidad> listaMaquinaria = this.maquinariaRepositorio.findAll();

        for (MaquinariaEntidad maquinaria: listaMaquinaria){
            List<RelacionMantenimientosMaquinaEntidad> relacionMantenimientosMaquinaEntidad =
                    this.relacionMantenimientosMaquinaRepositorio.buscarMantenimientosPorMaquina(maquinaria.getMaquinariaId());
            for (RelacionMantenimientosMaquinaEntidad mantenimientosMaquina : relacionMantenimientosMaquinaEntidad) {
                String estado = mantenimientosMaquina.getRelacionMantenimientosMaquinaEstado();
                if (estado.equals(Estado.URGENTE)) {
                    maquinaria.setMaquinariaEstado(Estado.URGENTE);
                    crearEstadoMaquinariaYCategoria(maquinaria, Estado.URGENTE);
                } else if (estado.equals(Estado.PENDIENTE)) {
                    maquinaria.setMaquinariaEstado(Estado.PENDIENTE);
                    crearEstadoMaquinariaYCategoria(maquinaria, Estado.PENDIENTE);
                }
            }
        }
    }

    public void crearEstadoMaquinariaYCategoria (MaquinariaEntidad maquinariaEntidad, String estado){
        try {
            Optional<TipoCategoriaEntidad> tipoCategoriaEntidad =
                    this.tipoCategoriaRepositorio.findById(maquinariaEntidad.getTipoCategoriaEntidad().getTipoCategoriaId());
            tipoCategoriaEntidad.get().setTipoCategoriaEstado(estado);
            this.tipoCategoriaRepositorio.save(tipoCategoriaEntidad.get());
            this.maquinariaRepositorio.save(maquinariaEntidad);
        }catch (Exception e){}
    }
}