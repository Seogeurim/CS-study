public class KMPTest {

    static String T, P;
    static int N;
    static int[] fail;
    static StringBuilder match_index;

    public static void main(String[] args) {

        T = "ABABABABBABABABABC";
        P = "ABABABC";

        N = P.length();
        fail = new int[N];
        makeFail(); // fail 함수 만들기

        match_index = new StringBuilder();
        System.out.println(kmp()); // kmp 함수 : 문자열 T 안에 패턴 P가 몇 번 나타나는지 찾기
        System.out.print(match_index.toString()); // 패턴이 일치한 시작 인덱스 찾기
    }

    static void makeFail() {
        for (int i = 1, j = 0; i < N; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = fail[j-1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                fail[i] = ++j;
            }
        }
    }

    static int kmp() {
        int count = 0;
        for (int i = 0, j = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j))
                j = fail[j-1];
            if (T.charAt(i) == P.charAt(j)) {
                if (j == N-1) { // 끝까지 왔음
                    j = fail[j];
                    count ++;
                    match_index.append(i-N+2).append("\n");
                } else {
                    j ++;
                }
            }
        }
        return count;
    }
}
