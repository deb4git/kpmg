package deb.java.spring.starter.challenge.third;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class NestedObjectFetchTest {

    @Test
    void NestedObjectFetch_getMapValue_Valid_SampleString_First() throws JsonProcessingException {
        String sampleJson = "{\"a\":{\"b\":{\"c\":\"d\"}}}";
        assertEquals("d", new NestedObjectFetch().getMapValue(sampleJson, "a"));
        assertEquals("d", new NestedObjectFetch().getMapValue(sampleJson, "b"));
        assertEquals("d", new NestedObjectFetch().getMapValue(sampleJson, "c"));
    }

    @Test
    void NestedObjectFetch_getMapValue_Valid_SampleString_Second() throws JsonProcessingException {
        String sampleJson = "{\"x\":{\"y\":{\"z\":\"a\"}}}";
        assertEquals("a", new NestedObjectFetch().getMapValue(sampleJson, "x"));
        assertEquals("a", new NestedObjectFetch().getMapValue(sampleJson, "y"));
        assertEquals("a", new NestedObjectFetch().getMapValue(sampleJson, "z"));
    }

    @Test
    void NestedObjectFetch_getMapValue_NullValue() throws JsonProcessingException {
        String sampleJson = "{\"x\":{\"y\":{\"z\":\"a\"}}}";
        assertNull(new NestedObjectFetch().getMapValue(sampleJson, "noValueKey"));
    }

}