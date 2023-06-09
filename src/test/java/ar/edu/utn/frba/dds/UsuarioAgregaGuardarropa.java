package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsuarioAgregaGuardarropa {
  UsuarioGuardarropas usuarioCreador;
  Guardarropas guardarropas;

  @BeforeEach
  void setUp() {
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
}