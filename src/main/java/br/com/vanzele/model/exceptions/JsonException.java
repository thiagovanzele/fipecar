package br.com.vanzele.model.exceptions;

@SuppressWarnings("serial")
public class JsonException extends RuntimeException {

	public JsonException(String msg) {
		super(msg);
	}
}
