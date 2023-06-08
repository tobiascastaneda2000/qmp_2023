package ar.edu.utn.frba.dds.servicio_meteorologico;

public class EstadoDelTiempo {

  int temperatura;


  double humedad;

  public EstadoDelTiempo(int temperatura
                         //, double humedad
  ) {
    this.temperatura = temperatura;
    //this.humedad = humedad;
  }

  public int getTemperatura() {
    return this.temperatura;
  }

}

  //public double getHumedad() {return humedad;}



