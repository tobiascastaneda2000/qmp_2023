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
/*
public class ar.edu.utn.frba.dds.Usuario {
  List<ar.edu.utn.frba.dds.prenda.Prenda> prendas;

  List<ar.edu.utn.frba.dds.Sugerencias> crearSugerencias() {
    List<ar.edu.utn.frba.dds.prenda.Prenda> prendasSuperiores = prendas.stream().filter(prenda -> prenda.identificarCategoria() == ar.edu.utn.frba.dds.prenda.Categoria.PARTE_SUPERIOR).toList();
    List<ar.edu.utn.frba.dds.prenda.Prenda> prendasInferiores = prendas.stream().filter(prenda -> prenda.identificarCategoria() == ar.edu.utn.frba.dds.prenda.Categoria.PARTE_INFERIOR).toList();
    List<ar.edu.utn.frba.dds.prenda.Prenda> prendasCalzado = prendas.stream().filter(prenda -> prenda.identificarCategoria() == ar.edu.utn.frba.dds.prenda.Categoria.CALZADO).toList();

    List<List<ar.edu.utn.frba.dds.prenda.Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores,prendasInferiores , prendasCalzado);
    return null;
  }
}
*/

class MotorSugerenciasBasico implements MotorSugerencias {

  //TODO no repetir esta logica
  public List<Sugerencia> generarSugerencias(Usuario usuario){
    List<Prenda> prendasSuperiores = usuario.getPrendas().stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = usuario.getPrendas().stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = usuario.getPrendas().stream().filter(Prenda::esCalzado).toList();

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Sugerencia(c[0], c[1], c[2]));
  }

}
