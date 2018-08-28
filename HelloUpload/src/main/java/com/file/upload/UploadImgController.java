package com.file.upload;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

// https://blog.csdn.net/change_on/article/details/59529034
@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class UploadImgController {
    @GetMapping("/gouploadimg")
    public String goUploadImg() {
        return "uploadimg";
    }

    @PostMapping("/testuploadimg")
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "uploadimg success";
    }

    public static void uploadFile(byte[] bytes, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        FileOutputStream fs = new FileOutputStream(filePath + fileName);
        fs.write(bytes);
        fs.flush();
        fs.close();
    }
}
