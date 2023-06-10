package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.propuestas.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class UsuarioGeneraPropuestaTest {

  UsuarioGuardarropas unUsuario;
  Guardarropas guardarropas;
  Prenda prendaMock;

  @BeforeEach
  void setUp() {
    unUsuario = new UsuarioGuardarropas();
    guardarropas = Mockito.mock(Guardarropas.class);
    prendaMock = Mockito.mock(Prenda.class);

  }

  @Test
  @DisplayName("usuario recibe propuesta de agregado")
  void usuarioAgregaPropuesta(){
    unUsuario.recibirPropuestaAgregar(guardarropas, prendaMock);
    Assertions.assertEquals(unUsuario.getPropuestas().size(), 1);
  }

  @Test
  @DisplayName("usuario recibe propuesta de agregado")
  void usuarioQuitaPropuesta(){
    unUsuario.recibirPropuestaQuitar(guardarropas, prendaMock);
    Assertions.assertEquals(unUsuario.getPropuestas().size(),1);
  }
}
