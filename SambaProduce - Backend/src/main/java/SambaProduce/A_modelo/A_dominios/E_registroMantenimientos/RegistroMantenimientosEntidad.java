package SambaProduce.A_modelo.A_dominios.E_registroMantenimientos;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.F_mantenimientos.MantenimientosEntidad;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "registro_mantenimientos_samba")
public class RegistroMantenimientosEntidad {

    @Id
    @Column(name = "registro_mantenimientos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registroMantenimientosId;

    @Column(name = "registro_mantenimientos_fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registroMantenimientosFecha;

    @Column(name = "registro_mantenimientos_estado")
    private String registroMantenimientosEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maquinaria_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maquinariaId")
    @JsonIgnore
    private MaquinariaEntidad maquinariaEntidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mantenimientos_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mantenimientosId")
    @JsonIgnore
    private MantenimientosEntidad mantenimientosEntidad;
}