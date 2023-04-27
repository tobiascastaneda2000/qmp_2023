import java.awt.*;

public class BuilderPrenda {
  TipoPrenda tipoPrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;
  Trama trama;

  /*Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.*/
  BuilderPrenda(TipoPrenda tipoPrenda){
    this.tipoPrenda = tipoPrenda;
    this.trama = Trama.LISA;
  }

  void agregarMaterial(Material material){
    this.material = material;
  }

  void agregarColorPrimario(Color colorPrimario){
    this.colorPrimario = colorPrimario;
  }

  void agregarColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
  }

  void especificarTrama(Trama trama){
    this.trama = trama;
  }

  public Prenda getResult(){
    return new Prenda(tipoPrenda, colorPrimario, material, colorSecundario, trama);
  }




}
