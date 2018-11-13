package com.example.crypto.keystore;

import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import com.example.crypto.symetric.SymetricCryptoUtils;


public class KeyStoreUtils {

	// default type does not store private key
	private static final String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";

	public static KeyStore createKeyStore(String keystorePassword, String keyAlias, SecretKey secretKey,
			String secretKeyPassword) throws Exception {
		KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
		keyStore.load(null, keystorePassword.toCharArray());
		KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());
		KeyStore.SecretKeyEntry privateKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
		keyStore.setEntry(keyAlias, privateKeyEntry, entryPassword);
		return keyStore;
	}

	public static void main(String[] args) throws Exception {
		SecretKey secretKey = SymetricCryptoUtils.createAESKey();
		String secretKeyHex = DatatypeConverter.printHexBinary(secretKey.getEncoded());
		KeyStore keyStore = KeyStoreUtils.createKeyStore("password", "foo", secretKey, "keyPassword");

		keyStore.load(null, "password".toCharArray());
		KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection("keyPassword".toCharArray());
		KeyStore.SecretKeyEntry resultEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry("foo", entryPassword);
		SecretKey result = resultEntry.getSecretKey();
		String resultKeyHex = DatatypeConverter.printHexBinary(result.getEncoded());

		System.out.println(secretKeyHex);
		System.out.println(resultKeyHex);
		// equal key
	}
}
