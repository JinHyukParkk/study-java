package lambda.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomBufferedReader {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/data.txt"))) {
            return p.process(br);
        }
    }
}
