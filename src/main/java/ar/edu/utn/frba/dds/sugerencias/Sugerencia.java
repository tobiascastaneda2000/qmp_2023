package ar.edu.utn.frba.dds.sugerencias;

import ar.edu.utn.frba.dds.prenda.Prenda;

public final class Sugerencia {
  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda prendaCalzado;

  Sugerencia(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.prendaCalzado = prendaCalzado;
  }

/*1)  Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires
en un momento dado para obtener sugerencias acordes.

  Rta:
  1- Prenda realiza metodo que devuelve un objeto con las condiciones metereologicas y
  la manda como parametro en generarSugerencias()

  2) Como usuarie de QuéMePongo, quiero que al generar una sugerencia las prendas sean
  acordes a la temperatura actual sabiendo que para cada tipo de prenda habrá una temperatura
  hasta la cual es adecuada.
  (Ej.: “Remera de mangas largas” no es apta a más de 20°C)

  Rta: Agrego en clase TipoPrenda
  un atributo temperaturaMax tipo double que conoce y
  un getter que lo devuelva

  Como administradore de QuéMePongo, quiero poder configurar fácilmente diferentes
  servicios de obtención del climapara
  ajustarme a las cambiantes condiciones económicas.

  Como stakeholder de QuéMePongo, quiero poder asegurar la calidad de mi aplicación sin
  incurrir en costos innecesarios.*/

}
