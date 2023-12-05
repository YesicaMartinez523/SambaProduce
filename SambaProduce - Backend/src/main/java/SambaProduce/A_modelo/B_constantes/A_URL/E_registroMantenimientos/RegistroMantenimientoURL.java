package SambaProduce.A_modelo.B_constantes.A_URL.E_registroMantenimientos;

public interface RegistroMantenimientoURL {
    String RUTA_PRINCIPAL = "/registro_mantenimiento";
    String CREAR_REGISTRO_MANTENIMIENTO = "/crear-registro_mantenimiento";
    String LEER_REGISTRO_MANTENIMIENTO = "/leer-registro_mantenimiento/{maquinariaId}";
    String LEER_REGISTROS_MANTENIMIENTO = "/leer-registros_mantenimiento";
}