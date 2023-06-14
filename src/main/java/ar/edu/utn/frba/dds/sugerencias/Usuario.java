package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import ar.edu.utn.frba.dds.propuestas.Propuesta;
import ar.edu.utn.frba.dds.servicio_meteorologico.AsesorDeImagen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Usuario {
  int edad;
  ProveedorDeMotor proveedor;
  AsesorDeImagen asesorDeImagen;

  Set<Guardarropas> guardarropas;

  public Usuario(Integer edad, ProveedorDeMotor proveedorDeMotor) {
    this.edad = edad;
    this.proveedor = proveedorDeMotor;
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



  public int getEdad() {
    return edad;
  }

  List<Sugerencia> generarSugerencias() {

    return this.proveedor.crearSugerencias(this, asesorDeImagen);

  }

}

