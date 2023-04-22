import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class Prenda {

  TipoPrenda tipoPrenda;
   Color colorPrincipal;
   Material material;
   Optional<Color> colorSecundario;

  Prenda(TipoPrenda tipoPrenda, Color colorPrincipal, Material material, Optional<Color> colorSecundario){
    Objects.requireNonNull(tipoPrenda, "Falta tipo");
    Objects.requireNonNull(colorPrincipal, "Falta colorPrimario");
    Objects.requireNonNull(material, "Falta Material");
    this.tipoPrenda = tipoPrenda;
    this.colorPrincipal = colorPrincipal;
    this.material = material;
    this.colorSecundario = colorSecundario;
  }


  /*Si los objetos son globales, es mejor evitar los setters*/

  //Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

  /*Al ser categoria un atributo de tipo, es naturalmente consistente*/

  public Categoria identificarCategoria(){
    return this.tipoPrenda.devolverCategoria();
  }



  /*COMENTARIOS

  -El usuario instancia una prenda pasando por parametro tipo, material, color primario y opccionalmente color secundario
  Hay dos constructores, uno con tipo ,material y color Primario, y otro que ademas tiene color secundario

  -Damos libertad al usuario para cambiar tipo, material y colores de la prenda despues de su creacion, aun que en el
   mundo real una prenda no puede cambiar de composicion una vez fabricada, en un modelado de objetos cabria esa posibilidad
   DUDA

   -LA clase color ya viene importada desde java en import java.awt.*; es necesario referenciarla en l diagrama?

  -Decidimos que Categoria fuera un atributo que guarda tipoPreda, ya que ambos parametros estan realcionados por un requerimiento,
  por lo que garantiza la consistencia de con tipoPrenda, por lo que auna validacion seria innecesaria



   */
}
