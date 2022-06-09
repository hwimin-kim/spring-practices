package com.douzone.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile multipartFile) {
		String originFileName = multipartFile.getOriginalFilename();
		System.out.println("##########" + originFileName);
		return "";
	}

}
