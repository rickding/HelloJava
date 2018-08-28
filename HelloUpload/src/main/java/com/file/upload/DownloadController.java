package com.file.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

// https://blog.csdn.net/coding13/article/details/54577076
@Controller
@RequestMapping("/")
public class DownloadController {
    @GetMapping("/download")
    public String download(@RequestParam("file") String fileName, HttpServletResponse response
    ) {
        if (fileName == null || fileName.isEmpty()) {
            return null;
        }

        final File file = new File(RestUploadController.UPLOADED_FOLDER, fileName);
        if (!file.exists()) {
            return null;
        }

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", String.format(
                "attachment;fileName=%s", fileName
        ));

        // Read file
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            final OutputStream os = response.getOutputStream();

            final byte[] buffer = new byte[1024 * 10];
            int i = -1;
            while ((i = bis.read(buffer)) != -1) {
                os.write(buffer, 0, i);
            }
            System.out.println("Success download");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
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
        return null;
    }
}
