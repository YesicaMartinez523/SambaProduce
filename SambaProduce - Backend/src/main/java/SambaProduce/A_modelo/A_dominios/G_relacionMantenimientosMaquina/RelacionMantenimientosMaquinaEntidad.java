package SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.F_mantenimientos.MantenimientosEntidad;
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
@Table(name = "relacion_mantenimientos_maquina_samba")
public class RelacionMantenimientosMaquinaEntidad {

    @Id
    @Column(name = "relacion_mantenimientos_maquina_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer relacionMantenimientosMaquinaId;

    @Column(name = "relacion_mantenimientos_maquina_hora")
    private Integer relacionMantenimientosMaquinaHora;

    @Column(name = "relacion_mantenimientos_maquina_estado")
    private String relacionMantenimientosMaquinaEstado;

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