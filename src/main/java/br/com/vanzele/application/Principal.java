package br.com.vanzele.application;

import java.util.Scanner;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void exibeMenu() {
		
		System.out.println("\n[1] - Carros\n[2] - Motos\n[3] - Caminhões");
		System.out.print("\nSua opção: ");
		Integer opcao = sc.nextInt();			
		
	}
	

}
