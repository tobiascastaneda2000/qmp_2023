package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.*;
import com.google.common.collect.Lists;

import java.util.List;

/*
Dependencias: Alguas mas faciles (prenda) y otras mas dificiles (motorSugerencia)
-Antes de crear mi clase, esa dependencia ya existia?
-Clase usuario va a depender de motor
Entonces va a requerir una inyecccion de dependencias, por el constructor
ar.edu.utn.frba.dds.Usuario va a depender de lo que venga de afuera
dependencia no significa necesariamente que la tengamos que instanciar
Service Locator -> SIngleton mas grande y configurable (mejor)
Desacoplar la logica de como adopto esa dependencia
CUando tengo que onbtener dependencias, las inyecots, y despues me voy apreocupar de como las voy a proveer
 */


class MotorSugerenciasBasico implements MotorSugerencias {

  //TODO no repetir esta logica
  public List<Sugerencia> generarSugerencias(Usuario usuario){
    List<Prenda> prendasSuperiores = usuario.getPrendas().stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = usuario.getPrendas().stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = usuario.getPrendas().stream().filter(Prenda::esCalzado).toList();

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).toList();
    //return combinaciones.stream().map(c -> new Sugerencia(c[0], c[1], c[2]));
  }

}
