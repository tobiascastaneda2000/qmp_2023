package ar.edu.utn.frba.dds.sugerencias;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologico {
  Map<String, RespuestaAccuWeather> ultimasRespuestas;
  AccuWeatherAPI api;
  Duration periodoDeValidez;

  // ¿es el API un componente pesado? ¿es un componente que podemos compartir?
  // si instanciamos el objeto acá mismo, estamos asumiendo un montón de cosas
  // (que es liviano, que no parece ser compartible),
  // pero al usar inyección de dependencias evitamos
  // hacer esas suposiciones: "pateamos el problema para adelante"
  public ServicioMeteorologico(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<String, RespuestaAccuWeather>();
  }

  // esto es un algoritmo clásico de caché:
  //     * si no está en caché o está expirada, recalcular y guardar.
  //     * en cualquier caso: devolver el resultado de la caché
  public Map<String, Object> obtenerCondicionesClimaticas(String direccion) {
    if (
        !this.ultimasRespuestas.containsValue(direccion)
            || this.ultimasRespuestas.get(direccion).expiro()) {
      ultimasRespuestas.put(direccion,new RespuestaAccuWeather(this.consultarApi(direccion), proximaExpiracion()));
    }
    return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  // optimización: acá podríamos guardar directamente las próxima predicciones y
  // actualizar las cacheadas si las nuevas son diferentes
  private Map<String, Object> consultarApi(String direccion) {
    return this.api.getWeather(direccion).get(0);
  }





  // getters

  // si no fuera por este método en algunos lenguajes
  // bien podría haber sido una tupla
  public
  boolean expiro() {
    return this.expiracion.isAfter(DateTime.now);
  }
}
