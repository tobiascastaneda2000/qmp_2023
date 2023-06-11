package ar.edu.utn.frba.dds.propuestas;

import ar.edu.utn.frba.dds.prenda.Prenda;

import java.util.Arrays;

public interface Propuesta {


   void aceptar();

   void rechazar();

   void deshacerEn(Guardarropas guardarropas);


}
