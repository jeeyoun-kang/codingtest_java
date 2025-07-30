package org.example;

public class java_0728 {
    public static void main(String[] args) {
        solution("10203", "15");
    }

    private static int solution(String t, String p) {
        int answer =0;
        for(int i=0;i<=t.length();i++) {
            if(i>=p.length()) {
                t.substring(i-p.length(),i);
                if(Integer.parseInt(p) - Integer.parseInt(t.substring(i - p.length(), i))>=0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
