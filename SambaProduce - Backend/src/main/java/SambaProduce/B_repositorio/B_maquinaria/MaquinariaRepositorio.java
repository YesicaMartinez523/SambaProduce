package SambaProduce.B_repositorio.B_maquinaria;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaquinariaRepositorio extends JpaRepository<MaquinariaEntidad, Integer> {

    @Query(value =  "SELECT ms.* FROM maquinaria_samba ms \n" +
                    "JOIN tipo_categoria_samba tcs ON ms.tipo_categoria_id = tcs.tipo_categoria_id\n" +
                    "WHERE ms.tipo_categoria_id = :categoriaId", nativeQuery = true)
    List<MaquinariaEntidad> leerListaMaquinariaPorIdCategoria (@Param("categoriaId") Integer categoriaId);
}