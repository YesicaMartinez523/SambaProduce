package SambaProduce.B_repositorio.E_registroMantenimientos;

import SambaProduce.A_modelo.A_dominios.E_registroMantenimientos.RegistroMantenimientosEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMantenimientosRepositorio extends JpaRepository<RegistroMantenimientosEntidad, Integer> { }