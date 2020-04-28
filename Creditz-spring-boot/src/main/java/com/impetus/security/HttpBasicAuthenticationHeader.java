package com.impetus.security;

import java.util.Base64;

public class HttpBasicAuthenticationHeader {
	
	public String decoder(String auth) {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode((auth.split(" "))[1]);

		return new String(decodedByteArray);
	}
}