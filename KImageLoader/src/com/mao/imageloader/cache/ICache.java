package com.mao.imageloader.cache;

/**
 * ����ӿ�
 * 
 * @author mao
 *
 */
public interface ICache<K, V> {

	/**
	 * ��ӻ�����
	 *
	 * @param key ��
	 * @param value ֵ
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	boolean put(K key, V value);
	
	/**
	 * ��ָ����key��ȡ������
	 * 
	 * @param key Ҫ��ȡ�Ļ������key
	 * @return ��ȡ�ɹ�������Ӧ�Ļ��棬ʧ�ܷ���null
	 */
	V get(K key);
	
	/**
	 * ������л���
	 * 
	 * @return ����ɹ�����true��ʧ�ܷ���false
	 */
	boolean clear();
}
