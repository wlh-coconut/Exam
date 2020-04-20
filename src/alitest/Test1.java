package alitest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int coins = 0, maxCoins = 0;
            // 输入部分
            int a = sc.nextInt();// 我的初始能力
            int n = sc.nextInt();// 怪物数量
            int[] guaiwu = new int[n];// 怪物能力
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                guaiwu[i] = sc.nextInt();
                if (map.get(guaiwu[i]) == null)
                    map.put(guaiwu[i], 1);
                else
                    map.put(guaiwu[i], map.get(guaiwu[i]) + 1);
            }
            Arrays.sort(guaiwu);
            int i = 0;
            while (i < n) {
                if (a >= guaiwu[i]) {
                    coins += map.get(guaiwu[i]);
                    i += map.get(guaiwu[i]);
                    maxCoins = maxCoins > coins ? maxCoins : coins;
                } else if (guaiwu[i] - a <= coins) {
                    coins = coins + map.get(guaiwu[i]) - (guaiwu[i] - a);
                    a = guaiwu[i];
                    i += map.get(guaiwu[i]);
                    maxCoins = maxCoins > coins ? maxCoins : coins;
                } else{
                    break;
                }
            }
            System.out.println(maxCoins);
        }
    }
}
