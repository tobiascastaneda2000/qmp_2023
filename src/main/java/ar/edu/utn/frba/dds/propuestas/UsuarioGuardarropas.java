package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsuarioGuardarropas {

  Set<Guardarropas> guardarropas;

  public UsuarioGuardarropas() {
    this.guardarropas = new HashSet<>();
  }

  //GETTERS Y SETTERS

  public Set<Guardarropas> getGuardarropas() {
    return guardarropas;
  }

  //METODOS

  public void agregarGuardarropa(Guardarropas guardarropa) {
    guardarropas.add(guardarropa);
  }

  public void quitarGuadarropas(Guardarropas guardarropa) {
    guardarropas.remove(guardarropa);
  }

  public List<Prenda> getPrendas() {
    return this.guardarropas.stream()
        .flatMap(guardarropas -> guardarropas.getPrendas().stream())
        .collect(Collectors.toList());
  }

  public List<Propuesta> getPropuestas() {
    return this.guardarropas.stream()
        .flatMap(g -> g.getPropuestas().stream())
        .collect(Collectors.toList());
  }

}
