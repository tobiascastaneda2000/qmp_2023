package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.servicio_meteorologico.Guardarropas;

import java.util.List;
import java.util.Set;

public class UsuarioGuardarropas {
  List<Propuesta> propuestas;
  Set<Guardarropas> guardarropas;

  public void recibirPropuestaAgregar(Guardarropas guardarropas, Prenda prenda) {
    propuestas.add(new PropuestaAgregar(guardarropas, prenda));
  }

  public void recibirPropuestaQuitar(Guardarropas guardarropas, Prenda prenda) {
    propuestas.add(new PropuestaQuitar(guardarropas, prenda));
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.aplicarPropuesta();
    propuestas.remove(propuesta);
  }

  public void rechazarPropuesta(Propuesta propuesta) {
    propuestas.remove(propuesta);
  }

  public void agregarGuardarropaCompartido(Guardarropas guardarropa, Set<UsuarioGuardarropas> usuarios) {
    this.agregarGuardarropa(guardarropa);
    usuarios.forEach(u -> u.agregarGuardarropa(guardarropa));
  }

  private void agregarGuardarropa(Guardarropas guardarropa) {
    guardarropas.add(guardarropa);
  }
}
