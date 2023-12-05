package SambaProduce.B_repositorio.D_implementos;

import SambaProduce.A_modelo.A_dominios.D_implementos.ImplementosEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplementosRepositorio extends JpaRepository<ImplementosEntidad, Integer> {
}