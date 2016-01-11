package com.mao.imageloader.cache.memory;

import com.mao.imageloader.utils.BitmapUtils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/**
 * ����LruCache��Bitmap�ڴ滺�������
 * 
 * @author mao
 *
 */
public class LruMemoryCache extends BaseMemoryCache<String, Bitmap>{

	/** ���������ڴ����� */
	private final static float LIMIT_FACTOR = 15.0f;
	
	/** ��󻺴��С����λ���ֽڣ�Ĭ��Ϊ������С��1/6*/
	private final static int MAX_CACHE_SIZE = (int) (Runtime.getRuntime().maxMemory() / 6);
	
	private LruCache<String, Bitmap> sBitmapCache;
	
	private LruMemoryCache() {}
	
	private void init(int maxSize) {
		if(sBitmapCache == null) {
			sBitmapCache = new LruCache<String, Bitmap>(maxSize){
				
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return BitmapUtils.sizeOfBitmap(value);
				}
			};
		}
	}
	
	public static LruMemoryCache newMemoryCache() {
		return newMemoryCache(0);
	}
	
	public static LruMemoryCache newMemoryCache(int maxSize) {
		LruMemoryCache cache = new LruMemoryCache();
		if(maxSize <= 0) {
			maxSize = MAX_CACHE_SIZE;
		} 
		cache.init(maxSize);
		
		return cache;
	}
	
	@Override
	public boolean put(String key, Bitmap value) {
		if(TextUtils.isEmpty(key) || value == null) {
			return false;
		} else {
			//�ж��Ƿ����㹻���ڴ�
			if(checkRemainderMemory(value)) {
				sBitmapCache.put(key, value);
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public Bitmap get(String key) {
		if(TextUtils.isEmpty(key)) {
			return null;
		} else {
			return sBitmapCache.get(key);
		}
	}
	
	private boolean checkRemainderMemory(Bitmap bm) {
		long size = BitmapUtils.sizeOfBitmap(bm);
		Runtime runtime = Runtime.getRuntime();
		long total = runtime.maxMemory() - runtime.totalMemory() + runtime.freeMemory();
		if(size * LIMIT_FACTOR < total) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean clear() {
		if(sBitmapCache != null) {
			sBitmapCache.evictAll();
			return true;
		}
		return false;
	}
}
