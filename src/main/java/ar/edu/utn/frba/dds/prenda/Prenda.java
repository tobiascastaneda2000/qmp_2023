package ar.edu.utn.frba.dds.prenda;

import java.awt.*;

public class Prenda {

  Trama trama;
  TipoPrenda tipoPrenda;
  Color colorPrimario;
  String material;
  Color colorSecundario;
  Formalidad formalidad;

  Prenda(TipoPrenda tipoPrenda, Color colorPrincipal, String material, Color colorSecundario, Trama trama, Formalidad formalidad) {
    this.tipoPrenda = tipoPrenda;
    this.colorPrimario = colorPrincipal;
    this.material = material;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.formalidad = formalidad;
  }


  /*Si los objetos son globales, es mejor evitar los setters*/

  //Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

  /*Al ser categoria un atributo de tipo, es naturalmente consistente*/
  public Categoria categoria() {
    return this.tipoPrenda.getCategoria();
  }

  public Color getColorPrimario() {
    return this.colorPrimario;
  }

  public Color getColorSecundario() {
    return this.colorSecundario;
  }

  public Trama getTrama() {
    return this.trama;
  }

  public String getMaterial() {
    return this.material;
  }

  public boolean isInformal() {
    return this.formalidad == Formalidad.INFORMAL;
  }

  public boolean esSuperior() {
    return this.categoria() == Categoria.PARTE_SUPERIOR;
  }

  public boolean esInferior() {
    return this.categoria() == Categoria.PARTE_INFERIOR;
  }

  public boolean esCalzado() {
    return this.categoria() == Categoria.CALZADO;
  }

  public boolean esAptaParaTemperatura(Integer temperaturaActual) {
    return this.tipoPrenda.getTemperaturaMax() <= temperaturaActual;
  }

  /*COMENTARIOS

  -El usuario instancia una prenda pasando por parametro tipo, material, color primario y opccionalmente color secundario
  Hay un solo constructor que ya realiza validacion de tipo, material y color  primario con un requireNonNull

  No damos libertad a usuario de settear prenda, ya que son objetos globales

   La clase color ya viene importada desde java en import java.awt.*;

  Decidimos que ar.edu.utn.frba.dds.prenda.Categoria fuera un atributo que guarda tipoPreda, ya que ambos parametros estan realcionados por un requerimiento,
  por lo que garantiza la consistencia de con tipoPrenda, por lo que una validacion seria innecesaria

  ar.edu.utn.frba.dds.prenda.Prenda dificil de validar -> Muchos atributos -> Representacion interna compleja



   */
}
