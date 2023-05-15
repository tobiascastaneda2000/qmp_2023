package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;

public final class Sugerencia {
 Prenda prendaSuperior;
 Prenda prendaInferior;
 Prenda prendaCalzado;

 Sugerencia(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado){
     this.prendaSuperior = prendaSuperior;
     this.prendaInferior = prendaInferior;
     this.prendaCalzado = prendaCalzado;
 }
}
