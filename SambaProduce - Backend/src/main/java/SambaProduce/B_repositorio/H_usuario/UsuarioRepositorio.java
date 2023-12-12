package SambaProduce.B_repositorio.H_usuario;

import SambaProduce.A_modelo.A_dominios.H_usuario.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository <UsuarioEntidad, Integer> {
    List<UsuarioEntidad> findByUsuarioEmail(String usuarioEmail);
}