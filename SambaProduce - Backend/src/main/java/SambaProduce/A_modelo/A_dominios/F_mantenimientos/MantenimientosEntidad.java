package SambaProduce.A_modelo.A_dominios.F_mantenimientos;

import SambaProduce.A_modelo.A_dominios.E_registroMantenimientos.RegistroMantenimientosEntidad;
import SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaEntidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mantenimientos_samba")
public class MantenimientosEntidad {

    @Id
    @Column(name = "mantenimientos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mantenimientosId;

    @Column(name = "mantenimientos_nombre")
    private String mantenimientosNombre;

    @Column(name = "mantenimientos_descripcion")
    private String mantenimientosDescripcion;

    @Column(name = "mantenimientos_hora_fija")
    private Integer mantenimientosHoraFija;

    @OneToMany(mappedBy = "mantenimientosEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<RegistroMantenimientosEntidad> listaRegistrosMantenimientos;

    @OneToMany(mappedBy = "mantenimientosEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<RelacionMantenimientosMaquinaEntidad> listaRelacionMantenimientosMaquina;
}