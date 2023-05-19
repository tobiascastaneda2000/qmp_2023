package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;
import com.google.common.collect.Lists;

import java.util.List;

public interface MotorSugerencias {
  default List<Sugerencia> devolverSugerencias(Usuario usuario, ProveedorClima proveedorClima){

    List<Prenda> prendas = getPrendasValidas(usuario);

    List<Prenda> prendasFiltradas = proveedorClima.filtrarPorClima(prendas);

    List<Prenda> prendasSuperiores = prendasFiltradas.stream().filter(Prenda::esSuperior).toList();
    List<Prenda> prendasInferiores = prendasFiltradas.stream().filter(Prenda::esInferior).toList();
    List<Prenda> calzados = prendasFiltradas.stream().filter(Prenda::esCalzado).toList();

    //Uso una biblioteca como Guava para el producto cartesiano
    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados);

    return combinaciones.stream().map(c -> new Sugerencia(c.get(0), c.get(1), c.get(2))).toList();
  }

  List<Prenda> getPrendasValidas(Usuario usuario);

}

