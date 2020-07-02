package lettcode.Q700;

import java.util.*;

/**
 * 752. 打开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class Q752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (target.equals("0000")) return 0;
        if (deadSet.contains("0000")) return -1;
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put("0000", 0);
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            char[] chars = cur.toCharArray();
            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char o = chars[i];
                chars[i] = Character.forDigit((chars[i] - '0' + 1) % 10, 10);
                nexts.add(new String(chars));
                chars[i] = o;

                chars[i] = Character.forDigit((chars[i] - '0' + 9) % 10, 10);
                nexts.add(new String(chars));
                chars[i] = o;
            }
            for (String next : nexts) {
                if (!visited.containsKey(next) && !deadSet.contains(next)) {//没有访问并且不是死亡数字
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if (next.equals(target)) return visited.get(next);
                }
            }

        }
        return -1;
    }
}
