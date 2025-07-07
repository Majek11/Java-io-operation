package Chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation {
    public static String readFrom(String fileLocation) {
        Path path = Paths.get(fileLocation);
        StringBuilder data  = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            while(reader.ready()) data.append(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(data);
        return data.toString();
    }

    public static void writeTo(String fileLocation, String data) throws IOException {
        Path path = Paths.get(fileLocation);
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(data);
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void writeToFileTwo(String fileLocation, String data) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(fileLocation)) {
            outputStream.write(data.getBytes());
        }
    }
}