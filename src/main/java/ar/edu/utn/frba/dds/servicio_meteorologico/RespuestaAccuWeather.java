package ar.edu.utn.frba.dds.servicio_meteorologico;

import ar.edu.utn.frba.dds.servicio_meteorologico.EstadoDelTiempo;

import java.time.LocalDateTime;

// Esto es necesario solamente para "agregarle" a las condiciones
// climáticas una expiración
public class RespuestaAccuWeather {

  EstadoDelTiempo estadoDelTiempo;
  LocalDateTime expiracion;
  public RespuestaAccuWeather(EstadoDelTiempo estadoDelTiempo, LocalDateTime expiracion) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.expiracion = expiracion;
  }

  // getters

  // si no fuera por este método en algunos lenguajes
  // bien podría haber sido una tupla
  public EstadoDelTiempo getEstadoDelTiempo() {
    return this.estadoDelTiempo;
  }

  public boolean expiro() {
    return this.expiracion.isAfter(LocalDateTime.now());
  }
}