import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class Prenda {

   Trama trama = Trama.LISA;
   TipoPrenda tipoPrenda;
   Color colorPrimario;
   Material material;
   Color colorSecundario;

  Prenda(TipoPrenda tipoPrenda, Color colorPrincipal, Material material, Color colorSecundario, Trama trama){
    Objects.requireNonNull(tipoPrenda, "Falta tipo");
    Objects.requireNonNull(colorPrincipal, "Falta colorPrimario");
    Objects.requireNonNull(material, "Falta Material");
    this.tipoPrenda = tipoPrenda;
    this.colorPrimario = colorPrincipal;
    this.material = material;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
  } /*illegalArgumenException*/


  /*Si los objetos son globales, es mejor evitar los setters*/

  //Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

  /*Al ser categoria un atributo de tipo, es naturalmente consistente*/
  public Categoria identificarCategoria(){
    return this.tipoPrenda.devolverCategoria();
  }


  /*COMENTARIOS

  -El usuario instancia una prenda pasando por parametro tipo, material, color primario y opccionalmente color secundario
  Hay un solo constructor que ya realiza validacion de tipo, material y color  primario con un requireNonNull

  No damos libertad a usuario de settear prenda, ya que son objetos globales

   La clase color ya viene importada desde java en import java.awt.*;

  Decidimos que Categoria fuera un atributo que guarda tipoPreda, ya que ambos parametros estan realcionados por un requerimiento,
  por lo que garantiza la consistencia de con tipoPrenda, por lo que una validacion seria innecesaria



   */
}
