package Chapter15;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation {
    public static String readFrom(String fileLocation) {
        Path path = Paths.get(fileLocation);
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) data.append(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(data);
        return data.toString();
    }

    public static void writeTo(String fileLocation, String data) throws IOException {
        Path path = Paths.get(fileLocation);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(data);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void writeToFileTwo(String fileLocation, String data) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(fileLocation)) {
            outputStream.write(data.getBytes());
        }
    }

    public static void readFromWeb(String url, String fileLocation) throws MalformedURLException {
        URL uri = URI.create(url).toURL();
        try(InputStream inputStream = uri.openStream();
            FileOutputStream outputStream = new FileOutputStream(fileLocation)) {
            byte[] data = inputStream.readAllBytes();
            outputStream.write(data);
        } catch (IOException ex) {
            System.out.println("ERROR:" + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}