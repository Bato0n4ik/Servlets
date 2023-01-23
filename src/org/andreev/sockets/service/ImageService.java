package org.andreev.sockets.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.andreev.sockets.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();
    private final String basePath = PropertiesUtil.getProperty("image.base.uri");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContext){
        Path imageFullPath = Path.of(basePath, imagePath);
        try(imageContext){
            if(!Files.exists(imageFullPath.getParent())){
                Files.createDirectories(imageFullPath.getParent());
            }
            Files.write(imageFullPath, imageContext.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    public Optional<InputStream> get(String imagePath){
        var imageFullPath = Path.of(basePath, imagePath);
        try{
            return Files.exists(imageFullPath) ? Optional.of(Files.newInputStream(imageFullPath)) : Optional.empty();
        }
        catch(IOException exc){
            throw new RuntimeException(exc);
        }
    }

    public static ImageService getInstance(){
        return INSTANCE;
    }
}
