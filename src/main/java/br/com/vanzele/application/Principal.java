package br.com.vanzele.application;

import java.util.Scanner;

import br.com.vanzele.model.services.ConsomeApiService;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
	
	
	public static void exibeMenu() {
		System.out.println("\n[1] - Carros\n[2] - Motos\n[3] - Caminhões");
		System.out.print("\nSua opção: ");
		Integer opcao = sc.nextInt();			
		String endereco = URL_BASE + escolheTipo(opcao) + "/marcas/";
		String json = ConsomeApiService.retornaJson(endereco);
		
		
		
	}
	
	public static String escolheTipo(Integer opcao) {
		//Classe responsável por devolver o tipo de veículo baseado na escolha do usuário
		if (opcao == 1) {
			return "carros";
		} else if (opcao == 2) {
			return "motos";
		} else {
			return "caminhoes";
		}
		
	}
}
