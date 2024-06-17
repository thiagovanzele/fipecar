package br.com.vanzele.application;

import java.util.List;
import java.util.Scanner;

import br.com.vanzele.application.model.entities.Dados;
import br.com.vanzele.model.exceptions.FilterException;
import br.com.vanzele.model.services.ConsomeApiService;
import br.com.vanzele.model.services.CriaObjetoService;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
	private static CriaObjetoService service = new CriaObjetoService();
	
	
	public static void exibeMenu() {
		System.out.println("\n[1] - Carros\n[2] - Motos\n[3] - Caminhões");
			
		String endereco = URL_BASE + escolheTipo() + "/marcas/";
		String json = ConsomeApiService.retornaJson(endereco);
		List<Dados> marcas = service.retornaListaDados(json, Dados.class);
		
		Dados marcaFiltrada = escolheMarca(marcas);
		
	}
	
	public static String escolheTipo() {
		//Classe responsável por devolver o tipo de veículo baseado na escolha do usuário
		System.out.print("\nSua opção: ");
		Integer opcao = sc.nextInt();		
		sc.nextLine();
		
		if (opcao == 1) {
			return "carros";
		} else if (opcao == 2) {
			return "motos";
		} else {
			return "caminhoes";
		}
		
	}
	
	public static Dados escolheMarca(List<Dados> listaMarcas) {
		System.out.print("Marca: ");
		String marcaSelecionada = sc.nextLine();
		return listaMarcas.stream().filter(n -> n.nome().toLowerCase().contains(marcaSelecionada.toLowerCase())).findFirst().orElseThrow(() -> new FilterException("Não encontrado"));
	}
}
