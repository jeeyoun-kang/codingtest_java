package org.example;

public class test {
    public static void main(String[] args) {

       solution(22,6,8);
    }

    private static int solution(int n, int w, int num) {
        int answer;
        int x = num-w <= 0 ? 1 : num%w==0? num/w : num/w+1; // 맨 아래층이 1층
        //홀수 층 : 왼>오 , 짝수 층 : 오>왼
        int y = 0;
        if(x%2!=0){
           y = num-w <= 0 ? num : num%w==0?num/w : num/w+1;
        }else{
            y = w - (num/w + 1);
        }
        boolean hasLastFloor = (n / w + 1) * y <= n; // (n/w+1,y) 존재여부 판단
        if(hasLastFloor){
            answer = n/w+1-x+1;
        }else{
            answer = n/w+1-x;
        }
        System.out.println(answer);
        return answer;
    }
}
