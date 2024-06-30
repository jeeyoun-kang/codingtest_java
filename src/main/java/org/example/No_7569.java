package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No_7569 토마토
 * box에서
 * 1: 익은 거, 0: 익지 않은 거, -1: 들어있지 않은 거
 */
public class No_7569 {

    static int[][][] box;
    static int[] nr = {1,0,0,-1,0,0};
    static int[] nc = {0,1,0,0,-1,0};
    static int[] nh = {0,0,1,0,0,-1};
    static boolean ripe;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]); //가로, 열
        int N = Integer.parseInt(split[1]); //세로, 행
        int H = Integer.parseInt(split[2]); //높이
        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                split = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(split[k]);
                }
            }
        }


        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[H][N][M];

        do {
            ripe = false;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if(box[i][j][k] == 1 && !visited[i][j][k]){
                            bfs(i,j,k,visited,queue);
                        }
                    }
                }
            }
            count++;
        } while(ripe);


        if (count == 1) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }


    }

    static void bfs(int i, int j, int k, boolean[][][] visited, Queue<Node> queue) {
        visited[i][j][k] = true;
        queue.offer(new Node(i,j,k));

        while (!queue.isEmpty()) {
            //queue의 front에서 poll
            Node node = queue.poll();

            for (int a = 0; a < nr.length; a++) {
                int r = node.r + nr[a];
                int c = node.c + nc[a];
                int h = node.h + nh[a];

                if (h < 0 || h >= box.length || r < 0 || r >= box[0].length || c < 0 || c >= box[0][0].length) { continue; }
                if (box[h][r][c] == 0 && !visited[h][r][c]) {


                    visited[h][r][c] = true;
                    queue.offer(new Node(r, c, h));
                    ripe = true;
                }
            }
        }
    }

    static class Node{
        int h;
        int r;
        int c;

        public Node(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}
