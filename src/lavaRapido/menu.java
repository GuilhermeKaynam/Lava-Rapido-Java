package lavaRapido;

import java.util.Scanner;
import lavaRapido.util.cores;
import lavaRapido.Controller.LavaRapidoController;

public class menu {
	private static LavaRapidoController controller = new LavaRapidoController();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;
		do {
			exibirMenu();
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				listarClientes();
				break;
			case 3:
				cadastrarProduto();
				break;
			case 4:
				listarProdutos();
				break;
			case 5:
				agendarServico();
				break;
			case 6:
				listarAgendamentos();
				break;
			case 7:
				comprarProduto();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}

		} while (opcao != 0);
	}

	public static void exibirMenu() {
		System.out.println("*****************************************************");
		System.out.println(cores.TEXT_CYAN_BOLD + "         LAVA RÁPIDO - Relâmpago Marquinhos                  "
				+ cores.TEXT_RESET);
		System.out.println("*****************************************************");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Listar Clientes");
		System.out.println("3 - Adicionar Produto");
		System.out.println("4 - Listar Produtos");
		System.out.println("5 - Agendar Serviço");
		System.out.println("6 - Listar Agendamentos");
		System.out.println("7 - Comprar Produto");
		System.out.println(cores.TEXT_RED_BOLD + "0 - Sair" + cores.TEXT_RESET);
		System.out.println("*****************************************************");
		System.out.print("Escolha uma opção: ");
	}

	public static void cadastrarCliente() {
		System.out.println("\nCadastrar Cliente:");

		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Número de Contato: ");
		String numeroContato = scanner.nextLine();

		System.out.print("Modelo do carro: ");
		String tipoCarro = scanner.nextLine();

		controller.adicionarCliente(nome, numeroContato, tipoCarro);
	}

	public static void listarClientes() {
		System.out.println("\nLista de Clientes:");
		controller.listarClientes();
	}

	public static void cadastrarProduto() {
		System.out.println("\nCadastrar Produto:");

		System.out.print("Tipo de Produto: ");
		String tipo = scanner.nextLine();

		System.out.print("Preço: ");
		float preco = scanner.nextFloat();

		System.out.print("Estoque inicial: ");
		int estoque = scanner.nextInt();
		scanner.nextLine();

		controller.adicionarProduto(tipo, preco, estoque);
	}

	public static void listarProdutos() {
		System.out.println("\nLista de Produtos:");
		controller.listarProdutos();
	}

	public static void agendarServico() {
		System.out.println("\nAgendar Serviço:");

		System.out.print("Nome do Cliente: ");
		String nomeCliente = scanner.nextLine();

		System.out.println("Tipos de Lavagem:");
		System.out.println("1. Lavagem Simples");
		System.out.println("2. Lavagem Completa");
		System.out.println("3. Lavagem Rápida");
		System.out.print("Escolha o tipo de lavagem: ");
		int tipoLavagemEscolhido = scanner.nextInt();
		scanner.nextLine();

		String tipoLavagem = "";
		switch (tipoLavagemEscolhido) {
		case 1:
			tipoLavagem = "Lavagem Simples";
			break;
		case 2:
			tipoLavagem = "Lavagem Completa";
			break;
		case 3:
			tipoLavagem = "Lavagem Rápida";
			break;
		default:
			System.out.println("Opção inválida! Lavagem não cadastrada.");
			return;
		}

		System.out.print("Data do Agendamento (Formato: dd/MM/yyyy): ");
		String data = scanner.nextLine();

		controller.agendarServico(nomeCliente, tipoLavagem, data);
	}

	public static void listarAgendamentos() {
		System.out.println("\nLista de Agendamentos:");
		controller.listarAgendamentos();
	}

	public static void comprarProduto() {
		System.out.println("\nComprar Produto:");
		controller.listarProdutos();

		System.out.print("Digite o tipo do produto que deseja comprar: ");
		String tipoProduto = scanner.nextLine();

		System.out.print("Quantidade desejada: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();

		controller.comprarProduto(tipoProduto, quantidade);
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Guilherme Kaynam ©");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/GuilhermeKaynam");
		System.out.println("*********************************************************");
	}
}
