package com.mao.imageloader;

import java.util.ArrayList;
import java.util.List;

import com.mao.imageloader.core.ImageLoadTask;
import com.mao.imageloader.core.ImageLoaderAssistant;
import com.mao.imageloader.core.ImageLoaderConfiguration;
import com.mao.imageloader.core.ImageLoaderOptions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * ͼƬ������,֧��һ�Զ����,֧��ָ�����ȼ�����
 * 
 * @author mao
 *
 */
public class ImageLoader {

	private final static String TAG = "ImageLoader";
	
	/** Ψһʵ�� */
	private final static ImageLoader sImageLoader = new ImageLoader();
	
	/** ImageLoader������ */
	private ImageLoaderAssistant mImageLoaderAssistant;
	
	private ImageLoader() {	
		mImageLoaderAssistant = new ImageLoaderAssistant();
	}
	
	/**
	 * ��ȡImageLoaderΨһʵ������
	 * 
	 * @return ����ImageLoaderΨһʵ������
	 */
	public static ImageLoader getInstance() {
		return sImageLoader;
	}
	
	/**
	 * ��ʾͼƬ
	 * 
	 * @param context ������
	 * @param url Ҫ���ص�ͼƬurl��ַ,����Ϊ��
	 * @param imageView Ҫ��ʾ��ImageView,����Ϊ��
	 */
	public void displayImage(Context context, String url, ImageView imageView) {
		displayImage(context, url, imageView, null);
	}
	
	public void displayImage(Context context, String url, ImageView imageView, ImageLoaderOptions opts) {
		displayImage(context, url, imageView, opts, null);
	}
	
	/**
	 * ��ʾͼƬ
	 * 
	 * @param context ������
	 * @param url Ҫ���ص�ͼƬurl��ַ,����Ϊ��
	 * @param imageView Ҫ��ʾ��ImageView,����Ϊ��
	 * @param listener ������
	 */
	public void displayImage(Context context, String url, ImageView imageView, ImageLoaderOptions opts, ImageLoaderListener listener) {
		if(imageView == null) {
			return;
		}
		List<ImageView> imageViews = new ArrayList<ImageView>(1);
		imageViews.add(imageView);
		displayImage(context, url, imageViews, opts, listener);
	}
	
	/**
	 * ��ʾͼƬ
	 * 
	 * @param context ������
	 * @param url Ҫ���ص�ͼƬurl��ַ,����Ϊ��
	 * @param imageViews Ҫ��ʾ��ImageView����,����Ϊ���Ҵ�С�������0
	 */
	public void displayImage(Context context, String url, List<ImageView> imageViews) {
		displayImage(context, url, imageViews, null);
	}
	
	public void displayImage(Context context, String url, List<ImageView> imageViews, ImageLoaderOptions opts) {
		displayImage(context, url, imageViews, opts, null);
	}
	
	/**
	 * ��ʾͼƬ
	 * 
	 * @param context ������
	 * @param url Ҫ���ص�ͼƬurl��ַ,����Ϊ��
	 * @param imageViews Ҫ��ʾ��ImageView����,����Ϊ���Ҵ�С�������0
	 * @param listener ������
	 */
	public void displayImage(Context context, String url, List<ImageView> imageViews, ImageLoaderOptions opts, ImageLoaderListener listener) {
		if(context == null || TextUtils.isEmpty(url)
						   || imageViews == null
						   || imageViews.size() <= 0) {
			return;
		}
		ImageLoadTask task = new ImageLoadTask(url, imageViews);
		task.setOptions(opts);
		task.setImageLoaderListener(listener);
		mImageLoaderAssistant.submit(task);	
	}
	
	/**
	 * ����ImageLoader����
	 * 
	 * @param config Ҫ���õ�ImageLoader����
	 */
	public void setImageLoaderConfiguration(ImageLoaderConfiguration config) {
		mImageLoaderAssistant.setImageLoaderConfiguration(config);
	}
	
	/**
	 * ��ȡImageLoader����
	 * 
	 * @return ����ImageLoader����
	 */
	public ImageLoaderConfiguration getImageLoaderConfiguration() {
		return mImageLoaderAssistant.getImageLoaderConfiguration();
	}
}
