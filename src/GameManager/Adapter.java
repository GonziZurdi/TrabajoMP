package GameManager;

import java.util.Map;

public interface Adapter {
    void saveData(Map<String, User> data);
    Map<String, User> loadData();
}
