package com.example.hos.util.photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class BasetoPhoto {

    public static String convertToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        fileInputStream.read(imageData);
        fileInputStream.close();
        return Base64.getEncoder().encodeToString(imageData);
    }

}
