package SambaProduce.A_modelo.B_constantes.B_respuesta.C_respuestaConstruida;

import SambaProduce.A_modelo.B_constantes.B_respuesta.A_respuestaGeneral.RespuestaGeneral;
import SambaProduce.A_modelo.B_constantes.B_respuesta.B_respuestaInformacion.RespuestaInformacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespuestaConstruida {

    public static ResponseEntity<RespuestaGeneral> OPERACION_EXITOSA (Object objectoRespuesta,
                                                                     String mensajeIndicativo,
                                                                     Integer objectoId) {
        return ResponseEntity.ok(RespuestaGeneral.builder()
                .mensaje(RespuestaInformacion.OPERACION_EXITOSA)
                .mensajeIndicativo(mensajeIndicativo)
                .objectoRespuesta(objectoRespuesta)
                .objectoId(objectoId)
                .codigoEstado(HttpStatus.OK.value())
                .build());
    }

    public static ResponseEntity<RespuestaGeneral> OPERACION_FALLIDA (String mensajeIndicativo) {
        return ResponseEntity.badRequest().body(RespuestaGeneral.builder()
                .mensaje(RespuestaInformacion.OPERACION_FALLIDA)
                .mensajeIndicativo(mensajeIndicativo)
                .objectoRespuesta(null)
                .objectoId(null)
                .codigoEstado(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    public static ResponseEntity<RespuestaGeneral> ERROR_INTERNO () {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(RespuestaGeneral.builder()
                        .mensaje(RespuestaInformacion.ERROR_INTERNO_SERVIDOR)
                        .mensajeIndicativo(RespuestaInformacion.ERROR_INTERNO)
                        .codigoEstado(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build());
    }
}