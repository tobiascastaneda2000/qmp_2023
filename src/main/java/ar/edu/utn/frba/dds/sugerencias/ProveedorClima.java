package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProveedorClima {
  String ciudad;

  public int temperaturaActual(String ciudad) {

    AccuWeatherAPI apiClima = new AccuWeatherAPI();
    List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(ciudad);
    Object temperature = condicionesClimaticas.get(0).get("Temperature");
    int valor = temperature.get(0).get("Value");
    return valor;
  }

  public List<Prenda> filtrarPorClima(List<Prenda> prendas) {
    int temperaturaActual = this.temperaturaActual("Buenos Aires");
    return prendas.stream().filter(prenda -> prenda.temperaturaCompatible(temperaturaActual)).toList();
  }
}
