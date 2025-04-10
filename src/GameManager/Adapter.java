package GameManager;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Adapter {
    void saveData(LinkedHashMap<String, User> data);
    Map<String, User> loadData();
}
