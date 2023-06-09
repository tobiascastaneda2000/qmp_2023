package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.servicio_meteorologico.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class UsuarioGeneraPropuesta {

  UsuarioGuardarropas unUsuario;
  Guardarropas guardarropas;

  Prenda prenda;

  @BeforeEach
  void setUp() {
    unUsuario = new UsuarioGuardarropas();
    guardarropas = new Guardarropas();
    prenda = mock(Prenda.class);
  }

  @Test
  @DisplayName("usuario recibe propuesta de agregado")
  void usuarioAgregaPropuesta(){
    unUsuario.recibirPropuestaAgregar(guardarropas, prenda);
    Assertions.assertTrue(unUsuario.getPropuestas().contains(prenda));

  }

  @Test
  @DisplayName("usuario recibe propuesta de agregado")
  void usuarioQuitaPropuesta(){
    unUsuario.recibirPropuestaQuitar(guardarropas, prenda);
    Assertions.assertTrue(unUsuario.getPropuestas().contains(prenda));
  }
}
