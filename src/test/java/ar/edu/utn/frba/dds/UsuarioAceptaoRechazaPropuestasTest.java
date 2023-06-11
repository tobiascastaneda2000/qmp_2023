package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.Propuesta;
import ar.edu.utn.frba.dds.propuestas.PropuestaAgregar;
import ar.edu.utn.frba.dds.propuestas.PropuestaQuitar;
import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAceptaoRechazaPropuestasTest {

  UsuarioGuardarropas unUsuario;
  Guardarropas guardarropas;
  Prenda prendaOriginalMock;
  Prenda prendaNuevaMock;
  PropuestaAgregar propuestaAgregar;
  PropuestaQuitar propuestaQuitar;

  Guardarropas guardarropasMock;

  @BeforeEach
  void setUp() {
    unUsuario = new UsuarioGuardarropas();
    guardarropas = new Guardarropas();
    prendaOriginalMock = Mockito.mock(Prenda.class);
    prendaNuevaMock = Mockito.mock(Prenda.class);
    guardarropas.agregarPrenda(prendaOriginalMock);
    propuestaAgregar = new PropuestaAgregar(guardarropas, prendaNuevaMock);
    propuestaQuitar = new PropuestaQuitar(guardarropas, prendaOriginalMock);
    unUsuario.agregarGuardarropa(guardarropas);
    //guardarropasMock = mock(Guardarropas.class);

  }

  @Test
  @DisplayName("guardarropas recibe propuesta agregado crea propuesta pero aun no suma a la preda")
  void usuarioRecibePropuestaDeAgregado() {
    guardarropas.recibirPropuestaAgregar(prendaNuevaMock);
    Assertions.assertFalse(unUsuario.getPrendas().contains(prendaNuevaMock));
    Assertions.assertEquals(unUsuario.getPropuestas().size(), 1);

  }

  @Test
  @DisplayName("guardarropas recibe propuesta quitado crea propuesta pero aun no lo quita")
  void usuarioRecibePropuestaDeQuitado() {
    guardarropas.recibirPropuestaQuitar(prendaOriginalMock);
    Assertions.assertTrue(unUsuario.getPrendas().contains(prendaOriginalMock));
    Assertions.assertEquals(unUsuario.getPropuestas().size(), 1);

  }

  @Test
  @DisplayName("usuario que acepta propuesta agregado, suma la prenda")
  void aceptaPropuestaDeAgregado() {
    guardarropas.recibirPropuestaAgregar(prendaNuevaMock);
    guardarropas.getPropuestas().get(0).aceptar();
    Assertions.assertTrue(unUsuario.getPrendas().contains(prendaNuevaMock));
  }

  @Test
  @DisplayName("usuario que rechaza propuesta de agregado, elimina la propuesta sin mas")
  void rechazaPropuestaDeAgregado() {
    guardarropas.recibirPropuestaAgregar(prendaNuevaMock);
    guardarropas.getPropuestas().get(0).rechazar();
    Assertions.assertFalse(unUsuario.getPrendas().contains(prendaNuevaMock));
    Assertions.assertEquals(unUsuario.getPropuestas().size(),0);
  }

  @Test
  @DisplayName("usuario que acepta propuesta de quitado, elimina la prenda")
  void aceptaPropuestaDeQuitado() {
    guardarropas.recibirPropuestaQuitar(prendaOriginalMock);
    guardarropas.getPropuestas().get(0).aceptar();
    Assertions.assertFalse(unUsuario.getPrendas().contains(prendaOriginalMock));
  }


  @Test
  @DisplayName("usuario que rechaza propuesta de quitado, elimina la propuesta sin mas")
  void rechazaPropuestaDeQuitado() {
    guardarropas.recibirPropuestaQuitar(prendaOriginalMock);
    guardarropas.getPropuestas().get(0).rechazar();
    Assertions.assertTrue(unUsuario.getPrendas().contains(prendaOriginalMock));
    Assertions.assertEquals(unUsuario.getPropuestas().size(),0);
  }

  //Faltan test de deshacer

}
