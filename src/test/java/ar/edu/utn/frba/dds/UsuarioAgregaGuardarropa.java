package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.propuestas.YaTieneGuardarropasException;
import ar.edu.utn.frba.dds.servicio_meteorologico.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UsuarioAgregaGuardarropa {
  UsuarioGuardarropas unUsuario;
  UsuarioGuardarropas otroUsuario;
  UsuarioGuardarropas usuarioCreador;
  Guardarropas guardarropas;

  @BeforeEach
  void setUp() {
    unUsuario = new UsuarioGuardarropas();
    otroUsuario = new UsuarioGuardarropas();
    usuarioCreador = new UsuarioGuardarropas();
    guardarropas = new Guardarropas();
  }

  @Test
  @DisplayName("usuario puede agregar guardarropas")
  void usuarioAgregaGuardarropas() {
    usuarioCreador.agregarGuardarropa(guardarropas);
    Assertions.assertTrue(usuarioCreador.getGuardarropas().contains(guardarropas));
    Assertions.assertEquals(usuarioCreador.getGuardarropas().size(), 1);
  }

  @Test
  @DisplayName("usuario no puede agregar guardarropa que ya tiene")
  void usuarioNoPuedeAgregarGuardarropas() {
    usuarioCreador.agregarGuardarropa(guardarropas);
    Assertions.assertThrows(YaTieneGuardarropasException.class, () -> {
      usuarioCreador.agregarGuardarropa(guardarropas);
    });
  }

  @Test
  @Disabled
  @DisplayName("usuario no puede agregar guardarropas compartido que uno sesus usuarios ya tiene")
  void usuarioNoPuedeAgregarGuardarropasCompartido() {

  }

  @Test
  @DisplayName("usuario agrega guardarropas compartido")
  void usuarioAgregaGuardarropasCompartido() {
    Set<UsuarioGuardarropas> listaUsuario = new HashSet<>();
    listaUsuario.add(unUsuario);
    listaUsuario.add(otroUsuario);
    usuarioCreador.agregarGuardarropaCompartido(guardarropas, listaUsuario);
    Assertions.assertTrue(usuarioCreador.getGuardarropas().contains(guardarropas));
    Assertions.assertTrue(unUsuario.getGuardarropas().contains(guardarropas));
    Assertions.assertTrue(otroUsuario.getGuardarropas().contains(guardarropas));


  }

  /*Casos de prueba:
  -Cuando se agrega guardarropas compartido y  usuario ya tiene guardarropas
  */
}