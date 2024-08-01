package programmers;

public class pg_92335 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        // n을 k진수 문자열로 변환
        String converted = Integer.toString(n, k);
        int primeCount = 0;

        // 0을 기준으로 나누어 각 부분 문자열이 소수인지 판별
        String[] parts = converted.split("0");
        for (String part : parts) {
            if (!part.isEmpty() && isPrime(part)) {
                primeCount++;
            }
        }

        // 결과 출력
        System.out.println("Number of primes: " + primeCount);
    }

    // 소수 판별 함수
    private static boolean isPrime(String numStr) {
        long num = Long.parseLong(numStr);
        if (num <= 1) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
