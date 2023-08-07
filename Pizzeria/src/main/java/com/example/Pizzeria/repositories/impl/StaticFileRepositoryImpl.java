package com.example.Pizzeria.repositories.impl;

import com.example.Pizzeria.repositories.StaticFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;


@Repository
@AllArgsConstructor
public class StaticFileRepositoryImpl implements StaticFileRepository {
    private final ResourceLoader resourceLoader;

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + ".png";
        File createFile = new File(Paths.get(".").normalize().toAbsolutePath() + "/Pizzeria/src/main/resources/static/imageData/" + fileName);

        createFile.createNewFile();
        FileOutputStream writeFile = new FileOutputStream(createFile);
        writeFile.write(file.getBytes());
        writeFile.flush();
        writeFile.close();


        return fileName;
    }

    @Override
    public String readStaticFiles(String filename) {
        File createFile = new File(Paths.get(".").normalize().toAbsolutePath() + "/Pizzeria/src/main/resources/"+filename);
        try {
            return Files.readString(createFile.toPath(),StandardCharsets.UTF_8);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFile(String content) {
        File createFile = new File(Paths.get(".").normalize().toAbsolutePath() + "/Pizzeria/src/main/resources/about_us.md");
        try {
            FileOutputStream writeFile = new FileOutputStream(createFile);
            writeFile.write(content.getBytes(StandardCharsets.UTF_8));
            writeFile.flush();
            writeFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
