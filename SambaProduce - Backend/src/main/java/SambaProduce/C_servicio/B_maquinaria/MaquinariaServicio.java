package SambaProduce.C_servicio.B_maquinaria;

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
public class MaquinariaServicio {

    @Autowired
    private MaquinariaRepositorio maquinariaRepositorio;
    @Autowired
    private RelacionMantenimientosMaquinaRepositorio mantenimientosMaquinaRepositorio;
    @Autowired
    private TipoCategoriaRepositorio tipoCategoriaRepositorio;


    public ResponseEntity<RespuestaGeneral> leerMaquinariaPorId(Integer maquinariaId) {
        try {
            Optional<MaquinariaEntidad> maquinariaEntidad = this.maquinariaRepositorio.findById(maquinariaId);
            if (maquinariaEntidad.isPresent()){

                List<RelacionMantenimientosMaquinaEntidad> listaRelacionMantenimientosMaquina =
                        this.mantenimientosMaquinaRepositorio.buscarMantenimientosPorMaquina(maquinariaId);

                return RespuestaConstruida.OPERACION_EXITOSA(
                        verificarEstadoMaquinaria(maquinariaEntidad.get(), listaRelacionMantenimientosMaquina),
                        RespuestaInformacion.LECTURA_CORRECTAMENTE,
                        null);
            }else {
                return RespuestaConstruida.OPERACION_FALLIDA(RespuestaInformacion.LECTURA_FALLIDA);
            }
        }catch (Exception e){
            return RespuestaConstruida.ERROR_INTERNO();
        }
    }

    public MaquinariaEntidad verificarEstadoMaquinaria(MaquinariaEntidad maquinariaEntidad,
                                                   List<RelacionMantenimientosMaquinaEntidad> listaRelacionMantenimientosMaquina) {

        for (RelacionMantenimientosMaquinaEntidad mantenimientosMaquina : listaRelacionMantenimientosMaquina) {

            String estado = mantenimientosMaquina.getRelacionMantenimientosMaquinaEstado();

            if (estado.equals(Estado.URGENTE)) {
                maquinariaEntidad.setMaquinariaEstado(Estado.URGENTE);
                crearEstadoMaquinariaYCategoria(maquinariaEntidad, Estado.URGENTE);
                return maquinariaEntidad;
            } else if (estado.equals(Estado.PENDIENTE)) {
                maquinariaEntidad.setMaquinariaEstado(Estado.PENDIENTE);
                crearEstadoMaquinariaYCategoria(maquinariaEntidad, Estado.PENDIENTE);
                return maquinariaEntidad;
            }
        }
        return maquinariaEntidad;
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

    public ResponseEntity<RespuestaGeneral> leerListaMaquinariaPorIdCategoria (Integer categoriaId){
        try {
            List<MaquinariaEntidad> listaMaquinariaEntidad =
                    this.maquinariaRepositorio.leerListaMaquinariaPorIdCategoria(categoriaId);
            if (!listaMaquinariaEntidad.isEmpty()){
                return RespuestaConstruida.OPERACION_EXITOSA(
                        listaMaquinariaEntidad,
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