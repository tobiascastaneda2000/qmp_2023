package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import ar.edu.utn.frba.dds.propuestas.PropuestaAgregar;
import ar.edu.utn.frba.dds.propuestas.PropuestaQuitar;
import ar.edu.utn.frba.dds.sugerencias.ProveedorDeMotor;
import ar.edu.utn.frba.dds.sugerencias.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PropuestasTest {

  Usuario unUsuario;
  Guardarropas guardarropas;
  Prenda prendaOriginalMock;
  Prenda prendaNuevaMock;
  PropuestaAgregar propuestaAgregar;
  PropuestaQuitar propuestaQuitar;
  ProveedorDeMotor proveedorDeMotorMock;


  @BeforeEach
  void setUp() {
    proveedorDeMotorMock = Mockito.mock(ProveedorDeMotor.class);
    unUsuario = new Usuario(12, proveedorDeMotorMock);
    guardarropas = new Guardarropas();
    prendaOriginalMock = Mockito.mock(Prenda.class);
    prendaNuevaMock = Mockito.mock(Prenda.class);
    guardarropas.agregarPrenda(prendaOriginalMock);
    propuestaAgregar = new PropuestaAgregar(guardarropas, prendaNuevaMock);
    propuestaQuitar = new PropuestaQuitar(guardarropas, prendaOriginalMock);
    unUsuario.agregarGuardarropa(guardarropas);

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
    Assertions.assertEquals(unUsuario.getPropuestas().size(), 0);
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
    Assertions.assertEquals(unUsuario.getPropuestas().size(), 0);
  }

  @Test
  @DisplayName("Se deshace cambio de propuesta de agregado, quita la prenda ingresada")
  void deshacerCambiosDePropuestaDeAgregado() {
    guardarropas.recibirPropuestaAgregar(prendaNuevaMock);
    guardarropas.getPropuestas().get(0).aceptar();
    guardarropas.getPropuestas().get(0).deshacerEn(guardarropas);
    Assertions.assertFalse(unUsuario.getPrendas().contains(prendaNuevaMock));
  }


  @Test
  @DisplayName("Se deshace cambio de propuesta de quitar, devuelve la prenda eliminada")
  void deshacerCambiosDePropuestaDeQuitar() {
    guardarropas.recibirPropuestaQuitar(prendaOriginalMock);
    guardarropas.getPropuestas().get(0).aceptar();
    guardarropas.getPropuestas().get(0).deshacerEn(guardarropas);
    Assertions.assertTrue(unUsuario.getPrendas().contains(prendaOriginalMock));
  }

}
