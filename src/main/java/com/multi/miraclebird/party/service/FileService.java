package com.multi.miraclebird.party.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	public String uploadFile(String uploadPath, String oriImgName, byte[] fileData) throws IOException {
		UUID uuid = UUID.randomUUID();
		String extension = oriImgName.substring(oriImgName.lastIndexOf("."));
		String imgName = uuid.toString() + extension;
		String fileUploadFullUrl = uploadPath + "/" + imgName;
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		fos.write(fileData);
		fos.close();
		
		return imgName;
	}
	
	public void deleteFile(String filePath) {
		File deleteFile = new File(filePath);
		
		if (deleteFile.exists()) {
			deleteFile.delete();
			System.out.println("파일을 삭제했습니다.");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}
