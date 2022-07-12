package lambda.reader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

class CustomBufferedReaderTest {


    @Test
    void read() throws IOException {
        CustomBufferedReader customBufferedReader = new CustomBufferedReader();
        String taskA = customBufferedReader.processFile((BufferedReader br) -> br.readLine());

        System.out.println(taskA);
    }
}