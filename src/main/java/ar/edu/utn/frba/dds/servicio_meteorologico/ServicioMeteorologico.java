package ar.edu.utn.frba.dds.servicio_meteorologico;

import ar.edu.utn.frba.dds.servicio_meteorologico.EstadoDelTiempo;

public interface ServicioMeteorologico {
  EstadoDelTiempo obtenerCondicionesClimaticas(String direccion);
}

