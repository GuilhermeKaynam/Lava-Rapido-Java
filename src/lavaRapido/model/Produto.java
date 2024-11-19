package lavaRapido.model;

public class Produto {

	private String tipo;
	private float preco;
	private int estoque;

	public Produto(String tipo, float preco, int estoque) {
		this.tipo = tipo;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void visualizar() {
		System.out.println("Produto: " + tipo + " | Preço: R$ " + preco + " | Estoque: " + estoque);
	}
}