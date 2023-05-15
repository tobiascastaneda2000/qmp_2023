package ar.edu.utn.frba.dds.prenda;

public class TipoPrenda {
  Categoria categoria;

  public TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }
}
