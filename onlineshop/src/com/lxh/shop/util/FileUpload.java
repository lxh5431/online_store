package com.lxh.shop.util;

import com.lxh.shop.model.FileImage;

public interface FileUpload {

	//ʵ���ļ��ϴ��Ĺ��ܣ������ϴ����µ��ļ�����
	public abstract String uploadFile(FileImage fileImage);
	//������е�ͼ��
	public String[] getBankImage();
}