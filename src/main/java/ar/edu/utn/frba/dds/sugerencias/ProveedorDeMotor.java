package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.servicio_meteorologico.AsesorDeImagen;

import java.util.List;

public class ProveedorDeMotor {

  MotorSugerencias motorSugerencias;
  AsesorDeImagen asesorDeImagen;

  public ProveedorDeMotor(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public MotorSugerencias getMotorSugerencias() {
    return motorSugerencias;
  }

  public void setMotorSugerencias(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public List<Sugerencia> crearSugerencias(Usuario usuario, AsesorDeImagen asesorDeImagen){

    return  this.motorSugerencias.devolverSugerencias(usuario, asesorDeImagen);
  }




}
