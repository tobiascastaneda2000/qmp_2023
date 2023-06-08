package ar.edu.utn.frba.dds.sugerencias;

import java.util.List;

public class AsesorDeImagen {
  private final ServicioMeteorologico servicioMeteorologico;

  public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  // .... constructor que inyecta al servicio meteorologico....

  public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarropas) {

        EstadoDelTiempo estadoDelTiempo = this.servicioMeteorologico.obtenerCondicionesClimaticas(direccion);
        List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones();
        return combinaciones
            .stream()
            .filter(combinacion -> combinacion.aptaParaTemperatura(estadoDelTiempo.getTemperatura()))

            .findFirst()
            .get();

        //.filter(combinacion -> combinacion.aptaParaHumedad(estadoDelTiempo.getHumedad()))


    }
  }



