import java.util.Objects;
import java.util.Set;

public class Uniforme {
    Prenda superior;
    Prenda inferior;
    Prenda calzado;
    Set<Prenda> accesorios;
/*
    Uniforme(Prenda superior, Prenda inferior, Prenda calzado, Set<Prenda> accesorios) {
        super(superior, inferior, calzado, accesorios);
    }*/


    public Prenda getSuperior(){
        return this.superior;
    }


        public Uniforme(Prenda superior, Prenda inferior, Prenda calzado, Set<Prenda> accesorios){
            this.superior = superior;
            this.inferior = inferior;
            this.calzado = calzado;
            this.accesorios = accesorios;
        }
    public void validar(){
        Objects.requireNonNull(this.superior, "Falta deinir la prenda superior");
        Objects.requireNonNull(this.inferior, "Falta deinir la prenda inferior");
        Objects.requireNonNull(this.calzado, "Falta deinir el calzado");
    }


}
