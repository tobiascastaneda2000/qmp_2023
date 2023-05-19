package ar.edu.utn.frba.dds.prenda;

public class TipoPrenda {
  Categoria categoria;
  Integer temperaturaMax;

  public TipoPrenda(Categoria categoria, Integer temperaturaMax) {
    this.categoria = categoria;
    this.temperaturaMax = temperaturaMax;
  }

  public Integer getTemperaturaMax() {
    return temperaturaMax;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }
}
