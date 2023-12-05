package SambaProduce.A_modelo.A_dominios.C_registroActividad;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
import SambaProduce.A_modelo.A_dominios.D_implementos.ImplementosEntidad;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "registro_actividad_samba")
public class RegistroActividadEntidad {

    @Id
    @Column(name = "registro_actividad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registroActividadId;

    @Column(name = "registro_actividad_fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registroActividadFecha;

    @Column(name = "registro_actividad_operario")
    private String registroActividadOperario;

    @Column(name = "registro_actividad_trabajo_realizado")
    private String registroActividadTrabajoRealizado;

    @Column(name = "registro_actividad_sitio_trabajo")
    private String registroActividadSitioTrabajo;

    @Column(name = "registro_actividad_eventualidades")
    private String registroActividadEventualidades;

    @Column(name = "registro_actividad_hora")
    private Integer registroActividadHora;

    @ManyToOne()
    @JoinColumn(name = "maquinaria_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maquinariaId")
    private MaquinariaEntidad maquinariaEntidad;

    @OneToMany(mappedBy = "registroActividadEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<ImplementosEntidad> listaImplementos;
}