package com.example.Pizzeria.repositories;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StaticFileRepository {
    String saveImage(MultipartFile file) throws IOException;

    String readStaticFiles(String fileName);

    void saveFile(String content);
}
