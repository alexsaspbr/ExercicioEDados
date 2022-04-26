package exercicio_EDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Monitor {
	
	
	
	
	Scanner lerOpcao = new Scanner (System.in);
	Scanner lerDouble = new Scanner (System.in);
	Utilities utilities = new Utilities ();
	
	public void monitor (String nome, Integer indice, Carro[] frota, ArrayList<Cliente> clientes, ArrayList<Cliente> filaEspera,
			ArrayList<RegistroLog> alugados, Stack<RegistroLog> log) {
		
		String opcao = utilities.menu ();
		 // "indice" indica pr�xima posi��o livre ou aponta para posi��o ilegal caso lista cheia
		do {
			switch (opcao) {
			case "1":			// Cadastrar carro
				if (indice >= frota.length) {
					frota = Arrays.copyOf (frota, frota.length*2); // aumenta o tamenho da string
				}
				utilities.cadastrarCarro (frota, indice);
				indice = indice+1;
				break;
			case "2":				// Remover carro da lista
				if (indice != 0) {
					if (utilities.removerCarro (frota, indice) == true) {
						indice--;
					}
				} else {
					System.out.println("N�o h� carros a remover!\n");
				}
				break;
			case "3":				// tornar caaro dispon�vel/indispon�vel
				if (indice != 0) {
					utilities.mudarEstado (frota, indice);
				} else {
					System.out.println("N�o h� carros cadastrados!\n");
				}
				break;
			case "4":				// Cadastrar clientes
				utilities.cadastrarCliente (clientes);
				break;
			case "5": 			 // aluguel de carro
				utilities.alugarCarro (frota, indice, clientes, filaEspera, alugados);
				break;
			case"6":			// devolu��o de aluguel
				utilities.devolverCarro (frota, indice, clientes, filaEspera, alugados);
				break;
			case "7":				// relat�rios
				Relatorios relatorios = new Relatorios ();
				relatorios.relatorios (frota, indice, clientes, filaEspera, alugados);
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