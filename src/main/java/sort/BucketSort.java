package sort;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 桶排序
 * 时间复杂度是O（n+k），空间复杂度是O（n+k），最好时间复杂度O（n），最坏时间复杂度O（n*n）
 * 稳定排序
 */
public class BucketSort extends Sort {
    @Override
    void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        //1.找数组中最大值和最小值
        int max = args[0], min = args[0];
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
            if (arg > max) {
                max = arg;
            }
        }
        //2.计算桶的数量，可根据实际情况自定义(eg:args在0-50之间，可分为0-9,10-19...40-49,50)
        int step = 10;
        int bucketNum = max / step - min / step + 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }
        //3.将数放入对应桶中
        for (int arg : args) {
            int index = (arg - min) / step;
            bucketList.get(index).add(arg);
        }
        //4.对每个非空桶排序,这可使用其它排序算法或者递归继续使用桶排序进行排序
        int index = 0;
        for (ArrayList<Integer> integers : bucketList) {
            //1.排序
            Collections.sort(integers);
            //2.放回数组
            for (Integer integer : integers) {
                args[index] = integer;
                index++;
            }
        }


    }
}
