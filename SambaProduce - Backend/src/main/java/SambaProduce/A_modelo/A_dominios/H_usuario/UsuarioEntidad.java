package SambaProduce.A_modelo.A_dominios.H_usuario;

import jakarta.persistence.*;
import lombok.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario_samba")
public class UsuarioEntidad {

        @Id
        @Column(name = "usuario_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer usuarioId;

        @Column(name = "usuario_nombre")
        private String usuarioNombre;

        @Column(name = "usuario_apellido")
        private String usuarioApellido;

        @Column(name = "usuario_email")
        private String usuarioEmail;

        @Column(name = "usuario_contrasenia")
        private String usuarioContrasenia;

        @Column(name = "usuario_numero")
        private String usuarioNumeroTelefono;

        @Column(name = "usuario_identificacion")
        private String usuarioIdentificacion;
    }

