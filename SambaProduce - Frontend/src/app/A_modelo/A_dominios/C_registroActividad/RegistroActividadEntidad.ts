import { MaquinariaEntidad } from "../B_maquinaria/MaquinariaEntidad";

export interface RegistroActividadEntidad {
    registroActividadId: number;
    registroActividadFecha: string;
    registroActividadOperario: string;
    registroActividadTrabajoRealizado: string;
    registroActividadSitioTrabajo: string;
    registroActividadEventualidades: string;
    registroActividadHora: number;
    maquinariaEntidad: MaquinariaEntidad;
}