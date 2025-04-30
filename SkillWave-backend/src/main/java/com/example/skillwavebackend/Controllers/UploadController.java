package com.example.skillwavebackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular
public class UploadController {

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";
    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Empty file");
            }

            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String extension = "";
            String orgname="";

            int dotIndex = originalFilename.lastIndexOf(".");
            if (dotIndex > 0) {
                extension = originalFilename.substring(dotIndex + 1);// without dot
                orgname=originalFilename.substring(0,dotIndex);
            }

            // Read the uploaded image
            BufferedImage originalImage = ImageIO.read(file.getInputStream());

            if (originalImage == null) {
                return ResponseEntity.badRequest().body("Invalid image file");
            }

            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();

            int maxWidth = 800;
            int maxHeight = 800;

            // Calculate new dimensions while keeping aspect ratio
            double widthRatio = (double) maxWidth / originalWidth;
            double heightRatio = (double) maxHeight / originalHeight;
            double ratio = Math.min(widthRatio, heightRatio);

            int newWidth = (int) (originalWidth * ratio);
            int newHeight = (int) (originalHeight * ratio);

            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();

            // Make it smooth
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g.dispose();

            // Prepare to save
            String uniqueFileName = orgname+UUID.randomUUID().toString() + "." + extension;
            Path uploadPath = Paths.get(UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(uniqueFileName);

            // Write the resized image to file
            ImageIO.write(resizedImage, extension, filePath.toFile());

            String imageUrl = "http://localhost:8095/uploads/" + uniqueFileName;
            return ResponseEntity.ok(imageUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Upload failed");
        }
    }

//    @PostMapping
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            if (file.isEmpty()) {
//                return ResponseEntity.badRequest().body("Empty file");
//            }
//
//            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
//            String extension = "";
//
//            // Extract the file extension
//            int dotIndex = originalFilename.lastIndexOf(".");
//            if (dotIndex > 0) {
//                extension = originalFilename.substring(dotIndex);
//            }
//
//            // Generate a unique filename
//            String uniqueFileName = UUID.randomUUID().toString() + extension;
//
//            Path uploadPath = Paths.get(UPLOAD_DIR);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            Path filePath = uploadPath.resolve(uniqueFileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            String imageUrl = "http://localhost:8080/uploads/" + uniqueFileName;
//            return ResponseEntity.ok(imageUrl);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Upload failed");
//        }
//    }
}