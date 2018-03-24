package at.refugeescode.morse.persistance;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DatabaseHolder {

    private HashMap<String, String> hashMap = new HashMap<>();

    public void addEntry(String key, String value) {
        hashMap.put(key, value);
    }

    public String getValue(String key) {
        return hashMap.get(key);
    }

}
