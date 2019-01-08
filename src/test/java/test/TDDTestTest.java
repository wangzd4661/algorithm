package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TDDTestTest {

    @Test
    public void wordFreq() {
        Map<String, Integer> reMap = new TDDTest().wordFreq("the day is sunny the the the sunny is is");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : reMap.entrySet()) {
            sb.append(entry.getKey() + "_" + entry.getValue());
            sb.append("-");
        }
        String text = "the_4-" + "is_3-" + "sunny_2-" + "day_1-";
        assert text.equals(sb.toString());
    }

    @Test
    public void readFile() {
        String word = new TDDTest().readFile("src\\main\\java\\test\\word.txt");
        assert "the day is sunny the the the sunny is is".equals(word);
    }
}