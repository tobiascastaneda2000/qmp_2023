package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.servicio_meteorologico.AsesorDeImagen;
import com.google.common.collect.Lists;

import java.util.List;

public interface MotorSugerencias {
  default List<Sugerencia> devolverSugerencias(Usuario usuario, AsesorDeImagen asesorDeImagen){

    List<Prenda> prendas = getPrendasValidas(usuario);

    //List<Prenda> prendasFiltradas = asesorDeImagen.filtrarPorClima(prendas);

    List<Prenda> prendasSuperiores = prendas.stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = prendas.stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = prendas.stream().filter(Prenda::esCalzado).toList();

    //Uso una biblioteca como Guava para el producto cartesiano
    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).toList();
  }

  List<Prenda> getPrendasValidas(Usuario usuario);

}

