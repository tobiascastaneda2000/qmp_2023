package ar.edu.utn.frba.dds.servicio_meteorologico;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioAccuWeather implements ServicioMeteorologico {

  private final AccuWeatherAPI api;
  private final Duration periodoDeValidez;
  private Map<String, RespuestaAccuWeather> ultimasRespuestas;

  public ServicioAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<>();
  }

  public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
      /*
      if (!this.ultimasRespuestas.containsKey(direccion) || this.ultimasRespuestas.get(direccion).expiro()) {
        ultimasRespuestas.put(direccion, this.consultarApi(direccion));
      }
      return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();*/
    if (!this.ultimasRespuestas.containsKey(direccion) || this.ultimasRespuestas.get(direccion).expiro()) {
      ultimasRespuestas.put(direccion, new RespuestaAccuWeather(consultarApi(direccion), proximaExpiracion()));
    }
    return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  private EstadoDelTiempo consultarApi(String direccion) {

    // Encapsulamos el problema
    // ¿Podríamos haber usado algún patron creacional?
    // Quizás, pero no sentí que aportara nada acá.
    Map<String, Object> respuesta = this.api.getWeather(direccion).get(0);
    int temperatura = (int) respuesta.get("Temperature");
    //Humedad humedad = (double) respuesta.get(...) > 0.8 ? LLUVIOSO : SECO;
    return new EstadoDelTiempo(temperatura);
  }
}

