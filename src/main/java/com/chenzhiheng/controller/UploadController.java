package com.chenzhiheng.controller;

import com.chenzhiheng.utils.FileUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.chenzhiheng.vo.UploadResultVO;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UploadController {

    public UploadResultVO uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return UploadResultVO.success("");
    }
}
