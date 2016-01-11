package com.mao.imageloader.cache.disk;

import java.io.InputStream;
import java.io.OutputStream;

import com.mao.imageloader.cache.ICache;

public abstract class BaseDiskCache<K, V> implements ICache<K, V>{

	
	/**
	 * �������������ݸ��Ƶ�key��Ӧ���������
	 * 
	 * @param is ������
	 * @param key �������key
	 * @return ���Ƴɹ�����true��ʧ�ܷ���false
	 */
	public abstract boolean copyIo(InputStream is, K key);
	
}
