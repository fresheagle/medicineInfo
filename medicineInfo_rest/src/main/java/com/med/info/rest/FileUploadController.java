/**
 * 
 */
package com.med.info.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.med.info.dto.ImageResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.med.info.response.Response;
import com.med.info.service.AliyunOSSService;

/**
 * @author jialin.jiang
 *
 */
@RestController
@RequestMapping("/api/file")
public class FileUploadController {

	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	public static final String BASE_PATH = "temp/";
	@Autowired private AliyunOSSService aliyunOSSService;
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public Response upload(@RequestParam(value = "file", required = false) MultipartFile[] multipartFile) {
		try {
			List<ImageResponseDTO> imageResponseDTOS = new ArrayList<>();
			logger.info("上传文件数量为：{}", null == multipartFile ? null : multipartFile.length);
			if(null != multipartFile && multipartFile.length > 0){
				for (MultipartFile file : multipartFile) {
					String originalFilename = file.getOriginalFilename();
					String newFileName = getNewFileName(originalFilename);
					File targetFile = new File(new File(BASE_PATH).getAbsolutePath(), newFileName);
					if(!targetFile.getAbsoluteFile().exists()) {
						targetFile.getParentFile().mkdirs();
						targetFile.createNewFile();
					}
					file.transferTo(targetFile);
					ImageResponseDTO imageResponseDTOList = aliyunOSSService.upload(targetFile);
					if(null != imageResponseDTOList){
						imageResponseDTOS.add(imageResponseDTOList);
					}else {
						logger.error("文件上传失败，file={}", file.getOriginalFilename());
						throw new Exception("file="+file.getOriginalFilename());
					}
				}
				return new Response().success(imageResponseDTOS);
			}

		} catch (Exception e) {
			logger.error("文件上传失败", e);
		}
		return new Response().failure("文件上传失败,请重试");

	}

	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public void download(@RequestParam String fileName, HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Accept-Ranges", "bytes");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("application/octet-stream");
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setHeader("Content-disposition", "attachment; filename=" + fileName);
		byte[] b = new byte[1024];
		BufferedInputStream bufferedInputStream = null;
		FileInputStream fis = null;
		try (ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();) {
			File file = new File(new File(BASE_PATH).getAbsolutePath(), fileName);
//			aliyunOSSService.download(fileName, destFile);
			fis = new FileInputStream(file);
			bufferedInputStream = new BufferedInputStream(fis);
			int read = bufferedInputStream.read(b);
			OutputStream os = httpServletResponse.getOutputStream();
			while (read != -1) {
				os.write(b, 0, read);
				read = bufferedInputStream.read(b);
			}
		} catch (IOException e) {
			logger.error("download error,fileName:{}", fileName, e);
		} finally {
			if (bufferedInputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private String getNewFileName(String originalFilename) {
		String ext = null;
		if (originalFilename.contains(".")) {
			ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		} else {
			ext = "";
		}
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String nfileName = uuid + ext;
		return nfileName;
	}

}
