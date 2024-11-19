package lavaRapido.Controller;

import java.util.ArrayList;
import lavaRapido.model.Agendamento;
import lavaRapido.model.Cliente;
import lavaRapido.model.Produto;

public class LavaRapidoController {
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Agendamento> agendamentos = new ArrayList<>();

	// Adicionar Cliente
	public void adicionarCliente(String nome, String numeroContato, String tipoCarro) {
		Cliente cliente = new Cliente(nome, numeroContato, tipoCarro);
		clientes.add(cliente);
		System.out.println("Cliente " + nome + " adicionado com sucesso!");
	}

	// Listar Clientes
	public void listarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Não há clientes cadastrados.");
		} else {
			for (Cliente cliente : clientes) {
				cliente.visualizar();
			}
		}
	}

	// Adicionar Produto
	public void adicionarProduto(String tipo, float preco, int estoque) {
		Produto produto = new Produto(tipo, preco, estoque);
		produtos.add(produto);
		System.out.println("Produto " + tipo + " adicionado com sucesso!");
	}

	// Listar Produtos
	public void listarProdutos() {
		if (produtos.isEmpty()) {
			System.out.println("Não há produtos cadastrados.");
		} else {
			for (Produto produto : produtos) {
				produto.visualizar();
			}
		}
	}

	// Buscar produto por tipo
	public Produto buscarProdutoPorTipo(String tipoProduto) {
		for (Produto produto : produtos) {
			if (produto.getTipo().equalsIgnoreCase(tipoProduto)) {
				return produto;
			}
		}
		return null; // Se não encontrar o produto
	}

	// Agendar Serviço
	public void agendarServico(String nomeCliente, String tipoLavagem, String data) {
		Cliente cliente = null;
		for (Cliente c : clientes) {
			if (c.getNome().equalsIgnoreCase(nomeCliente)) {
				cliente = c;
				break;
			}
		}
		if (cliente != null) {
			Agendamento agendamento = new Agendamento(cliente, tipoLavagem, data);
			agendamentos.add(agendamento);
			System.out.println("Serviço agendado para " + nomeCliente + " no dia " + data);
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	// Listar Agendamentos
	public void listarAgendamentos() {
		if (agendamentos.isEmpty()) {
			System.out.println("Não há agendamentos registrados.");
		} else {
			for (Agendamento agendamento : agendamentos) {
				agendamento.visualizar();
			}
		}
	}

	// Retornar a lista de produtos
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	// Método para comprar produto
	public void comprarProduto(String tipoProduto, int quantidade) {
		Produto produto = buscarProdutoPorTipo(tipoProduto);

		if (produto != null) {
			// Verificar se há estoque suficiente
			if (produto.getEstoque() >= quantidade) {
				produto.setEstoque(produto.getEstoque() - quantidade);
				System.out.println("Você comprou " + quantidade + " unidades de " + produto.getTipo() + " por R$ "
						+ (produto.getPreco() * quantidade) + " reais.");
				System.out.println("Estoque restante de " + produto.getTipo() + ": " + produto.getEstoque());
			} else {
				System.out.println("Estoque insuficiente para a quantidade solicitada.");
			}
		} else {
			System.out.println("Produto não encontrado!");
		}
	}
}
