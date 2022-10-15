package optional.example1;

import java.util.HashMap;
import java.util.Optional;

public class Properties {

    private HashMap<String, String> list = new HashMap<>();

    public Properties() {
    }

    public HashMap<String, String> getList() {
        return list;
    }

    public void setProperties(String key, String value) {
        list.put(key, value);
    }

//    public int getProperties(String key) {
//        String value = list.get(key);
//
//        if (value != null) {
//            try {
//                int i = Integer.parseInt(value);
//                if (i > 0) {
//                    return i;
//                }
//            } catch (NumberFormatException e) {
//            }
//        }
//
//        return 0;
//    }

    public int getProperties(String key) {
        return Optional.ofNullable(list.get(key))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }
}
