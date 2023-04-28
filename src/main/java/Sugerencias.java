import java.util.List;
import java.util.Optional;

public final class Sugerencias {

    List<Uniforme> atuendos;

    public static final Sugerencias instancia = new Sugerencias();

    public static Sugerencias getInstance(){
        return instancia;
    }

    public void guardar(Uniforme atuendo){
        //atuendo.validar();
        atuendos.add(atuendo);
    }

    public List<Uniforme> recibirSugerencia(){
            return this.atuendos;

    }

    public Sugerencias(){}
}
