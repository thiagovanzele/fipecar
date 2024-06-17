package br.com.vanzele.model.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.vanzele.model.exceptions.JsonException;

public class CriaObjetoService implements CriaObjetoInterface {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public <T> T retornaDado(String json, Class<T> classe) {
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			throw new JsonException("Erro ao retornar objeto");
		}
	}

	@Override
	public <T> List<T> retornaListaDados(String json, Class<T> classe) {
		CollectionType lista = mapper.getTypeFactory()
				.constructCollectionType(List.class, classe);
		
		try {
			return mapper.readValue(json, lista);
		} catch (JsonProcessingException e) {
			throw new JsonException("Erro ao retornar a lista");
		}
	}

}
