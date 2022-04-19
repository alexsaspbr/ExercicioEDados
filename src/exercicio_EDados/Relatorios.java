package exercicio_EDados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Relatorios {
	
	Scanner lerOpcao = new Scanner (System.in);	
	Utilities utilities = new Utilities ();
	
	public void relatorios (Carro [] fiftyCar, int indice, ArrayList <Cliente> clientes, ArrayList <Cliente> fila,
			ArrayList <Log> alugados) {
		
		String opcao = menuRelatorios ();
		switch (opcao) {
		case "1": // listar carros dispon�veis
			if (indice != 0) {	
				utilities.listarCarrosDisponiveis (fiftyCar, indice);
			} else {
				System.out.println("N�o h� carros cadastrados!\n");
			}
			break;
		case "2":  // listar por pre�o
			if (indice != 0) {
				utilities.listarPorPreco (fiftyCar, indice);
			} else {
				System.out.println("N�o h� carros cadastrados!\n");
			}
			break;
		case "3":		// imprimir lista de espera
			if (fila.size() != 0) {
				Cliente clienteEmEspera = new Cliente ();
				for (int i = 0; i < fila.size(); i++) {
					clienteEmEspera = fila.get(i);
					System.out.println(clienteEmEspera.toString());
				}
			}
			break;
		case "4":
			if (alugados.size() !=0) {
				alugados.forEach((Log registro) -> {
					String data = new SimpleDateFormat ("dd/MM/yyyy '�s' HH:mm 'horas'").format (registro.getDataEntrada());
					System.out.printf("Carro Marca: %s, Modelo: %s alugado para cliente: %s, Fone: %s no dia %s%n%n",
							registro.getCarro().getMarca(), registro.getCarro().getModelo(), registro.getCliente().getNome(),
							registro.getCliente().getTelefone(), data );
				});
			} else {
				System.out.println("N�o h� carros alugados!\n");
			}
			break;
		case "5":
			Log l = new Log ();
			l.imprimeLog ();
			break;
		case "0":
			System.out.println("Obrigado por consultar nossas op��es! Volte sempre � Pangeia Locadora!");
			return;
		default:
			System.out.println("Op��o Inv�lida\n");
		}
	}
	
	public String menuRelatorios () {
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("Digite a op��o desejada: \n");
		prompt.append("1 - Imprimir lista dos carros dispon�veis\n");
		prompt.append("2 - Imprimir lista por pre�o (mais baratos primeiro) \n");
		prompt.append("3 - Imprimir lista de espera \n");
		prompt.append("4 - Imprimir relat�rio de carros alugados\n");
		prompt.append ("5 - Imprimir relat�rio de movimenta��o (alugados j� devolvidos)\n");
		prompt.append("0 - Sair \n");
		
		System.out.println(prompt.toString ());

		return lerOpcao.nextLine();
	}

}
