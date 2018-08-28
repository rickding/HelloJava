package com.file.upload;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// https://www.cnblogs.com/ityouknow/p/8298344.html
@EnableAutoConfiguration
@Controller
@RequestMapping("/")
public class UploadController {
    private static final String UPLOADER_FOLDER = "upload/";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        File dir = new File(UPLOADER_FOLDER);
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", String.format(
                    "Successfully uploaded: %s", file.getOriginalFilename()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
