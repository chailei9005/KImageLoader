package com.mao.imageloader;

import java.util.List;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * ͼƬ���ؼ����ӿ�
 * 
 * @author mao
 *
 */
public interface ImageLoaderListener {

	/**
	 * ��ͼƬ��ʼ����ʱ�ص��÷���,ע��ͼƬ��ʼ���ز�����ָ�ͻ��˴�����ü��ط���ʱ��
	 * ���ǵ�����Ҫ����ͼƬʱ.
	 * 
	 * @param url ͼƬurl��ַ
	 * @param imageViews ��ʾͼƬ��ImageView����
	 */
	void onImageLoadTaskStart(String url, List<ImageView> imageViews);
	
	/**
	 * ��ͼƬ���سɹ�ʱ�ص��÷���.
	 * 
	 * @param url ͼƬurl��ַ
	 * @param imageViews ��ʾͼƬ��ImageView����
	 * @param bitmap ��ȡ����λͼ
	 */
	void onImageLoadTaskSuccess(String url, List<ImageView> imageViews, Bitmap bitmap);
	
	/**
	 * ��ͼƬ����ʧ��ʱ�ص��÷���.
	 * 
	 * @param url ͼƬurl��ַ
	 * @param imageViews ��ʾͼƬ��ImageView����
	 */
	void onImageLoadTaskFail(String url, List<ImageView> imageViews);
}
