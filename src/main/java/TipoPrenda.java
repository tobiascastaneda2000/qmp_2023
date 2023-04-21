public class TipoPrenda {
  Categoria categoria;

  TipoPrenda(Categoria categoria){
    this.categoria = categoria;
  }
  public Categoria devolverCategoria(){
    return this.categoria;
  }
}
