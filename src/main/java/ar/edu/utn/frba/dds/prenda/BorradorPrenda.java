package ar.edu.utn.frba.dds.prenda;

import java.awt.*;

import static java.util.Objects.requireNonNull;

public class BorradorPrenda {
  TipoPrenda tipoPrenda;
  String material;
  Color colorPrimario;
  Color colorSecundario;
  Trama trama;
  Formalidad formalidad;

  /*
  
  COMENTARIOS:

  Con una clase Borrador puedo configurar los atributos antes de la creacion de la prenda
  El patron BUilder me permite
  -Hacer cosas en orden,
  -Validar las cosas una despues de la otra
  -Separar la mutabilidad del sistema (Borrador es mutable, pero prenda no)

  Recomendacion: QUe la prenda siempre se cree completa para evitar incosistencias

  Al cargar valores en una clase borrador, los datos quedan guardados sin necesidad de crear una prenda

  Borrador NO es una prenda, solo sirve para crear prendas (semantica parecida y estado parecido)
  Uno se encarga de laa creacion y otro del uso
  Necesitamos un estado mutable para configurar valores, pero tambien necesitamos estado inmutable para garantizar
  validaciones calidad, y es mas facil razonar sobre entidades/componentes que no son mutables
  Borrador implemena conceptos de tiempo en la construccion
  Borrador diseñado para la construccion de un objeto consistente
  Testing mas sencillos con objetos inmutables

   */

  //Permite diferir en el tiempo la constrccion

  /*Tener un objeto mutable que podemos usar*/
  public BorradorPrenda(TipoPrenda tipoPrenda) {
    this.trama = Trama.LISA;
    this.tipoPrenda = requireNonNull(tipoPrenda, "Falta tipo");
    ;
  }

  void especificarTipo(TipoPrenda tipoPrenda) {
    this.tipoPrenda = tipoPrenda;
  }

  public void especificarMaterial(String material) {
    this.material = material;
  }

  public void especificarColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void especificarTrama(Trama trama) {
    this.trama = trama;
  }

  public void indicarFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
  }

  /*Builder: Como es clase comun y corriente puedo implementar lo que se necesite:

  -validar
  -poner valores por defecto
  -autogenerar configuraciones
  -menos frecuente (aparece en representaciones de libro) implementar polimorfismo
  -Abstraernos de la representacion interna
  -Tener representacion mutables en objetosi inmutables
  -Para diferir en el tiempo la construccion de objetos
  -Ayuda en testing
   */

  public Prenda construir() {

    requireNonNull(this.colorPrimario, "Falta colorPrimario");
    requireNonNull(this.material, "Falta Material");
    if (this.trama == null) {
      this.trama = Trama.LISA;
    }

    return new Prenda(tipoPrenda, colorPrimario, material, colorSecundario, trama, formalidad);
  }
  //Aca ya puedo usar prenda

  /*NOTA: Herencia se utiliza solo y solo para reutilizar codigo*/


}
