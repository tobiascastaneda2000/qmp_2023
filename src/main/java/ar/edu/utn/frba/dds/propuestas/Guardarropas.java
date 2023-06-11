package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.servicio_meteorologico.Atuendo;
import ar.edu.utn.frba.dds.servicio_meteorologico.PrendaNoExisteEnGuardaropasException;
import ar.edu.utn.frba.dds.servicio_meteorologico.PrendaYaExisteEnGuardaropasException;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Guardarropas {

  List<Prenda> prendas;



  List<Propuesta> propuestas;


  public Guardarropas() {
    this.prendas = new ArrayList<>();
    this.propuestas = new ArrayList<>();;
  }

  public List<Prenda> getPrendas() {
    return this.prendas;
  }
  public List<Propuesta> getPropuestas() {
    return propuestas;
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
  public void recibirPropuestaAgregar( Prenda prenda) {
    propuestas.add(new PropuestaAgregar(this, prenda));
  }

  public void recibirPropuestaQuitar( Prenda prenda) {
    propuestas.add(new PropuestaQuitar(this, prenda));
  }

  public void removerPropuesta(Propuesta propuestaQuitar) {
    propuestas.remove(propuestaQuitar);
  }
/*
  public List<Prenda> prendasPropuestas(){
    this.propuestas.stream().flatMap(p->p.getPrenda().stream());
  }*/


}



