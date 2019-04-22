package com.lee.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class TransCode1 {

	private final static String PUBLICKEY = "CTFOTRV1";// 公共秘钥
	private final static String VERSION = "sdk4.0";// SDK 版本号

	/**
	 * 输入解码的信息与解码的编码规则，返回解码后的字符串
	 *
	 * @param message
	 *            待解码消息
	 * @param key
	 *            编码
	 * @return 解码后字符串
	 * @throws Exception
	 */
	private static String decode(String message, String key) throws Exception {
		// byte[] bytesrc = convertHexString(message);
		// Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		// DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		// SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		// IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		//
		// cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		//
		// byte[] retByte = cipher.doFinal(bytesrc);
		// return new String(retByte);
		return new String(message.getBytes(), "UTF-8");
	}

	/**
	 * 85 指定编码对字符串进行转码
	 *
	 * @param message
	 *            待转码消息
	 * @param key
	 *            编码
	 * @return 转码后数据
	 * @throws Exception
	 */
	private static byte[] encode(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return cipher.doFinal((message + "&s=2&v=" + VERSION).getBytes("UTF-8"));
	}

	/**
	 * 把待解码字符串转换为字节数组
	 *
	 * @param ss
	 *            待解码信息
	 * @return 字节数组
	 */
	private static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	/**
	 * 对外提供转码方法，默认为 UTF-8 编码格式
	 *
	 * @param message
	 *            待转码信息 86
	 * @return 转码后的字符串
	 */
	public static String encode(String message) {
		if (message == null || message.trim().length() == 0) {
			System.err.println("message is empty");
			return null;
		}
		try {
			String mw = toHexString(encode(message, PUBLICKEY)).toUpperCase();
			return mw;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 对外提供的解码方法，默认为 UTF-8 解码
	 *
	 * @param ciphertext
	 *            待解码字符串
	 * @return 解码后信息
	 * @throws Exception
	 */
	public static String decode(String ciphertext) throws Exception {
		try {
			String clearText = decode(ciphertext, PUBLICKEY);
			return clearText;
		} catch (Exception e) {
			System.err.println("ciphertext is empty");
			return null;
		}
	}

	/**
	 * 数据转码方法
	 *
	 * @param b
	 *            待转码的字节数组
	 * @return 转码后的字符串
	 */
	private static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

	public static void main(String[] args) throws Exception {
		String ttt = encode("vclN=粤 A00001&pltClr=2");
		System.out.println("转码后的数据为:" + ttt);
		System.out.println("解码后的数据 :" + decode(ttt));
	}
}
