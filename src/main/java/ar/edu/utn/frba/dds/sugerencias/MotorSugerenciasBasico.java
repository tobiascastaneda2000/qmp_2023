package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.*;

import java.util.List;

/*
Dependencias: Alguas mas faciles (prenda) y otras mas dificiles (motorSugerencia)
-Antes de crear mi clase, esa dependencia ya existia?
-Clase usuario va a depender de motor
Entonces va a requerir una inyecccion de dependencias, por el constructor
ar.edu.utn.frba.dds.sugerencias.AccuWeatherAPI.Usuario va a depender de lo que venga de afuera
dependencia no significa necesariamente que la tengamos que instanciar
Service Locator -> SIngleton mas grande y configurable (mejor)
Desacoplar la logica de como adopto esa dependencia
CUando tengo que onbtener dependencias, las inyecots, y despues me voy apreocupar de como las voy a proveer
 */


class MotorSugerenciasBasico implements MotorSugerencias {

  public List<Prenda> getPrendasValidas(Usuario usuario){
    return usuario.getPrendas();

  }

}
