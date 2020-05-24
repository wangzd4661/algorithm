package lettcode.Q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 401. 二进制手表
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class Q401 {
    public static void main(String[] args) {
        List<String> list = new Q401().readBinaryWatch(2);
        System.out.printf("" + Arrays.toString(list.toArray()));
    }

    private boolean[] hourUsed;
    private boolean[] minuteUsed;
    private List<String> res;
    private int[] hours = {1, 2, 4, 8};
    private int[] minutes = {1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        if (num < 0) return res;
        hourUsed = new boolean[4];
        minuteUsed = new boolean[6];
        findTime(num, 0, 0,0,0);
        return res;
    }
    private void findTime(int num, int hour, int minute,int hIndex,int mIndex) {
        if (num == 0) {
            if(hour<12&&minute<60)res.add(String.format("%d:%02d", hour, minute));
            return;
        }
        for (int i = mIndex; i < minuteUsed.length; i++) {
            if (!minuteUsed[i]) {
                minuteUsed[i] = true;
                findTime(num - 1, hour, minute + minutes[i],hIndex,i+1);
                minuteUsed[i] = false;
            }
        }
        for (int i = hIndex; i < hourUsed.length; i++) {
            if (!hourUsed[i]) {
                hourUsed[i] = true;
                findTime(num - 1, hour + hours[i], minute,i+1,mIndex);
                hourUsed[i] = false;
            }
        }
    }
    //["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40",
    // "0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02",
    // "4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]

    //[[0:03, 0:05, 0:09, 0:17, 0:33, 2:01, 4:01, 8:01, 0:06, 0:10, 0:18, 0:34, 4:02, 8:02, 0:12, 0:20,
    // 0:36, 8:04, 0:24, 0:40, 0:48, 1:02, 1:04, 1:08, 1:16, 1:32, 3:00, 5:00, 9:00, 2:04, 2:08, 2:16, 2:32, 6:00, 10:00,
    // 4:08, 4:16, 4:32, 8:16, 8:32]

}
