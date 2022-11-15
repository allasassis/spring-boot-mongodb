package com.allasassis.workshopmongo.resources.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// essa classe serve para codificarmos o texto que vai ser passado na URL para não ter caracteres especiais

public class URL implements Serializable{

	private static final long serialVersionUID = 1L;

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
