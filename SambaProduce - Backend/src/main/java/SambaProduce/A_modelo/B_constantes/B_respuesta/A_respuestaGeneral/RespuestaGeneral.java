package SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RespuestaGeneral implements Serializable {
    public String mensaje;
    public String mensajeIndicativo;
    public Object objectoRespuesta;
    public Integer objectoId;
    public Integer codigoEstado;
}