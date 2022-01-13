package test;

import java.io.*;
import java.util.*;

public class TDDTest {
    public static void main(String[] args) {
        TDDTest test = new TDDTest();
        String words = test.readFile("src/main/java/test/word.txt");
        Map<String, Integer> map = test.wordFreq(words);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public Map<String, Integer> wordFreq(String words) {
        Map<String, Integer> map = new HashMap<>();
        String[] texts = words.split(" ");
        for (String text : texts) {
            if (!map.containsKey(text)) {
                map.put(text, 1);
            } else {
                map.put(text, map.get(text) + 1);
            }
        }
        //排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        return map;
    }

    /**
     * 读取文件
     *
     * @param fileName 文件名
     * @return 返回字符串
     */
    public String readFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) return "";
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader br = new BufferedReader(is);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            is.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("" + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.printf("" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("" + e.getMessage());
        }
        return sb.toString();
    }
}
