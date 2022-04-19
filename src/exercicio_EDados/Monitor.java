package exercicio_EDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import exercicio_EDados.Utilities;


public class Monitor {
	
	Carro [ ] fiftyCar = new Carro [3]; 
	ArrayList <Cliente> clientes = new ArrayList <> ();
	ArrayList <Cliente> filaEspera = new ArrayList <> ();
	ArrayList <Log> alugados = new ArrayList <> ();
	
	
	Scanner lerOpcao = new Scanner (System.in);
	Scanner lerDouble = new Scanner (System.in);
	Utilities utilities = new Utilities ();
	
	public void monitor () {
		
		String opcao = utilities.menu ();
		int indice = 0; // indica pr�xima posi��o livre ou aponta para posi��o ilegal caso lista cheia
		do {
			switch (opcao) {
			case "1":			// Cadastrar carro
				if (indice >= fiftyCar.length) {
					fiftyCar = Arrays.copyOf (fiftyCar, fiftyCar.length*2); // aumenta o tamenho da string
				}
				utilities.cadastrarCarro (fiftyCar, indice);
				indice++;
				break;
			case "2":				// Remover carro da lista
				if (indice != 0) {
					if (utilities.removerCarro (fiftyCar, indice) == true) {
						indice--;
					}
				} else {
					System.out.println("N�o h� carros a remover!\n");
				}
				break;
			case "3":				// tornar caaro dispon�vel/indispon�vel
				if (indice != 0) {
					utilities.mudarEstado (fiftyCar, indice);
				} else {
					System.out.println("N�o h� carros cadastrados!\n");
				}
				break;
			case "4":				// Cadastrar clientes
				utilities.cadastrarCliente (clientes);
				break;
			case "5": 			 // aluguel de carro
				utilities.alugarCarro (fiftyCar, indice, clientes, filaEspera, alugados);
				break;
			case"6":			// devolu��o de aluguel
				utilities.devolverCarro (fiftyCar, indice, clientes, filaEspera, alugados);
				break;
			case "7":				// relat�rios
				Relatorios relatorios = new Relatorios ();
				relatorios.relatorios (fiftyCar, indice, clientes, filaEspera, alugados);
				break;
			case "0":				// sair
				System.out.println("Obrigado por consultar nossas op��es! Volte sempre � Pangeia Locadora!");
				return;
			default:
				System.out.println("Op��o Inv�lida\n");
			}
			
			opcao = utilities.menu ();
			
		} while (true);


	}

}
