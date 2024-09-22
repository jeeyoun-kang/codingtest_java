package programmers;

import java.util.*;

public class test2 {
    private static int n, m;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

    public static void main(String[] args) {

        n = 4;
        m = 2;
        arr = new int[m];
        visited = new boolean[n + 1];
        combination(0,0);

    }

    private static void combination(int num,int start) {
        if(num==m){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=start;i<=n;i++){
            arr[num]=i;
            combination(num+1,i+1);
        }
    }

    private static void permutation(int num) {
        if(num==m){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[num]=i;
                System.out.println(arr[num]);
                permutation(num+1);
                visited[i]=false;
            }

        }
    }


    private boolean isPrime(int num){
        if(num<=1) {
            return false;
        }
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }

//    private static void bfs(int num){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(num);
//        visited[0]=true;
//
//        while(!queue.isEmtpy()){
//
//        }
//    }
}
