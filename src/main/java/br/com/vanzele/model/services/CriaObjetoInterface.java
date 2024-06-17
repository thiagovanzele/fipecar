package br.com.vanzele.model.services;

import java.util.List;

public interface CriaObjetoInterface {
	
	<T> T retornaDado(String json, Class<T> classe);
	<T> List<T> retornaListaDados(String json, Class<T> classe);

}
