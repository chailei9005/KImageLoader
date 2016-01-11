package com.mao.imageloader.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;

public class BitmapUtils {

	/**
     * <p>��ȡBitmap��С,�÷���Ϊ�汾���ݵ�.</p>
     * 
     * @param bitmap ָ����λͼ,ע�ⲻ��Ϊnull.
     * 
     * @return ���bitmapΪnull��ô������0,���򷵻�ָ��λͼ�Ĵ�С,��λΪ�ֽ�.
     * 
     * @author ��ӱ�
     * */
    @SuppressLint("NewApi")
	public static int sizeOfBitmap(Bitmap bitmap) {
    	if(bitmap == null) {
    		return 0;
    	}
    	//API 19�����ϰ汾
    	if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    		return bitmap.getAllocationByteCount();
    	//API 12 ~ API 18
    	} else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
    		return bitmap.getByteCount();
    	//API 12����
    	} else {
    		return bitmap.getRowBytes() * bitmap.getHeight();
    	}
    }
}
