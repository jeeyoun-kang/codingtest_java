import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {

    static int n=6;

    static boolean[] visitied = new boolean[n]; //false로 초기화


    static int[][] graph ={{1,4},{0,2,3},{1,5},{1,4,5},{0,3},{2,3}};

    public static void main(String[] args) {

    BFS(0);


    }

    private static void BFS(int num) {
        //상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        visitied[num]=true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : graph[now]){
                queue.offer(next);
                visitied[next]=true;
            }
        }
    }
}
