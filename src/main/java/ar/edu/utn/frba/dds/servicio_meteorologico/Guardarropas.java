package ar.edu.utn.frba.dds.servicio_meteorologico;

import ar.edu.utn.frba.dds.prenda.Prenda;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Guardarropas {


  /*
    List<Prenda> prendasSuperiores;
    List<Prenda> prendasInferiores;
    List<Prenda> calzados;

     */
  List<Prenda> prendas;

  public Guardarropas() {
    this.prendas = new ArrayList<>();
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }
/*
  public List<Atuendo> todasLasPosiblesCombinaciones() {

    List<Atuendo> combinaciones = new ArrayList<>();

    List<List<Prenda>> todasLasCombinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);
    for (List<Prenda> combinacion : todasLasCombinaciones) {
      Atuendo atuendo = new Atuendo(combinacion.get(0), combinacion.get(1), combinacion.get(2));
      combinaciones.add(atuendo);
    }

    return combinaciones;
  }*/

  public List<Atuendo> todasLasPosiblesCombinaciones() {

    List<Prenda> prendasSuperiores = prendas.stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = prendas.stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = prendas.stream().filter(Prenda::esCalzado).toList();

    //Uso una biblioteca como Guava para el producto cartesiano
    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Atuendo(c.get(0), c.get(1), c.get(2))).toList();


  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda){
    prendas.remove(prenda);
  }

  public void validarPrendaParaAgregar(Prenda prenda) {
    if(getPrendas().contains(prenda)){
      throw new PrendaYaExisteEnGuardaropasException("Prenda ya existe dentro del guardarropas correspondiente");
    }
  }

  public void validarPrendaParaQuitar(Prenda prenda) {
    if(!getPrendas().contains(prenda)){
      throw new PrendaNoExisteEnGuardaropasException("Prenda NO existe dentro del guardarropas correspondiente");
    }
  }




/*
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
  }*/
}



