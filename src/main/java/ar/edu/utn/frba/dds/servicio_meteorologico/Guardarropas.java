package ar.edu.utn.frba.dds.servicio_meteorologico;

import ar.edu.utn.frba.dds.prenda.Prenda;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  List<Prenda> prendasSuperiores;
  List<Prenda> prendasInferiores;
  List<Prenda> calzados;

  public List<Atuendo> todasLasPosiblesCombinaciones() {

    List<Atuendo> combinaciones = new ArrayList<>();

    List<List<Prenda>> todasLasCombinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);
    for (List<Prenda> combinacion : todasLasCombinaciones) {
      Atuendo atuendo = new Atuendo(combinacion.get(0), combinacion.get(1), combinacion.get(2));
      combinaciones.add(atuendo);
    }

    return combinaciones;
  }

  public void agregarPrenda(Prenda prenda) {
    switch (prenda.categoria()) {
      case PARTE_SUPERIOR -> {
        prendasSuperiores.add(prenda);
      }
      case PARTE_INFERIOR -> prendasInferiores.add(prenda);
      case CALZADO -> calzados.add(prenda);
      default -> throw new RuntimeException("Categoria no pertenece a los campos del guardarropas");

    }
  }

  public void quitarPrenda(Prenda prenda) {
    switch (prenda.categoria()) {
      case PARTE_SUPERIOR -> {
        prendasSuperiores.remove(prenda);
      }
      case PARTE_INFERIOR -> prendasInferiores.remove(prenda);
      case CALZADO -> calzados.remove(prenda);
      default -> throw new RuntimeException("Categoria no pertenece a los campos del guardarropas");

    }
  }
}



