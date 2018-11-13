package com.example.crypto.signature;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.xml.bind.DatatypeConverter;

import com.example.crypto.assymetric.AssymetricEncryptionUtils;


public class DigitalSignatureString {

	private static final String SIGNING_ALGORITHM = "SHA256withRSA";

	public static byte[] createDigitalSignature(byte[] input, PrivateKey privateKey) throws Exception {
		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
		signature.initSign(privateKey);
		signature.update(input);
		return signature.sign();
	}

	public static Boolean verifyDigitalSignature(byte[] input, byte[] signatureToVerify, PublicKey publicKey)
			throws Exception {
		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
		signature.initVerify(publicKey);
		signature.update(input);
		return signature.verify(signatureToVerify);

	}

	public static void main(String[] args) throws Exception {
		URL url = DigitalSignatureString.class.getClassLoader().getResource("demo.txt");
		Path path = Paths.get(url.toURI());
		byte[] input = Files.readAllBytes(path);
		KeyPair keyPair = AssymetricEncryptionUtils.generateRSAKeyPair();
		byte[] signature = createDigitalSignature(input, keyPair.getPrivate());
		System.out.println(DatatypeConverter.printHexBinary(signature));
		verifyDigitalSignature(input, signature, keyPair.getPublic());
	}

}
