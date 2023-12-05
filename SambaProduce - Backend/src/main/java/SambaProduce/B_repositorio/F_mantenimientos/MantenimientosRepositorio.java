package SambaProduce.B_repositorio.F_mantenimientos;

import SambaProduce.A_modelo.A_dominios.F_mantenimientos.MantenimientosEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientosRepositorio extends JpaRepository<MantenimientosEntidad, Integer> {
    @Query(value =  "WITH RankedRelations AS (SELECT mts.*, ROW_NUMBER() OVER \n" +
                    "(PARTITION BY rmm.maquinaria_id, rmm.mantenimientos_id \n" +
                    "ORDER BY rmm.relacion_mantenimientos_maquina_id DESC) AS RowNum\n" +
                    "FROM relacion_mantenimientos_maquina_samba rmm\n" +
                    "JOIN maquinaria_samba mqs ON mqs.maquinaria_id = rmm.maquinaria_id\n" +
                    "JOIN mantenimientos_samba mts ON mts.mantenimientos_id = rmm.mantenimientos_id\n" +
                    "WHERE mqs.maquinaria_id = :maquinariaId) SELECT mantenimientos_id, mantenimientos_nombre, \n" +
                    "mantenimientos_descripcion, mantenimientos_hora_fija  FROM RankedRelations\n" +
                    "WHERE RowNum = 1 ORDER BY mantenimientos_id;", nativeQuery = true)
    List<MantenimientosEntidad> listaMantenimientosEntidad(@Param("maquinariaId") Integer maquinariaId);
}