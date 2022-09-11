package collection;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void test() {
        Map<String, String> favouriteMovies = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Olivia", "James Bond"));

        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));
    }

    @Test
    void computeIfAbsentTest() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }

        movies.add("Star Wars");

        System.out.println(friendsToMovies);

        //// 개선 버전
        friendsToMovies.computeIfAbsent("hyuk", name -> new ArrayList<>())
                .add("Thor");

        System.out.println(friendsToMovies);
    }

    @Test
    void removeTest() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();
        String key = "hyuk";
        String thor = "Thor";

        friendsToMovies.computeIfAbsent(key, name -> new ArrayList<>())
                .add(thor);

        friendsToMovies.computeIfAbsent(key, name -> new ArrayList<>())
                .add("Avengers");

        System.out.println(friendsToMovies);

        friendsToMovies.remove("hyuk", thor);

        System.out.println(friendsToMovies);
    }
}
