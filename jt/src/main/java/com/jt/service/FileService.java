package com.jt.service;

import com.jt.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 14:23
 */
public interface FileService {
    ImageVO upload(MultipartFile file) throws IOException;

    void deleteFile(String virtualPath);
}
