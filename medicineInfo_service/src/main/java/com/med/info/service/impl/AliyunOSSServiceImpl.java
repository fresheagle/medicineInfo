/**
 * 
 */
package com.med.info.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.med.info.dto.ImageResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.med.info.config.AliyunOssConfiguration;
import com.med.info.service.AliyunOSSService;

/**
 * @author jialin.jiang
 *
 */
@Component
public class AliyunOSSServiceImpl implements AliyunOSSService {

	@Autowired
	private AliyunOssConfiguration aliyunOssConfiguration;

	private static String fileHost = "picture";

	private static String resize_value = "x-oss-process=image/resize,w_100";
	
	private static Long imangeExpireTime = 24*60*60*1000l;
	
	private static Logger logger = LoggerFactory.getLogger(AliyunOSSServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.med.info.service.AliyunOSSService#upload(java.io.File)
	 */
	@Override
	public ImageResponseDTO upload(File file) {
		try {
			OSSClient ossClient = getOSSClient();
			if (!ossClient.doesBucketExist(aliyunOssConfiguration.getBucketName())) {
				ossClient.createBucket(aliyunOssConfiguration.getBucketName());
				CreateBucketRequest createBucketRequest = new CreateBucketRequest(aliyunOssConfiguration.getBucketName());
				createBucketRequest.setCannedACL(CannedAccessControlList.PublicReadWrite);
				ossClient.createBucket(createBucketRequest);
			}
			// 创建文件路径
			String fileUrl = getFileKey(file.getName());
			// 上传文件
			PutObjectResult objectResult = ossClient
					.putObject(new PutObjectRequest(aliyunOssConfiguration.getBucketName(), fileUrl, file));
			// 设置权限 这里是公开读
			ossClient.setBucketAcl(aliyunOssConfiguration.getBucketName(), CannedAccessControlList.PublicReadWrite);
			if(null != objectResult){
			    logger.info("==========>OSS文件上传成功,OSS地址："+fileUrl);
			    ossClient.shutdown();
				String picturepath = aliyunOssConfiguration.getBucketName() + "." + aliyunOssConfiguration.getEndpoint() + "/" + fileUrl;
				String thumbnail = picturepath+"?"+resize_value;
				return new ImageResponseDTO(file.getName(),picturepath,thumbnail);
			}
			ossClient.shutdown();
		} catch (Exception e) {
			logger.error("使用OSS上传文件失败，file={}",file.getName());
		}
		return null;
	}

	private OSSClient getOSSClient() {
		OSSClient ossClient = new OSSClient(aliyunOssConfiguration.getEndpoint(),
				aliyunOssConfiguration.getAccessKeyId(), aliyunOssConfiguration.getAccessKeySecret());
		return ossClient;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.AliyunOSSService#download(java.lang.String)
	 */
	@Override
	public String searchOSS(String fileName) {
		
		OSSClient ossClient = getOSSClient();
		String fileUrl = getFileKey(fileName);
		boolean doesObjectExist = ossClient.doesObjectExist(aliyunOssConfiguration.getBucketName(), fileUrl);
		if(doesObjectExist) {
			Date expires = new Date (new Date().getTime() + imangeExpireTime);
			URL url = ossClient.generatePresignedUrl(aliyunOssConfiguration.getBucketName(), fileUrl, expires);
			ossClient.shutdown();
			return url.toString();
		}
		ossClient.shutdown();
		return null;
	}

	
	private String getFileKey(String fileName) {
		return fileHost + "/" + fileName;
	}

	/* (non-Javadoc)
	 * @see com.med.info.service.AliyunOSSService#download(java.lang.String)
	 */
	@Override
	public void download(String fileName, File destFile) {
		
		OSSClient ossClient = getOSSClient();
		String fileUrl = getFileKey(fileName);
		if(ossClient.doesObjectExist(aliyunOssConfiguration.getBucketName(), fileUrl)) {
			ossClient.getObject(new GetObjectRequest(aliyunOssConfiguration.getBucketName(), fileUrl), destFile);
		}
		ossClient.shutdown();
	}
	
	
}
