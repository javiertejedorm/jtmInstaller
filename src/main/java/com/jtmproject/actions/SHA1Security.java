package com.jtmproject.actions;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

@SuppressWarnings("restriction")
public class SHA1Security {

	/**
	 * this function generates a key with sha1 algorithm
	 * @param s
	 * @param keyString
	 * @return
	 */
	public static String generateSHA1(String s, String keyString){
		SecretKeySpec key = null;
		byte[] bytes = null;
		try{

			key = new SecretKeySpec((keyString).getBytes("UTF-8"), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(key);
			bytes = mac.doFinal(s.getBytes("UTF-8"));

		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch (java.security.InvalidKeyException e){
			e.printStackTrace();
		}

		return new String(DatatypeConverter.printBase64Binary(bytes));
	}
}
