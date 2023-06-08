package ar.edu.utn.frba.dds.servicio_meteorologico;

import ar.edu.utn.frba.dds.prenda.Prenda;

public class Atuendo {

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda calzado;

  public void setPrendaSuperior(Prenda prendaSuperior) {
    this.prendaSuperior = prendaSuperior;
  }

  public void setCalzado(Prenda calzado) {
    this.calzado = calzado;
  }

  public void setPrendaInferior(Prenda prendaInferior) {
    this.prendaInferior = prendaInferior;
  }

  public boolean aptaParaTemperatura(int temperatura) {
    return prendaSuperior.esAptaParaTemperatura(temperatura)
        && prendaInferior.esAptaParaTemperatura(temperatura)
        && calzado.esAptaParaTemperatura(temperatura);

  }


}
