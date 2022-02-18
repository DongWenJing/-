package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 14:22
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 业务说明:
     * URL:/file/upload
     * 参数:file
     * 返回值:SysResult(ImageVO)
     */
    @PostMapping("/upload")
    public SysResult upload(MultipartFile file){
        ImageVO imageVO = null;
        try {
            imageVO = fileService.upload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (imageVO == null) {
            return SysResult.fail();
        }
        return SysResult.success(imageVO);
    }
    /**
     * 业务需求:删除图片信息
     * URL:/file/deleteFile
     * 参数:virtualPath
     * 返回值:SysResult对象
     */
    @DeleteMapping("/deleteFile")
    public SysResult deleteFile(String virtualPath){
        fileService.deleteFile(virtualPath);
        return SysResult.success();
    }
}
