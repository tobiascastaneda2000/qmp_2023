package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import ar.edu.utn.frba.dds.sugerencias.ProveedorDeMotor;
import ar.edu.utn.frba.dds.sugerencias.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UsuarioTieneGuardarropasTest {
  Usuario usuarioCreador;
  Guardarropas guardarropas;
  ProveedorDeMotor proveedorDeMotorMock;


  @BeforeEach
  void setUp() {
    usuarioCreador = new Usuario(12,proveedorDeMotorMock);
    guardarropas = Mockito.mock(Guardarropas.class);
    proveedorDeMotorMock = Mockito.mock(ProveedorDeMotor .class);
  }

  @Test
  @DisplayName("usuario puede agregar guardarropas")
  void usuarioAgregaGuardarropas() {
    usuarioCreador.agregarGuardarropa(guardarropas);
    Assertions.assertTrue(usuarioCreador.getGuardarropas().contains(guardarropas));
  }

  @Test
  @DisplayName("usuario puede quitar guardarropas")
  void usuarioQuitaGuardarropas() {
    usuarioCreador.agregarGuardarropa(guardarropas);
    usuarioCreador.quitarGuadarropas(guardarropas);
    Assertions.assertFalse(usuarioCreador.getGuardarropas().contains(guardarropas));
  }
}