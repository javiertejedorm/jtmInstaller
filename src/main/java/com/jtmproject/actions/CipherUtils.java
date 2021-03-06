package com.jtmproject.actions;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

/**
 * this class encrypts and decrypts strings
 * @author Javier Tejedor
 * @tnks http://www.code2learn.com/2011/06/encryption-and-decryption-of-data-using.html
 */
public class CipherUtils{

	private static final String AES = "AES";
	private static final byte[] keyValue = new byte[] { 0x70, 0x34, 0x45, 0x56, 0x27, 0x28, 0x28, 0x27, 0x44, 0x23, 0x32, 0x76, 0x67, 0x4a, 0x6c, 0x7b };

	/**
	 * encrypts strings passed by parameters
	 * @param Data
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String encrypt(String Data){
		Key key;
		String encryptedValue = null;
		try {
			key = generateKey();
			Cipher c = Cipher.getInstance(AES);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(Data.getBytes());
			encryptedValue = new BASE64Encoder().encode(encVal);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encryptedValue;
	}

	/**
	 * decrypts strings passed by parameters
	 * @param encryptedData
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String decrypt(String encryptedData){
		String decryptedValue = null;
		Key key;
		try {
			key = generateKey();
			Cipher c = Cipher.getInstance(AES);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return decryptedValue;
	}

	/**
	 * generates the key
	 * @return
	 * @throws Exception
	 */
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, AES);
		return key;
	}

}
