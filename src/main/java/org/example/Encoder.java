package org.example;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Encoder {
    public static void main(String[] args) throws Exception {
        String fileForEncode = Files.readString(Path.of("fileForEncode"));
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(fileForEncode.getBytes());
        Files.writeString(Path.of("encodefile"),new String(encode));

    }
}

