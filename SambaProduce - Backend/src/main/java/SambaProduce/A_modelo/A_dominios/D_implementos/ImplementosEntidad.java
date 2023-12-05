package SambaProduce.A_modelo.A_dominios.D_implementos;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "implementos_samba")
public class ImplementosEntidad {

    @Id
    @Column(name = "implementos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer implementosId;

    @Column(name = "implementos_nombre")
    private String implementosNombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registro_actividad_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "registroActividadId")
    @JsonIgnore
    private RegistroActividadEntidad registroActividadEntidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maquinaria_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maquinariaId")
    @JsonIgnore
    private MaquinariaEntidad maquinariaEntidad;
}