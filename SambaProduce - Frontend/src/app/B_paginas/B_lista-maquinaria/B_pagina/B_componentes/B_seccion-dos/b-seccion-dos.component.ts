import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TipoCategoriaEntidad } from 'src/app/A_modelo/A_dominios/A_tipoCategoria/TipoCategoriaEntidad';
import { MaquinariaEntidad } from 'src/app/A_modelo/A_dominios/B_maquinaria/MaquinariaEntidad';
import { RespuestaGeneral } from 'src/app/A_modelo/B_constantes/B_respuesta/RespuestaGeneral';
import { LeerTipoCategoriasServiceService } from 'src/app/C_sevicios/A_leerTipoCategorias/leer-tipo-categorias-service.service';
import { LeerListaMaquinariaPorIdCategoriaServiceService } from 'src/app/C_sevicios/B_leerMaquinariaPorTipoCategoria/leer-lista-maquinaria-por-id-categoria-service.service';
import { GuardarLocalIdMaquinariaService } from 'src/app/C_sevicios/D_guardarLocalIdMaquinaria/guardar-local-id-maquinaria.service';

@Component({
  selector: 'app-b-seccion-dos',
  templateUrl: './b-seccion-dos.component.html',
  styleUrls: ['./b-seccion-dos.component.scss']
})
export class BSeccionDosComponent implements OnInit, OnChanges{

  @Input() idCategoria!: number;
  @Output() enviarCategoriaId = new EventEmitter<number>();

  tipoCategoria!: TipoCategoriaEntidad;
  listaMaquinaria : MaquinariaEntidad [] =  [];
  tipoCategoriaEntidad:TipoCategoriaEntidad [] = [];
  categoriaFormulario!: FormGroup;
  textEstado: string = ' oo ';

  constructor(private leerListaMaquinariaPorIdCategoriaService: LeerListaMaquinariaPorIdCategoriaServiceService,
              private leerTipoCategoriasService: LeerTipoCategoriasServiceService,
              private guardarLocalIdMaquinariaService: GuardarLocalIdMaquinariaService,
              public formulario: FormBuilder) {
    this.categoriaFormulario = formulario.group({
      idCategoria: ['', [Validators.required]]
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.leerListaMaquinariaPorIdCategoria();
  }

  ngOnInit(): void {
    this.leerTipoCategorias();
  }

  leerTipoCategorias(){
    this.leerTipoCategoriasService.leerTodasCategorias().subscribe(
      (res: RespuestaGeneral) => {
        for(let categoria of res.objectoRespuesta){
          this.tipoCategoriaEntidad.push(categoria);
        }
      }
    );
  }
  
  leerListaMaquinariaPorIdCategoria(){
    this.listaMaquinaria = []
    this.leerListaMaquinariaPorIdCategoriaService.leerListaMaquinariaPorIdCategoria(this.idCategoria).subscribe(
      (res: RespuestaGeneral) => {
        for (let maquinaria of res.objectoRespuesta){
          this.listaMaquinaria.push(maquinaria);
        }
      }
    );
  }

  enviarIdCategoria(){
    this.tipoCategoria = this.categoriaFormulario.controls['idCategoria'].value;
    const NUMERO = this.tipoCategoria.tipoCategoriaId;
    this.enviarCategoriaId.emit(NUMERO);
  }

  guardarLocalIdMaquinaria(i : number){
    const NUMERO = this.listaMaquinaria[i].maquinariaId;
    const ID_MAQUINARIA = NUMERO.toString();
    this.guardarLocalIdMaquinariaService.guardarIdMaquinaria(ID_MAQUINARIA);
  }
}