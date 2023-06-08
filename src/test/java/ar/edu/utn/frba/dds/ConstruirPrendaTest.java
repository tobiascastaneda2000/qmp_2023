package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.prenda.BorradorPrenda;
import ar.edu.utn.frba.dds.prenda.Categoria;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.prenda.Trama;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConstruirPrendaTest {
  BorradorPrenda borradorPrenda;
  TipoPrenda tipoPrenda;

  @BeforeEach
  void init(){
    tipoPrenda = new TipoPrenda(Categoria.PARTE_SUPERIOR,20);
  }

  @Test
  void noSePuedeCrearPrendaSinTipo() {
    assertThrows(NullPointerException.class, ()->{
       borradorPrenda = crearBorrador(null);
    } );
  }

  @Test
  void noSePuedeCrearPrendaSinMaterial() {
    BorradorPrenda borradorPrenda = crearBorrador(tipoPrenda);
    borradorPrenda.especificarMaterial(null);
    borradorPrenda.especificarColorPrimario(Color.GREEN);
    assertThrows(NullPointerException.class, borradorPrenda::construir);
  }

  @Test
  void noSePuedeCrearPrendaSinColorPrimario() {
    BorradorPrenda borradorPrenda = crearBorrador(tipoPrenda);
    borradorPrenda.especificarMaterial("Madera");
    borradorPrenda.especificarColorPrimario(null);
    assertThrows(NullPointerException.class, borradorPrenda::construir);
  }

  @Test
  void sePuedeCrearPrendaSinColorSecundario() {
    BorradorPrenda borradorPrenda = crearBorrador(tipoPrenda);
    borradorPrenda.especificarMaterial("Madera");
    borradorPrenda.especificarColorPrimario(Color.GREEN);
    borradorPrenda.especificarColorSecundario(null);
    borradorPrenda.construir();
    assertDoesNotThrow(borradorPrenda::construir, String.valueOf(NullPointerException.class)); /*Preguntar*/
  }

  @Test
  void tramaSiNoSeEspecificaEsLisaPorDefecto() {
    BorradorPrenda borradorPrenda = crearBorrador(tipoPrenda);
    borradorPrenda.especificarMaterial("Madera");
    borradorPrenda.especificarColorPrimario(Color.GREEN);
    borradorPrenda.especificarColorSecundario(Color.BLACK);
    borradorPrenda.especificarTrama(null);
    Prenda prenda = borradorPrenda.construir();
    assertEquals(prenda.getTrama(), Trama.LISA);
  }

  @Test
  void prendaSeCOnstruyeConSusValores(){
    BorradorPrenda borradorPrenda = crearBorrador(tipoPrenda);
    borradorPrenda.especificarMaterial("Madera");
    borradorPrenda.especificarColorPrimario(Color.GREEN);
    borradorPrenda.especificarColorSecundario(Color.BLACK);
    borradorPrenda.especificarTrama(Trama.A_CUADROS);
    Prenda prenda = borradorPrenda.construir();
    assertEquals(prenda.getTrama(), Trama.A_CUADROS);
    assertEquals(prenda.getColorPrimario(), Color.GREEN);
    assertEquals(prenda.getColorSecundario(), Color.BLACK);
    assertEquals(prenda.getMaterial(), "Madera");
  }

  BorradorPrenda crearBorrador(TipoPrenda tipoPrenda){
    return new BorradorPrenda(tipoPrenda);
  }
}