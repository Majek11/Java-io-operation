package Chapter15.streams;

import java.io.*;

public class PrintStreamImpl {
    public static void main(String[] args) throws FileNotFoundException {
        String fileLocation = "/home/majek/IdeaProjects/JavaFileClass/src/Chapter15/streams/data.txt";
        try(OutputStream outputStream = new FileOutputStream(fileLocation);
                PrintStream printStream = new PrintStream(outputStream)){
            printStream.printf("Go placidly amid the noise..... %s", "Amidat");
        } catch(IOException e) {
            System.err.println(STR."ERROR\{e.getMessage()}");
    }
    }
}
