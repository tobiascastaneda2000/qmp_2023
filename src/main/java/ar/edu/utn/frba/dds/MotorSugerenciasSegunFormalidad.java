package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import com.google.common.collect.Lists;

import java.util.List;

class MotorSugerenciasSegunFormalidad implements MotorSugerencias {

  List<Prenda> getPrendasValidas(Usuario usuario){
    return usuario.getEdad() > 55 ? usuario.getPrendas().stream().filter(p -> !p.isInformal()).toList() : usuario.getPrendas();
  }

  public List<Sugerencia> generarSugerencias(Usuario usuario){
    List<Prenda> prendasSuperiores = getPrendasValidas(usuario).stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = getPrendasValidas(usuario).stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = getPrendasValidas(usuario).stream().filter(Prenda::esCalzado).toList();

    //Uso una biblioteca como Guava para el producto cartesiano
    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).toList();
  }

}
