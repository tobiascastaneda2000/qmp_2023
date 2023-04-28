import java.awt.*;

public class Demo {
  public static void main(String[] args) {

    TipoPrenda ZapatosCuero = new TipoPrenda(Categoria.CALZADO);
    BuilderPrenda borrador = new BuilderPrenda(ZapatosCuero);
    borrador.agregarColorPrimario(Color.BLACK);
    borrador.agregarMaterial(Material.CUERO);
    Prenda prenda = borrador.getResult();

    TipoPrenda RemeraRayas = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    BuilderPrenda borrador2 = new BuilderPrenda(RemeraRayas);
    borrador2.agregarColorPrimario(Color.BLACK);
    borrador2.agregarMaterial(Material.POLLIESTER);
    borrador2.especificarTrama(Trama.A_CUADROS);
    Prenda prenda2 = borrador2.getResult();

    System.out.println("\nUna prenda 1 es de categoria:\n" + prenda.identificarCategoria() +
            "\ncolor primario:\n" + prenda.getColorPrimario() +
            "\ncolor secundario:\n" + prenda.getColorSecundario());

    System.out.println("\nUna prenda 2 es de categoria:\n" + prenda2.identificarCategoria() +
            "\ncolor primarioa:\n" + prenda2.getColorPrimario() +
            "\nLa trama es:\n" +  prenda2.getTrama());

  }

}


//Director director = new Director();
/*
    // Director gets the concrete builder object from the client
    // (application code). That's because application knows better which
    // builder to use to get a specific product.
    CarBuilder builder = new CarBuilder();
    director.constructSportsCar(builder);

    // The final product is often retrieved from a builder object, since
    // Director is not aware and not dependent on concrete builders and
    // products.
    Car car = builder.getResult();
    System.out.println("Car built:\n" + car.getCarType());


    CarManualBuilder manualBuilder = new CarManualBuilder();

    // Director may know several building recipes.
    director.constructSportsCar(manualBuilder);
    Manual carManual = manualBuilder.getResult();


 */
