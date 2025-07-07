package test;
import Chapter15.FileOperation;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileOperationTest {

    @Test
    void testThatWeCanReadFromFile() {
        String fileLocation = "/home/majek/IdeaProjects/JavaFileClass/src/test/Files/data.txt";
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

}