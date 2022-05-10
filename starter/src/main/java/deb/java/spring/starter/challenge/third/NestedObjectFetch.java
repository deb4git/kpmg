package deb.java.spring.starter.challenge.third;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedObjectFetch {

    private List<String> tempListForKeys = new ArrayList<>();
    private Map<String, String> finalMapWithSubElement = new HashMap<>();

    public String getMapValue(String sampleJsonString, String mapKey) throws JsonProcessingException {
        Map<String, Object> mapFromJson = new ObjectMapper().readValue(sampleJsonString, HashMap.class);
        getValueFromRecursiveMethod(mapFromJson);
        return finalMapWithSubElement.get(mapKey);
    }

    private void getValueFromRecursiveMethod(Map<String, Object> mapFromJson) {
        mapFromJson.entrySet().stream().forEach(mapElement -> {
            if (mapElement.getValue() instanceof String) {
                finalMapWithSubElement.put(mapElement.getKey(), (String) mapElement.getValue());
                tempListForKeys.stream().forEach(tempkey -> finalMapWithSubElement.put(tempkey, (String) mapElement.getValue()));
            } else {
                tempListForKeys.add(mapElement.getKey());
                getValueFromRecursiveMethod((Map<String, Object>) mapElement.getValue());
            }
        });
    }

}
