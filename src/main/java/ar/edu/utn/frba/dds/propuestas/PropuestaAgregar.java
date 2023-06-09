package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

public class PropuestaAgregar implements Propuesta{
  Guardarropas guardarropas;
  Prenda prenda;
  public PropuestaAgregar(Guardarropas guardarropas, Prenda prenda) {
    this.guardarropas = guardarropas;
    this.prenda = prenda;
  }

  public void aplicarPropuesta(){
    guardarropas.agregarPrenda(prenda);
  }
}
