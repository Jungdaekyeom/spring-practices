package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	// 디렉토리 이름
	// 파일 경로(/upload-images/)가 있는지 확인해보고, 없으면 자동으로 만들게 만드는 것도 좋다.
	private static String SAVE_PATH = "/upload-images";

	// 실제 저장하는 위치랑 맵핑하는 값이 다르다
	private static String URL_BASE = "/images";

	public String restore(MultipartFile multipartFile) {
		String url = null;
		try {
			if (multipartFile.isEmpty()) {
				return url;
			}

			String originFilename = multipartFile.getOriginalFilename();
			// image.my.png의 png앞 .부터 .을 포함한(+1) substring
			// lastindexof하면 위치값이 숫자로 나올거임.
			String extName = originFilename.substring(originFilename.lastIndexOf('.') + 1);
			String saveFilename = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();

			System.out.println("####################################" + originFilename);
			System.out.println("####################################" + fileSize);
			System.out.println("####################################" + saveFilename);

			byte[] data = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + "saveFilename");
			os.write(data);
			os.close();

			url = URL_BASE + "/" + saveFilename;
		} catch (IOException ex) {
			throw new RuntimeException("file upload error : " + ex);
		}
		return url;
	}

	private String generateSaveFilename(String extName) {

		String filename = "";

		Calendar calendar = Calendar.getInstance();

		// calendar.get(Calendar.YEAR);
		filename += calendar.get(calendar.YEAR);
		filename += calendar.get(calendar.MONTH);
		filename += calendar.get(calendar.DATE);
		filename += calendar.get(calendar.HOUR);
		filename += calendar.get(calendar.MINUTE);
		filename += calendar.get(calendar.SECOND);
		filename += calendar.get(calendar.MILLISECOND);
		filename += ("." + extName);

		return null;
	}

}
