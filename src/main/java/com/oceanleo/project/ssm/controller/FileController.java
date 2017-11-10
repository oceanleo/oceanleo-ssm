package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.domain.File;
import com.oceanleo.project.ssm.service.FileService;
import com.oceanleo.project.ssm.support.core.exception.BizException;
import com.oceanleo.project.ssm.support.utils.FileUtils;
import com.oceanleo.project.ssm.support.utils.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件处理控制层
 *
 * @author haiyang.li on 2017/10/19
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @RequestMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(MultipartFile uploadFile) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        try {
            String fileId = fileService.createFile(FileUtils.toFile(uploadFile));
            resultMap.put("success", true);
            resultMap.put("fileId", fileId);
            resultMap.put("message", "上传成功");
        } catch (BizException e) {
            resultMap.put("success", false);
            resultMap.put("message", e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "服务器异常,请稍后再试!");
            e.printStackTrace();
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response, String fileId) {
        if (StringUtils.hasText(fileId)) {
            File file = fileService.findById(fileId);
            if (file != null) {
                try {
                    OutputStream outputStream = response.getOutputStream();
                    outputStream.write(file.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
