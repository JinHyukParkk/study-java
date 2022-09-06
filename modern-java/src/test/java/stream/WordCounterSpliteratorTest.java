package stream;

import org.junit.jupiter.api.Test;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class WordCounterSpliteratorTest {

    private final static String SENTENCE = "ckdislek dickslxiapwpqziv vciqwoeitrnb zlcosi12038gkb84 19237ksoajds8";

    @Test
    void test() {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println("Found " + countWords(stream) + " words");
    }

    private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0 ,true),
                WordCounter::accumulate,
                WordCounter::combine);

        return wordCounter.getCounter();
    }
}
