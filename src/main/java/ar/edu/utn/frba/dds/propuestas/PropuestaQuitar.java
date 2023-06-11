package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.Arrays;

public class PropuestaQuitar implements Propuesta{


  Guardarropas guardarropas;
  Prenda prenda;

  public PropuestaQuitar(Guardarropas guardarropas, Prenda prenda) {
    this.guardarropas = guardarropas;
    this.prenda = prenda;
  }


  public void aceptar(){
    guardarropas.quitarPrenda(prenda);;
  }

  public void rechazar(){
    guardarropas.removerPropuesta(this);
  }

  public void deshacerEn(Guardarropas guardarropas){
    guardarropas.agregarPrenda(prenda);
  }


}
