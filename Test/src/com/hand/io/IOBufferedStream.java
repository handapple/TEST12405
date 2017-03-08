package com.hand.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class IOBufferedStream<HttpServletResponse> {
	public static void main(String[] args) {
		String urladdress = "http://www.madore.org/~david/math/padics.pdf";
		String filename = "padics.pdf";
		new IOBufferedStream<Object>().downloadNet(urladdress,filename);
		//new IOBufferedStream<Object>().copy();
	}

	public void downloadNet(String urladdress,String filename) {
		//�Ի������ķ�ʽ��д�����ļ�
		int byteread = 0;//��¼��ȡ�ĳ���
		URL url = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			url = new URL(urladdress);
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			bis = new BufferedInputStream(is);
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			byte[] buffer = new byte[512];
			while ((byteread = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, byteread);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public void copy() {
		//�Ի������ķ�ʽ��д�����ļ�
		int byteread = 0;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("abc.pdf");
			bis = new BufferedInputStream(fis, 10240);
			fos = new FileOutputStream("123.pdf");
			bos = new BufferedOutputStream(fos, 10240);
			byte[] buffer = new byte[1024];
			while ((byteread = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, byteread);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
