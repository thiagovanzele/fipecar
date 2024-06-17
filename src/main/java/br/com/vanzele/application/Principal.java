package br.com.vanzele.application;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.vanzele.application.model.entities.Dados;
import br.com.vanzele.application.model.entities.Modelos;
import br.com.vanzele.application.model.entities.Veiculo;
import br.com.vanzele.model.exceptions.FilterException;
import br.com.vanzele.model.services.ConsomeApiService;
import br.com.vanzele.model.services.CriaObjetoService;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
	private static CriaObjetoService service = new CriaObjetoService();
	
	
	public static void exibeMenu() {
		System.out.println("\n[1] - Carros\n[2] - Motos\n[3] - Caminhões");
		
		String tipoVeiculo = escolheTipo();
		String endereco = URL_BASE + tipoVeiculo + "/marcas/";
		String json = ConsomeApiService.retornaJson(endereco);
		System.out.println("\n|" + tipoVeiculo.toUpperCase() + "|\n");
		
		//Lista com todas as marcas disponíveis na API
		List<Dados> marcas = service.retornaListaDados(json, Dados.class);
		
		//Lista com todos os modelos disponíveis da marca
		Dados marcaFiltrada = escolheMarca(marcas);
		System.out.println("\n|" + marcaFiltrada.nome().toUpperCase() + "|\n");
		
		endereco += marcaFiltrada.codigo() + "/modelos/";
		json = ConsomeApiService.retornaJson(endereco);
		Modelos modelos = service.retornaDado(json, Modelos.class);
		
		//Lista com os modelos disponíveis baseado no nome que usuário escolheu
		List<Dados> modelosDisponiveis = escolheNomeDoVeiculo(modelos);
		exibeModelos(modelosDisponiveis);
		
		endereco += escolheCodigoVeiculo();
		json = ConsomeApiService.retornaJson(endereco);
		
		//Lista com o modelo especifico dado pelo usuário
		List<Dados> listaModelosDisponiveis = service.retornaListaDados(json, Dados.class);
		exibeModelos(listaModelosDisponiveis);
		
		endereco += escolheAnoModelo();
		json = ConsomeApiService.retornaJson(endereco);
		
		Veiculo veiculo = service.retornaDado(json, Veiculo.class);
		System.out.println(veiculo);
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
	
	public static List<Dados> escolheNomeDoVeiculo(Modelos modelos) {
		System.out.print("Modelo: ");
		String modeloSelecionado = sc.nextLine();
		
		return modelos.modelos().stream().filter(n -> n.nome().toLowerCase().contains(modeloSelecionado.toLowerCase())).collect(Collectors.toList());
	}
	
	public static String escolheCodigoVeiculo() {
		System.out.print("\nCódigo: ");
		String codigo = sc.nextLine();
		return codigo + "/anos/";
	}
	
	public static void exibeModelos (List<Dados> modelos) {
		for (Dados m : modelos) {
			System.out.print("[Codigo: " + m.codigo() + "]");
			System.out.println(" - " + m.nome());
		}
	}
	
	public static String escolheAnoModelo() {
		System.out.print("Codigo: ");
		String codigo = sc.nextLine();
		return codigo;
	}
}
