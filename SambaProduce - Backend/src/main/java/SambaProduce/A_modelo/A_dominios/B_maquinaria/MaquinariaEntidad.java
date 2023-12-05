package SambaProduce.A_modelo.A_dominios.B_maquinaria;

import SambaProduce.A_modelo.A_dominios.A_tipoCategoria.TipoCategoriaEntidad;
import SambaProduce.A_modelo.A_dominios.C_registroActividad.RegistroActividadEntidad;
import SambaProduce.A_modelo.A_dominios.D_implementos.ImplementosEntidad;
import SambaProduce.A_modelo.A_dominios.E_registroMantenimientos.RegistroMantenimientosEntidad;
import SambaProduce.A_modelo.A_dominios.G_relacionMantenimientosMaquina.RelacionMantenimientosMaquinaEntidad;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "maquinaria_samba")
public class MaquinariaEntidad {

    @Id
    @Column(name = "maquinaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maquinariaId;

    @Column(name = "maquinaria_nombre")
    private String maquinariaNombre;

    @Column(name = "maquinaria_placa")
    private String maquinariaPlaca;

    @Column(name = "maquinaria_combustible")
    private String maquinariaCombustible;

    @Column(name = "maquinaria_color")
    private String maquinariaColor;

    @Column(name = "maquinaria_marca")
    private String maquinariaMarca;

    @Column(name = "maquinaria_hora")
    private Integer maquinariaHora;

    @Column(name = "maquinaria_estado")
    private String maquinariaEstado;

    @ManyToOne()
    @JoinColumn(name = "tipo_categoria_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tipoCategoriaId")
    @JsonIgnore
    private TipoCategoriaEntidad tipoCategoriaEntidad;

    @OneToMany(mappedBy = "maquinariaEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<ImplementosEntidad> listaImplementos;

    @OneToMany(mappedBy = "maquinariaEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<RegistroActividadEntidad> listaRegistrosActividad;

    @OneToMany(mappedBy = "maquinariaEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<RegistroMantenimientosEntidad> listaRegistrosMantenimientos;

    @OneToMany(mappedBy = "maquinariaEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<RelacionMantenimientosMaquinaEntidad> listaRelacionMantenimientosMaquina;
}