import java.util.List;

public class Atuendo {

  List<Prenda> prendas;

  public void cargarPrendaValida(Prenda prenda){
    if(prenda.esValida()){
     prendas.add(prenda);
    }
    else{
      throw new ValidacionException("La prenda no es valida");
    }
  }



}


