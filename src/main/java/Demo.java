import java.awt.*;
import java.util.List;

public class Demo {
  public static void main(String[] args) {

    TipoPrenda ZapatosCuero = new TipoPrenda(Categoria.CALZADO);
    BorradorPrenda borrador = new BorradorPrenda();
    borrador.especificarTipo(ZapatosCuero);
    borrador.especificarColorPrimario(Color.BLACK);
    borrador.especificarMaterial(Material.CUERO);
    Prenda prendaCalzado = borrador.construir();

    TipoPrenda RemeraRayas = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    BorradorPrenda borrador2 = new BorradorPrenda();
    borrador2.especificarTipo(RemeraRayas);
    borrador2.especificarColorPrimario(Color.BLACK);
    borrador2.especificarMaterial(Material.POLLIESTER);
    borrador2.especificarTrama(Trama.A_CUADROS);
    Prenda prendaSuperior = borrador2.construir();

    TipoPrenda patalon = new TipoPrenda(Categoria.PARTE_INFERIOR);
    BorradorPrenda borrador3 = new BorradorPrenda();
    borrador3.especificarTipo(patalon);

    borrador3.especificarColorPrimario(Color.BLACK);
    borrador3.especificarMaterial(Material.POLLIESTER);
    borrador3.especificarTrama(Trama.A_CUADROS);
    Prenda prendaInferior = borrador3.construir();

    /*
    ok, puedo hacer esto..

    New prenda(...)

    PEro para ello tendria que hacer dos validaciones
    POr lo que los desarrolladores como equipo, podemos acordar no usar  new prenda.
    El usuario seguramente va a intentar romper la app
    * */
    Sugerencias.getInstance().guardar(new Uniforme(prendaSuperior, prendaInferior, prendaCalzado, null));


    List<Uniforme> uniformes = Sugerencias.getInstance().recibirSugerencia();

    System.out.println("\nUna prenda 1 es de categoria:\n" + prendaCalzado.identificarCategoria() +
            "\ncolor primario:\n" + prendaCalzado.getColorPrimario() +
            "\ncolor secundario:\n" + prendaCalzado.getColorSecundario());

    System.out.println("\nUna prenda 2 es de categoria:\n" + prendaSuperior.identificarCategoria() +
            "\ncolor primarioa:\n" + prendaSuperior.getColorPrimario() +
            "\nLa trama es:\n" +  prendaSuperior.getTrama());

    System.out.println("\nSugerencia:\n" + uniformes);


  }

}

