package SambaProduce.B_repositorio.C_registroActividad;

import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroActividadRepositorio extends JpaRepository<RegistroActividadEntidad, Integer> {

    @Query(value =  "SELECT ras.*\n" +
                    "FROM registro_actividad_samba ras\n" +
                    "JOIN maquinaria_samba ms ON ms.maquinaria_id = ras.maquinaria_id\n" +
                    "WHERE ras.maquinaria_id = :maquinariaId\n" +
                    "ORDER BY ras.registro_actividad_id DESC LIMIT 1;", nativeQuery = true)
    Optional<RegistroActividadEntidad> ultimoRegistroActividadPorMaquinaria (@Param("maquinariaId") Integer maquinariaId);
}