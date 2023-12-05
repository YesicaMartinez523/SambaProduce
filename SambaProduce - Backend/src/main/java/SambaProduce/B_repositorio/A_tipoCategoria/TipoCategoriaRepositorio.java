package SambaProduce.B_repositorio.A_tipoCategoria;

import SambaProduce.A_modelo.A_dominios.A_tipoCategoria.TipoCategoriaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCategoriaRepositorio extends JpaRepository<TipoCategoriaEntidad, Integer> {
}