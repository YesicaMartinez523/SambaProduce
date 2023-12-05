package SambaProduce.A_modelo.A_dominios.A_tipoCategoria;

import SambaProduce.A_modelo.A_dominios.B_maquinaria.MaquinariaEntidad;
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
@Table(name = "tipo_categoria_samba")
public class TipoCategoriaEntidad {

    @Id
    @Column(name = "tipo_categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipoCategoriaId;

    @Column(name = "tipo_categoria_nombre")
    private String tipoCategoriaNombre;

    @Column(name = "tipo_categoria_estado")
    private String tipoCategoriaEstado;

    @OneToMany(mappedBy = "tipoCategoriaEntidad")
    @JsonManagedReference
    @JsonIgnore
    private List<MaquinariaEntidad> listaMaquinaria;
}