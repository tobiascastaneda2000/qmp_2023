package ar.edu.utn.frba.dds.sugerencias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

// Esto es necesario solamente para "agregarle" a las condiciones
// climáticas una expiración
public class RespuestaAccuWeather {

  Map<String, Object> estadoDelTiempo;
  LocalDateTime expiracion;
  public RespuestaAccuWeather(Map<String, Object> estadoDelTiempo, LocalDateTime expiracion) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.expiracion = expiracion;
  }

  public boolean expiro() {
    return this.expiracion.isAfter(LocalDateTime.now());
  }

  public Map<String, Object> getEstadoDelTiempo() {
    /*??*/
  }
}