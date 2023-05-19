package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

  List<Prenda> prendas = new ArrayList<>();
  int edad;
  MotorSugerencias motorSugerencias;

  public Usuario(Integer edad, MotorSugerencias motor) {
    this.edad = edad;
    this.motorSugerencias = motor;
  }

  public int getEdad() {
    return edad;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  List<Sugerencia> generarSugerencias() {

    return this.motorSugerencias.generarSugerencias(this);
  }


}

