package alitest;

import java.util.*;

/**
 * @author zyp
 */
public class TestZyp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        String[] level = scan.nextLine().split(" ");
        int[] levels = new int[level.length];
        for(int i = 0;i<level.length;i++){
            levels[i] = Integer.valueOf(level[i]);
        }
        List<List<Integer>> lists = new LinkedList<>();
        for(int i = 0;i<n;i++){
            lists.add(new LinkedList<>());
        }
        for(int i = 1;i<=n-1;i++){
            String[] tmp = scan.nextLine().split(" ");
            int x = Integer.valueOf(tmp[0]);
            int y = Integer.valueOf(tmp[1]);
            lists.get(x-1).add(y-1);
            lists.get(y-1).add(x-1);
        }
        help(levels,lists);
        System.out.println(finalMin);

    }
    public static void help(int[] levels, List<List<Integer>> edge){
        for(int i = 0;i<edge.size();i++){
            int start = i;
            int startLevel = levels[i];
            boolean[] flag = new boolean[levels.length];
            flag[start] = true;
            FindMin(start,startLevel,levels,edge,start,0,0,flag);
            finalMin = Math.min(finalMin,min);
            min = Integer.MAX_VALUE;
        }
    }
    static int min = Integer.MAX_VALUE;
    static int finalMin = Integer.MAX_VALUE;
    public static  void FindMin(int start,int startLevel,int[] levels,List<List<Integer>> edges,int curCity,int curMin,int index,boolean[] flag){
        if(index>edges.size()){
            return ;
        }
//        if(flag[curCity]==true){
//            return;
//        }
        List<Integer> city = edges.get(curCity);
        curMin++;
        for(int i = 0;i<city.size();i++){
            int nextCity = city.get(i);
            if(levels[nextCity]==startLevel){
                min = Math.min(min,curMin);
                continue;
            }
            if(flag[nextCity] == true){
                continue;
            }
            FindMin(start,startLevel,levels,edges,nextCity,curMin,index++,flag);
        }
    }
}
