package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.Propuesta;
import ar.edu.utn.frba.dds.propuestas.PropuestaAgregar;
import ar.edu.utn.frba.dds.propuestas.PropuestaQuitar;
import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.servicio_meteorologico.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioAceptaPropuesta {

  UsuarioGuardarropas unUsuario;
  Guardarropas guardarropas;
  Prenda prendaMock;
  PropuestaAgregar propuestaAgregar;
  PropuestaQuitar propuestaQuitar;

  Guardarropas guardarropasMock;

  @BeforeEach
  void setUp() {
    unUsuario = new UsuarioGuardarropas();
    guardarropas = new Guardarropas();
    prendaMock = Mockito.mock(Prenda.class);
    propuestaAgregar = new PropuestaAgregar(guardarropas, prendaMock);
    propuestaQuitar = new PropuestaQuitar(guardarropas, prendaMock);
    List<Propuesta> propuestas = new ArrayList<>();
    propuestas.add(propuestaAgregar);
    propuestas.add(propuestaQuitar);
    unUsuario.setPropuestas(propuestas);
    unUsuario.agregarGuardarropa(guardarropas);
    //guardarropasMock = mock(Guardarropas.class);

  }

  @Test
  @DisplayName("usuario que acepta porpuesta agregado se le suma una prenda al guardarropas y elimina la propuesta")
  void usuarioAceptaPropuestaDeAgregado() {
    Assertions.assertTrue(unUsuario.getPropuestas().contains(propuestaAgregar));
    unUsuario.aceptarPropuesta(propuestaAgregar);
    Assertions.assertTrue(guardarropas.getPrendas().contains(prendaMock));
    Assertions.assertFalse(unUsuario.getPropuestas().contains(propuestaAgregar));
    //Mockito.verify(guardarropas, Mockito.times(1)).agregarPrenda(prendaMock);
    //metodo para verificar que guardarPrenda(prendaMock ) se llama una vez

  }

  @Test
  @DisplayName("usuario que acepta porpuesta de quitado se elimina la prenda del guardarropas y elimina la propuesta")
  void usuarioAceptaPropuestaDeQuitado() {
    Assertions.assertTrue(unUsuario.getPropuestas().contains(propuestaQuitar));
    guardarropas.agregarPrenda(prendaMock);
    unUsuario.aceptarPropuesta(propuestaQuitar);
    Assertions.assertFalse(guardarropas.getPrendas().contains(prendaMock));
    Assertions.assertFalse(unUsuario.getPropuestas().contains(propuestaQuitar));
    //Mockito.verify(guardarropas, Mockito.times(1)).agregarPrenda(prendaMock);
    //metodo para verificar que guardarPrenda(prendaMock ) se llama una vez

  }

  @Test
  @DisplayName("usuario que rechaza propuesta agregado elimina la propuesta sin mas")
  void usuarioRechazaPropuestaDeAgregado() {
    unUsuario.rechazarPropuesta(propuestaAgregar);
    Assertions.assertFalse(unUsuario.getPropuestas().contains(propuestaAgregar));
  }

  @Test
  @DisplayName("usuario que rechaza propuesta de quitar elimina la propuesta sin mas")
  void usuarioRechazaPropuestaDeQuitado() {
    unUsuario.rechazarPropuesta(propuestaQuitar);
    Assertions.assertFalse(unUsuario.getPropuestas().contains(propuestaQuitar));
  }

}
