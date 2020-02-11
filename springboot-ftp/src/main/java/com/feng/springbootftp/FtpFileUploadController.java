package com.feng.springbootftp;

import com.feng.springbootftp.utils.FtpFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @create 2020-02-07-14:33
 */
@Controller
public class FtpFileUploadController {
    //ftp处理文件上传
    @RequestMapping(value = "/ftpuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String filePath = null;

        Boolean flag = FtpFileUtil.uploadFile(fileName, inputStream);
        if (flag == true) {
            System.out.println("ftp上传成功！");
            filePath = fileName;
        }
        return  filePath;
    }
}