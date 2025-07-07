package test;
import Chapter15.FileOperation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class FileOperationTest {
    private String folderPath = "/home/majek/IdeaProjects/JavaFileClass/src/test/Files/";

    @Test
    void testThatWeCanReadFromFile() {
        String fileLocation = folderPath.concat("data.txt");
        String data = FileOperation.readFrom(fileLocation);
        assertNotNull(data);
        assertTrue(!data.isEmpty());
    }

    @Test
    void testThatWeCanWriteToAFile() throws IOException {
        String fileLocation = "/home/majek/IdeaProjects/JavaFileClass/src/Chapter15/Output.java";
        String data = """
                package Chapter15;
                
                import java.util.Arrays;
                public class Output {
                    public static void main(String[] args) {
                        System.out.println(Arrays.toString(args));
                    }
                }
                """;
        FileOperation.writeToFileTwo(fileLocation,data);
        String fileData = FileOperation.readFrom(fileLocation);
        assertNotNull(fileData);
        assertFalse(fileData.isEmpty());
    }

    @Test
    void testThatWeCanReadFromTheWeb() throws MalformedURLException {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String fileLocation = folderPath.concat("data.json");
        FileOperation.readFromWeb(url, fileLocation);
        String data = FileOperation.readFrom(fileLocation);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

}