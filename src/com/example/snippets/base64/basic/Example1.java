package com.example.snippets.base64.basic;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Example1 {
	public static void main(String[] args) {
		try {
			String base64Str = Base64.getEncoder().encodeToString("Hello".getBytes("utf-8"));
			System.out.println(base64Str);

			byte[] base64dec = Base64.getDecoder().decode(base64Str);
			System.out.println("original str" + base64dec);

			String base64encodedString = Base64.getUrlEncoder().encodeToString("hello?world".getBytes("utf-8"));
			System.out.println("Base64 Encoded String (URL) :" + base64encodedString);

			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);

			System.out.println("Base64 Encoded String (MIME):" + mimeEncodedString);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
