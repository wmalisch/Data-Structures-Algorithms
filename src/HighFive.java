import java.util.*;

public class HighFive {

    // Max heap
    public static int[][] highFive(int[][] items){
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for(int[] arr : items){
            if(!map.containsKey(arr[0])){
                map.put(arr[0], new PriorityQueue<>((a,b) -> b - a));
            }
            map.get(arr[0]).add(arr[1]);
        }

        int[][] res = new int[map.size()][2];

        int i = 0;
        for(int id : map.keySet()){
            res[i][0] = id;
            for(int j = 0; j < 5; j++){
                res[i][1] += map.get(id).remove();
            }
            res[i][1] = res[i][1] / 5;
            i++;
        }
        return res;
    }

    

    public static void printArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.printf("%d, ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,91}, {1,92}, {2,93}, {2,97}, {1,60}, {2,77}, {1,65}, {1,87},{1,100},{2,100},{2,76}};
        printArr(highFive(arr));

    }
}
