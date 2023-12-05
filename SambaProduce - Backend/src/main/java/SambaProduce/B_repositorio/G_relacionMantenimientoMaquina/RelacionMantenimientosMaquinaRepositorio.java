package SambaProduce.B_repositorio.G_relacionMantenimientoMaquina;

import SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface RelacionMantenimientosMaquinaRepositorio extends
        JpaRepository<RelacionMantenimientosMaquinaEntidad, Integer> {

    @Query(value = "SELECT rmm.* FROM relacion_mantenimientos_maquina_samba rmm\n" +
            "JOIN maquinaria_samba mqs ON mqs.maquinaria_id = rmm.maquinaria_id\n" +
            "JOIN mantenimientos_samba mts ON mts.mantenimientos_id = rmm.mantenimientos_id\n" +
            "WHERE mqs.maquinaria_id = :maquinariaId AND mts.mantenimientos_id = :mantenimientoId\n" +
            "ORDER BY rmm.relacion_mantenimientos_maquina_id DESC LIMIT 1;", nativeQuery = true)
    Optional<RelacionMantenimientosMaquinaEntidad> buscarUltimaRelacionPorMantenimientoMaquina(
            @Param("maquinariaId") Integer maquinariaId,
            @Param("mantenimientoId") Integer mantenimientoId);


    @Query(value =  "WITH RankedRelations AS (SELECT rmm.*, ROW_NUMBER() OVER \n" +
                    "(PARTITION BY rmm.maquinaria_id, rmm.mantenimientos_id \n" +
                    "ORDER BY rmm.relacion_mantenimientos_maquina_id DESC) AS RowNum\n" +
                    "FROM relacion_mantenimientos_maquina_samba rmm\n" +
                    "JOIN maquinaria_samba mqs ON mqs.maquinaria_id = rmm.maquinaria_id\n" +
                    "JOIN mantenimientos_samba mts ON mts.mantenimientos_id = rmm.mantenimientos_id\n" +
                    "WHERE mqs.maquinaria_id = :idMaquinaria) SELECT relacion_mantenimientos_maquina_id, maquinaria_id,\n" +
                    "mantenimientos_id, relacion_mantenimientos_maquina_hora, \n" +
                    "relacion_mantenimientos_maquina_estado FROM RankedRelations\n" +
                    "WHERE RowNum = 1 ORDER BY relacion_mantenimientos_maquina_id;", nativeQuery = true)
    List<RelacionMantenimientosMaquinaEntidad> buscarMantenimientosPorMaquina(@Param("idMaquinaria") Integer idMaquinaria);
}