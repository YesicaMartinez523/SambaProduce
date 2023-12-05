import { Component, OnInit } from '@angular/core';
import { MaquinariaEntidad } from 'src/app/A_modelo/A_dominios/B_maquinaria/MaquinariaEntidad';
import { MantenimientosEntidad } from 'src/app/A_modelo/A_dominios/F_mantenimientos/MantenimietosEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';
import { LeerMaquinariaPorIdService } from 'src/app/C_sevicios/E_leerMaquinariaPorId/leer-maquinaria-por-id.service';
import { LeerMantenimientosPorMaquinaService } from 'src/app/C_sevicios/I_leerMantenimientosPorMaquina/leer-mantenimientos-por-maquina.service';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent implements OnInit{

  idMaquinaria!: number;
  maquinaria!: MaquinariaEntidad;
  listaMantenimientos: MantenimientosEntidad [] = [];
  indicesActivados: number[] = [];
  textEstado: string = ' oo ';
  Contador: number = 0;
  isChecked = false;

  constructor(private guardarLocalIdMaquinariaService: GuardarLocalIdMaquinariaService,
              private leerMaquinariaPorIdService: LeerMaquinariaPorIdService,
              private leerMantenimientosPorMaquinaService: LeerMantenimientosPorMaquinaService){}

  ngOnInit(): void {
    this.guardarLocalIdMaquinaria();
    this.leerMaquinariaPorId();
    this.leerMantenimientosPorMaquina();
  }

  guardarLocalIdMaquinaria(){
    const ID_MAQUINARIA = this.guardarLocalIdMaquinariaService.obtenerIdMaquinaria();
    if (ID_MAQUINARIA !== null) {
      this.idMaquinaria = parseInt(ID_MAQUINARIA, 10);
    } else {
      this.idMaquinaria = 0;
    }
  }

  leerMaquinariaPorId(){
    this.leerMaquinariaPorIdService.leerMaquinariaPorId(this.idMaquinaria).subscribe(
      (res: RespuestaGeneral) => {
        this.maquinaria = res.objectoRespuesta;
      }
    );
  }

  leerMantenimientosPorMaquina(){
    this.leerMantenimientosPorMaquinaService.leerMantenimientosPorMaquina(this.idMaquinaria).subscribe(
      (res: RespuestaGeneral) => {
        for (let mantenimiento of res.objectoRespuesta){
          this.listaMantenimientos.push(mantenimiento);
        }
      }
    );
  }

  toggleCheck() {
    this.isChecked = !this.isChecked;
  }

  mostrarInformacion(index: number) {
    if (this.indicesActivados.includes(index)) {
            this.indicesActivados = this.indicesActivados.filter(i => i !== index);
    } else {
      this.indicesActivados.push(index);
    }
  }

  seleccionarMantenimientos(index: number) {
      console.log("Prueba de checkbox "+index)
  }
}