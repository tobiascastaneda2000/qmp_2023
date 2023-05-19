package ar.edu.utn.frba.dds.sugerencias;

import java.util.List;

public class ProveedorDeMotor {

  MotorSugerencias motorSugerencias;

  public ProveedorDeMotor(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public MotorSugerencias getMotorSugerencias() {
    return motorSugerencias;
  }

  public void setMotorSugerencias(MotorSugerencias motorSugerencias) {
    this.motorSugerencias = motorSugerencias;
  }

  public List<Sugerencia> generarSugerenciasPrendas(Usuario usuario){
    return  this.motorSugerencias.generarSugerencias(usuario);
  }




}
