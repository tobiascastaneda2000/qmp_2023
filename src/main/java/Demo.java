import java.awt.*;
import java.util.List;
import java.util.Optional;

public class Demo {
  public static void main(String[] args) {

    TipoPrenda ZapatosCuero = new TipoPrenda(Categoria.CALZADO);
    BuilderPrenda borrador = new BuilderPrenda(ZapatosCuero);
    borrador.agregarColorPrimario(Color.BLACK);
    borrador.agregarMaterial(Material.CUERO);
    Prenda prendaCalzado = borrador.getResult();

    TipoPrenda RemeraRayas = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    BuilderPrenda borrador2 = new BuilderPrenda(RemeraRayas);
    borrador2.agregarColorPrimario(Color.BLACK);
    borrador2.agregarMaterial(Material.POLLIESTER);
    borrador2.especificarTrama(Trama.A_CUADROS);
    Prenda prendaSuperior = borrador2.getResult();

    TipoPrenda patalon = new TipoPrenda(Categoria.PARTE_INFERIOR);
    BuilderPrenda borrador3 = new BuilderPrenda(patalon);

    borrador3.agregarColorPrimario(Color.BLACK);
    borrador3.agregarMaterial(Material.POLLIESTER);
    borrador3.especificarTrama(Trama.A_CUADROS);
    Prenda prendaInferior = borrador3.getResult();

    /*
    *
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

