package lavaRapido.model;

public class Cliente {

	private String nome;
	private String numeroContato;
	private String tipoCarro;

	public Cliente(String nome, String numeroContato, String tipoCarro) {
		this.nome = nome;
		this.numeroContato = numeroContato;
		this.tipoCarro = tipoCarro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public String getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public void visualizar() {
		System.out.println("Nome: " + nome);
		System.out.println("Contato: " + numeroContato);
		System.out.println("Tipo de Carro: " + tipoCarro);
	}
}
