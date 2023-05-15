import ar.edu.utn.frba.dds.prenda.BorradorPrenda;
import ar.edu.utn.frba.dds.prenda.Categoria;
import ar.edu.utn.frba.dds.prenda.Prenda;
import ar.edu.utn.frba.dds.prenda.TipoPrenda;
import ar.edu.utn.frba.dds.prenda.Trama;

import java.awt.*;

public class Demo {
  public static void main(String[] args) {

    TipoPrenda ZapatosCuero = new TipoPrenda(Categoria.CALZADO);
    BorradorPrenda borrador = new BorradorPrenda(ZapatosCuero);
    borrador.especificarColorPrimario(Color.BLACK);
    borrador.especificarMaterial("CUERO");
    Prenda prendaCalzado = borrador.construir();

    TipoPrenda RemeraRayas = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    BorradorPrenda borrador2 = new BorradorPrenda(RemeraRayas);
    borrador2.especificarColorPrimario(Color.BLACK);
    borrador2.especificarMaterial("POLLIESTER");
    borrador2.especificarTrama(Trama.A_CUADROS);
    Prenda prendaSuperior = borrador2.construir();

    TipoPrenda patalon = new TipoPrenda(Categoria.PARTE_INFERIOR);
    BorradorPrenda borrador3 = new BorradorPrenda(patalon);

    borrador3.especificarColorPrimario(Color.BLACK);
    borrador3.especificarMaterial("POLLIESTER");
    borrador3.especificarTrama(Trama.A_CUADROS);
    Prenda prendaInferior = borrador3.construir();

    /*
    ok, puedo hacer esto..

    New prenda(...)

    PEro para ello tendria que hacer dos validaciones
    POr lo que los desarrolladores como equipo, podemos acordar no usar  new prenda.
    El usuario seguramente va a intentar romper la app
    * */
    //ar.edu.utn.frba.dds.Sugerencias.getInstance().guardar(new Uniforme(prendaSuperior, prendaInferior, prendaCalzado, null));


    //List<Uniforme> uniformes = ar.edu.utn.frba.dds.Sugerencias.getInstance().recibirSugerencia();
/*
    System.out.println("\nUna prenda 1 es de categoria:\n" + prendaCalzado.identificarCategoria() +
            "\ncolor primario:\n" + prendaCalzado.getColorPrimario() +
            "\ncolor secundario:\n" + prendaCalzado.getColorSecundario());

    System.out.println("\nUna prenda 2 es de categoria:\n" + prendaSuperior.identificarCategoria() +
            "\ncolor primarioa:\n" + prendaSuperior.getColorPrimario() +
            "\nLa trama es:\n" +  prendaSuperior.getTrama());

    System.out.println("\nSugerencia:\n" + uniformes);

*/
  }

}

