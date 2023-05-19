package ar.edu.utn.frba.dds.sugerencias;

import java.util.List;

public class ProveedorDeMotor {

  MotorSugerencias motorSugerencias;
  ProveedorClima proveedorClima;

  public ProveedorDeMotor(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public MotorSugerencias getMotorSugerencias() {
    return motorSugerencias;
  }

  public void setMotorSugerencias(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public List<Sugerencia> generarSugerencia(Usuario usuario, ProveedorClima proveedorClima){

    return  this.motorSugerencias.crearSugerencias(usuario, proveedorClima);
  }




}
