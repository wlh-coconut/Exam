package alitest;

import java.util.*;

public class Test2 {
    // 找路径
    public static void findPath(int[][] path, int curPath, int start, int distict) {
        for(int i = 0; i < path.length; ++i){
            if(i == start)
                continue;
            if(path[start][i] == 1)
                findPath(path,curPath+1, i,distict);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int path = 0, minPath = 0;
            // 输入部分
            int n = sc.nextInt();// 城市个数
            int[][] lujing = new int[n + 1][n + 1];// 连通图
            HashMap<Integer, List<Integer>> map = new HashMap<>(); // 保存城市等级
            for (int i = 0; i < n; ++i) {
                int pro = sc.nextInt();
                if (map.get(pro) == null) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i + 1);
                    map.put(pro, list);
                } else {
                    map.get(pro).add(i + 1);
                }
            }
            for (int i = 0; i < n - 1; ++i) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                lujing[a][b] = 1;
                lujing[b][a] = 1;
            }
            for (int curPro : map.keySet()) {
                if (map.get(curPro).size()>1){
                    List<Integer> list = map.get(curPro);

                }
            }
        }
    }
}
