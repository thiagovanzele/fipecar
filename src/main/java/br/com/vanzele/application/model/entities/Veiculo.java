package br.com.vanzele.application.model.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias("Valor") String valor, @JsonAlias("Marca") String marca,
		@JsonAlias("Modelo") String modelo, @JsonAlias("AnoModelo") String ano,
		@JsonAlias("Combustivel") String combustivel) {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nMarca: " + marca);
		sb.append("\nModelo: " + modelo);
		sb.append("\nAno: " + ano);
		sb.append("\nCombustível: " + combustivel);
		sb.append("\nValor: " + valor);

		return sb.toString();

	}
}
