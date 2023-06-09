package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.servicio_meteorologico.AsesorDeImagen;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

  List<Prenda> prendas = new ArrayList<>();
  int edad;
  ProveedorDeMotor proveedor;
  AsesorDeImagen asesorDeImagen;

  public Usuario(Integer edad, ProveedorDeMotor proveedorDeMotor) {
    this.edad = edad;
    this.proveedor = proveedorDeMotor;
  }

  public int getEdad() {
    return edad;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  List<Sugerencia> generarSugerencias() {

    return this.proveedor.crearSugerencias(this, asesorDeImagen);

  }

}

