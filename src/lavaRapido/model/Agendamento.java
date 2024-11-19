package lavaRapido.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Agendamento {

	private Cliente cliente;
	private String tipoLavagem;
	private String data;

	public Agendamento(Cliente cliente, String tipoLavagem, String data) {
		this.cliente = cliente;
		this.tipoLavagem = tipoLavagem;
		setData(data); // Chamada ao método setData para validar a data
	}

	// Métodos getter e setter

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipoLavagem() {
		return tipoLavagem;
	}

	public void setTipoLavagem(String tipoLavagem) {
		this.tipoLavagem = tipoLavagem;
	}

	public String getData() {
		return data;
	}

	// Validação de data: formato "dd/MM/yyyy", meses até 12 e dias até 31
	public void setData(String data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate parsedDate = LocalDate.parse(data, formatter);

			// Garantindo que o dia e o mês estejam dentro dos limites
			if (parsedDate.getMonthValue() > 12 || parsedDate.getDayOfMonth() > 31) {
				System.out.println("Data inválida! O mês deve ser até 12 e o dia até 31.");
			} else {
				this.data = data;
			}
		} catch (DateTimeParseException e) {
			System.out.println("Formato de data inválido! Use o formato dd/MM/yyyy.");
		}
	}

	public void visualizar() {
		System.out.println("Agendamento: " + cliente.getNome() + " - " + tipoLavagem + " - Data: " + data);
	}
}
