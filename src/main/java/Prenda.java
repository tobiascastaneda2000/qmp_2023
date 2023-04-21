import java.awt.*;

public class Prenda {

  TipoPrenda tipoPrenda;
   Color colorPrincipal;
   Material material;
   Color colorSecundario;

  Prenda(TipoPrenda tipoPrenda, Color colorPrincipal, Material material, Color colorSecundario){
    this.tipoPrenda = tipoPrenda;
    this.colorPrincipal = colorPrincipal;
    this.material = material;
    this.colorSecundario = colorSecundario;
  }

  Prenda(TipoPrenda tipoPrenda, Color colorPrincipal, Material material){
    this.tipoPrenda = tipoPrenda;
    this.colorPrincipal = colorPrincipal;
    this.material = material;
    this.colorSecundario = null;
  }
  //Como usuarie de QuéMePongo, quiero especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).
  public void indicarTipo(TipoPrenda tipoPrenda){
    this.tipoPrenda = tipoPrenda;
  }

  //Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

  /*Habla de que se debe poder identificar, pero no hablanecesariamente de deber ingresarla
   Pensamos Categoria como un atributo que calcula tipo Prenda
   */

  public Categoria identificarCategoria(){
    return this.tipoPrenda.devolverCategoria();
  }

 // Como usuarie de QuéMePongo, quiero poder indicar de qué tela o material está hecha una prenda
  public void indicarMaterial(Material material){
    this.material = material;
  }


  //Como usuarie de QuéMePongo, quiero poder indicar un color principal para mis prendas
  public void indicarColorPrimario(Color colorPrincipal){
    this.colorPrincipal = colorPrincipal;
  }


  //Como usuarie de QuéMePongo, quiero poder indicar, si existe, un color secundario para mis prendas.
  public void indicarColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
  }

  public boolean esValida() {
    return tieneTodosTipos() ;
  }

  private boolean tieneTodosTipos() {
    return tipoPrenda!= null && colorPrincipal!= null && material!= null;
    /*Si la prenda se instancia con el constrctor¿Los valores ya cumplen este requisito por defecto?
    * */
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
