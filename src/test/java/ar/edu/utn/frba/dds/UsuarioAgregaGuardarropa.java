package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.propuestas.UsuarioGuardarropas;
import ar.edu.utn.frba.dds.servicio_meteorologico.Guardarropas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
  void usuarioAgregaGuardarropas() {
    usuarioCreador.agregarGuardarropa(guardarropas);
    Assertions.assertTrue(usuarioCreador.getGuardarropas().contains(guardarropas));
    Assertions.assertEquals(usuarioCreador.getGuardarropas().size(),1);
  }

  @Test
  void usuarioAgregaGuardarropasCompartido(){
    Set<UsuarioGuardarropas> listaUsuario = new HashSet<>();
    listaUsuario.add(unUsuario);
    listaUsuario.add(otroUsuario);
    usuarioCreador.agregarGuardarropaCompartido(guardarropas, listaUsuario );
    Assertions.assertTrue(usuarioCreador.getGuardarropas().contains(guardarropas));
    Assertions.assertTrue(unUsuario.getGuardarropas().contains(guardarropas));
    Assertions.assertTrue(otroUsuario.getGuardarropas().contains(guardarropas));


  }

  /*Casos de prueba:
  * 1) usuario ya tiene guardarropas no debe agregarla
  * (o lanzar excepccion o simplemente no agregarla)*/
}