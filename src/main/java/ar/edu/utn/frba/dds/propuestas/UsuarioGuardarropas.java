package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class UsuarioGuardarropas {
  public List<Propuesta> getPropuestas() {
    return propuestas;
  }

  public void setPropuestas(List<Propuesta> propuestas) {
    this.propuestas = propuestas;
  }

  List<Propuesta> propuestas;

  public Set<Guardarropas> getGuardarropas() {
    return guardarropas;
  }

  Set<Guardarropas> guardarropas;

  public UsuarioGuardarropas() {
    this.propuestas = new ArrayList<>();
    this.guardarropas = new HashSet<>();
  }
/*
  public List<Prenda> getPrendas(){
    return this.guardarropas.stream().flatMap(guardarropas -> guardarropas.getPrendas());
  }*/

  public void recibirPropuestaAgregar(Guardarropas guardarropas, Prenda prenda) {
    guardarropas.validarPrendaParaAgregar(prenda);
    propuestas.add(new PropuestaAgregar(guardarropas, prenda));
  }

  public void recibirPropuestaQuitar(Guardarropas guardarropas, Prenda prenda) {
    guardarropas.validarPrendaParaQuitar(prenda);
    propuestas.add(new PropuestaQuitar(guardarropas, prenda));
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    if(!getPropuestas().contains(propuesta)){
      throw new NoExistePropuestaException("No existe la propuesta");
    }
    else {
      propuesta.aplicarPropuesta();
      propuestas.remove(propuesta);
    }

  }

  public void rechazarPropuesta(Propuesta propuesta) {
    if(!getPropuestas().contains(propuesta)){
      throw new NoExistePropuestaException("No existe la propuesta");
    }
    else {propuestas.remove(propuesta);}

  }


  public void agregarGuardarropa(Guardarropas guardarropa) {
    guardarropas.add(guardarropa);
  }
}
