package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.List;
import java.util.Map;

public class ProveedorClima {
  private final ServicioMeteorologico servicioMeteorologico;

  public ProveedorClima(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  // .... constructor que inyecta al servicio meteorologico....

  public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarrpas) {
    Map<String, Object> estadoDelTiempo = this.servicioMeteorologico
        .obtenerCondicionesClimaticas(direccion);

    int temperatura = (int) estadoDelTiempo.get(¿¿??);
    /*
    Humedad humedad = (double) prediccion.get(¿¿???) > 0.8 ? LLUVIOSO : SECO;
    // El enunciado no lo pide, pero a modo de ejemplo
    // de cómo fácilmente se podría complicar más
*/
    List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones();

    return combinaciones
        .filter( combinacion -> combinacion.aptaParaTemperatura(temperatura) )
        .filter( combinacion -> combinacion.aptaParaHumedad(humedad) )
        .first();
  }


