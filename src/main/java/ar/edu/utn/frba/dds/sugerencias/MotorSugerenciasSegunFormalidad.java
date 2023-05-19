package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.List;

class MotorSugerenciasSegunFormalidad implements MotorSugerencias {

  public List<Prenda> getPrendasValidas(Usuario usuario){
    return usuario.getEdad() > 55 ? usuario.getPrendas().stream().filter(p -> !p.isInformal()).toList() : usuario.getPrendas();
  }

}
