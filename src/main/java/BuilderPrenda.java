import java.awt.*;
import java.util.Optional;

public class BuilderPrenda {
  Trama trama = Trama.LISA;
  TipoPrenda tipoPrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;

  /*Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.*/
  BuilderPrenda(TipoPrenda tipoPrenda){
    this.tipoPrenda = tipoPrenda;
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

  public Prenda guardarPrenda(){
    return new Prenda(tipoPrenda, colorPrimario, material, colorSecundario, trama);
  }



}
