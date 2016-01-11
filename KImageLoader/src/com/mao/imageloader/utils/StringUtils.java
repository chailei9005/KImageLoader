package com.mao.imageloader.utils;

/**
 * �ַ���������
 * 
 * @author mao
 *
 */
public class StringUtils {

	/**
	 * �ֽ�����תʮ�����Ʊ�ʾ��ʽ�ַ���
	 * 
	 * @param b Ҫת�����ֽ�����
	 * 
	 * @return ���dataΪnull��ô����null�����򷵻ظ��ֽ������ʮ�����Ʊ�ʾ��ʽ�ַ���
	 */
	public static String bytes2String(byte[] data) {
		if(data == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(4 * data.length);
		for(byte b : data) {
			sb.append(Integer.toHexString(b & 0x00FF));
		}
		return sb.toString();
	}
}
