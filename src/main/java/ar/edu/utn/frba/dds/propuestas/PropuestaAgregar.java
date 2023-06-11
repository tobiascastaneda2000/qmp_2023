package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

public class PropuestaAgregar implements Propuesta{
  Guardarropas guardarropas;
  Prenda prenda;
  public PropuestaAgregar(Guardarropas guardarropas, Prenda prenda) {
    this.guardarropas = guardarropas;
    this.prenda = prenda;
  }


  public void aceptar(){
    guardarropas.agregarPrenda(prenda);;
  }

  public void rechazar(){
    guardarropas.removerPropuesta(this);
  }

  public void deshacerEn(Guardarropas guardarropas){
    guardarropas.quitarPrenda(prenda);
  }

}
