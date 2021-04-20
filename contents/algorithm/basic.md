# 알고리즘 기본

> 작성자 : [권혁진](https://github.com/KimKwon), [박재용](https://github.com/ggjae), [서그림](https://github.com/Seogeurim)

<details>
<summary>Table of Contents</summary>

- [시간복잡도와 공간복잡도](#시간복잡도와-공간복잡도)
- [DFS와 BFS](#dfs와-bfs)
- [순열, 조합, 부분집합](#순열-조합-부분집합)
- [백트래킹 (Backtracking)](#백트래킹-backtracking)
- [분할 정복법 (Divide and Conquer)](#분할-정복법-divide-and-conquer))
- [탐욕 알고리즘 (Greedy)](#탐욕-알고리즘-greedy)
- [동적 계획법 (Dynamic Programming)](#동적-계획법-dynamic-programming)

</details>

---

알고리즘은 **완전탐색**(**Brute-Force**, 모든 경우의 수를 탐색해보는 것)에서 시작한다. 이는 모든 경우의 수를 다 따져보기 때문에 강력하지만, 최대의 시간복잡도를 가지게 된다. 모든 경우의 수를 생각해보고 또한 시간복잡도를 줄일 수 있는 부분이 있다면 그러한 알고리즘을 생각해보고 그 알고리즘을 정확하게 코드로 구현할 수 있어야 한다. 좋은 코드를 짜기 위해서는 다음 과정의 연습이 필요하다.

- 문제를 파악하고 알고리즘을 생각하기
- 알고리즘의 공간복잡도와 시간복잡도를 계산하여 문제의 제약 조건 내에 수행될 수 있는 알고리즘인지 판단하기
- 알고리즘을 빠르고 정확하게 구현하기 (연습만이 정답)

## 시간복잡도와 공간복잡도

복잡도는 알고리즘의 성능을 나타내는 척도이다.  
복잡도는 **시간 복잡도(Time Complexity)** 와 **공간 복잡도(Space Complexity)** 로 나눌 수 있다.  
시간 복잡도는 특정한 크기의 입력에 대하여 알고리즘이 얼마나 오래 걸리는지를 의미하고 공간 복잡도는 특정한 크기의 입력에 대하여 알고리즘이 얼마나 많은 메모리를 차지하는지를 의미한다.  
동일한 기능을 수행하는 알고리즘이 있다면 일반적으로 복잡도가 낮을수록 좋은 알고리즘이다.    
복잡도의 측정으로 우리는 '알고리즘을 위해 필요한 연산의 횟수'로 시간 복잡도를 계산할 수 있고 '알고리즘을 위해 필요한 메모리의 양'으로 공간 복잡도를 계산할 수 있다.

### 시간 복잡도

보통 시간 복잡도를 표현할 때는 [Big-O 표기법(Big-O notation)](https://ko.wikipedia.org/wiki/%EC%A0%90%EA%B7%BC_%ED%91%9C%EA%B8%B0%EB%B2%95)을 사용한다. 가장 빠르게 증가하는 항만 고려하는 표기법으로 limit을 나타낸다.  
예를 들어 N개의 데이터가 있을 때 모든 데이터의 값을 더한 결과를 출력하는 프로그램이라면 N개의 데이터를 받아 차례로 N회 더해준다. 이 때 연산 횟수는 N에 비례하고 새로운 변수를 만들거나 출력하는 연산은 상대적으로 N이 커진다면 무시할 수 있게 된다. 가장 영향력이 큰 부분이 N으로 시간 복잡도를 O(N)으로 표시한다.  
일반적으로 코딩테스트에서는 최악의 경우에 대한 연산 횟수가 가장 중요하므로 자신이 작성한 소스코드를 정확히 이해하고 분석하여 최악의 경우의 시간 복잡도를 계산해야 한다.  
O(N<sup>3</sup>)을 넘어가면 문제 풀이에서 사용하기 어려운 알고리즘으로 N이 1000개를 넘어가면 5초 이상의 시간이 소요될 것이라고 예상할 수 있다.  

- N의 범위가 500인 경우) 시간 복잡도가 O(N<sup>3</sup>)인 알고리즘을 설계하면 문제 해결 가능
- N의 범위가 2000인 경우) 시간 복잡도가 O(N<sup>2</sup>)인 알고리즘을 설계하면 문제 해결 가능
- N의 범위가 100,000인 경우) 시간 복잡도가 O(Nlog N)인 알고리즘을 설계하면 문제 해결 가능
- N의 범위가 10,000,000인 경우) 시간 복잡도가 O(N)인 알고리즘을 설계하면 문제 해결 가능

> 보통 1억(10<sup>8</sup>)번의 연산당 1초의 시간이 걸린다고 간주한다.

### 공간 복잡도

공간 복잡도를 표기할 때에도 [Big-O 표기법(Big-O notation)](https://ko.wikipedia.org/wiki/%EC%A0%90%EA%B7%BC_%ED%91%9C%EA%B8%B0%EB%B2%95)을 사용한다.  
코딩 테스트에서는 보통 메모리 사용량을 128~512MB로 제한하고 있다. 즉 일반적인 경우 데이터의 개수가 1,000만 단위를 넘어가지 않도록 알고리즘 설계를 해야하고 100만 개 이상의 데이터가 들어갈 수 있는 크기의 배열을 선언하는 경우는 거의 드물다.  
리스트의 크기가 1,000만 단위 이상이라면 자신이 알고리즘을 잘못 설계한 것이 아닌지 확인하는 과정이 필요하다.  

일반적으로 알고리즘 문제 풀이에서의 복잡도는 시간 복잡도를 의미한다.

---

## DFS와 BFS

> 스터디 자료 - 작성자 권혁진 | [깊이우선탐색 DFS 에 대하여](https://nukw0n-dev.tistory.com/5)

### DFS(Depth First Search, 깊이 우선 탐색)

- 한 경로로 최대한 깊숙하게 들어가서 탐색한 후 다시 돌아가 다른 경로로 탐색하는 방식
- 재귀함수, Stack을 이용해 구현
- 유의할 점 : Stack Overflow (기저조건 잘 설정)
- 활용 : 백트래킹, 단절선/단절점 찾기, 위상정렬, 사이클 찾기 등

#### DFS 구현

```java
void dfs(int current) {
    if (current == target) { // 목적지인가?
        System.out.println("목적지입니다.");
        return;
    }
    visited[current] = true; // 체크인
    for (int next : graph[current]) { // 갈 수 있는 곳을 순회
        if (!visited[next]) { // 갈 수 있는가?
            dfs(next); // 간다
        }
    }
    visited[current] = false; // 체크아웃
}
```

### BFS(Breadth First Search, 너비 우선 탐색)

- 시작 노드에서 시작하여 인접한 노드를 먼저 탐색하는 방식, 여러 경로 동시에 탐색 가능
- Queue를 이용해 구현
- 유의할 점 : 메모리 초과 (방문 체크 꼭 해줘야 함)
- 활용 : 최단경로 찾기, 위상정렬 등

#### BFS 구현

```java
void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    visited[start] = true;
    
    while (!q.isEmpty()) {
        int current = q.poll(); // 큐에서 꺼낸다
        if (current == target) { // 목적지인가?
            System.out.println("목적지입니다.");
            return;
        }
        for (int next : graph[current]) { // 갈 수 있는 곳을 순회
            if (!visited[next]) { // 갈 수 있는가?
                visited[next] = true; // 체크인
                q.offer(next); // 큐에 넣는다
            }
        }
    }
}
```

---

## 순열, 조합, 부분집합

### 순열

- 서로 다른 것들 중 몇 개를 뽑아서 한 줄로 나열하는 것
- 서로 다른 n개 중 r개를 택하는 순열 `nPr = n * (n-1) * (n-2) * ... * (n-r+1)`
- `nPn = n!` 이며 `10!` 이상의 계산은 위험하다.

#### 순열 구현 : 재귀 함수, 비트마스크, next permutation

```java
public class PermutationTest {

    static int N;
    static int[] input, result;
    static boolean[] isSelected;

    public static void main(String[] args) {

        N = 5; // N 초기화
        input = new int[N]; // 입력 받은 숫자 배열
        result = new int[N]; // 순열 결과를 저장할 배열
        isSelected = new boolean[N]; // 선택 정보를 관리할 배열

        for (int i = 0; i < N; i++) {
            input[i] = i; // input 배열 초기화
        }

        System.out.println("Permutation Recursive");
        recursive(0);

        System.out.println("Permutation Bitmask");
        bitmask(0, 0);

        System.out.println("Permutation Next Permutation");
        Arrays.sort(input); // 오름차순 정렬하여 가장 작은 순열의 형태로 만듦
        do {
            System.out.println(Arrays.toString(input));
        } while (np());
    }

    // 재귀 함수
    private static void recursive(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;

            result[cnt] = input[i];
            isSelected[i] = true;
            recursive(cnt+1);
            isSelected[i] = false;
        }
    }

    // 비트마스크
    private static void bitmask(int cnt, int flag) {
        if (cnt == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1<<i) != 0) continue;

            result[cnt] = input[i];
            bitmask(cnt+1, flag | 1<<i);
        }
    }

    // next permutation
    private static boolean np() {
        int i = N-1;
        while (i > 0 && input[i-1] >= input[i]) --i;

        // 더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열 (마지막 순열)
        if (i == 0) return false;

        int j = N-1;
        while (input[i-1] >= input[j]) --j; // i-1보다 큰 값은 무조건 있음 (적어도 i)

        swap(i-1, j);

        int k = N-1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
```

### 조합

- 서로 다른 n개의 원소 중 r개를 **순서 없이** 골라낸 것
- 서로 다른 n개 중 r개를 택하는 조합 `nCr = n! / (n-r)!r!`

#### 조합 구현 : 재귀 함수, next permutation

```java
public class CombinationTest {

    static int N, R;
    static int[] input, result, P;

    public static void main(String[] args) {

        N = 5; // N 초기화
        R = 3;
        input = new int[N]; // 입력 받은 숫자 배열
        result = new int[R]; // 조합 결과를 저장할 배열

        for (int i = 0; i < N; i++) {
            input[i] = i; // input 배열 초기화
        }

        System.out.println("Combination Recursive");
        recursive(0, 0);

        System.out.println("Combination Next Permutation");
        P = new int[N]; // N 크기의 flag 배열
        // 원소 크기와 같은 크기의 int 배열 P를 생성하여 뒤에서 r개를 1로 초기화
        int cnt = 0;
        while (++cnt <= R) P[N-cnt] = 1;

        do {
            for (int i = 0; i < N; i++) {
                // P 배열에서 0이 아닌 값을 갖고 있는 위치에 해당하는 원소가 조합에 선택된 것
                if (P[i] == 1) System.out.print(input[i] + " ");
            }
            System.out.println();
        } while (np());
    }

    private static void recursive(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = start; i < N; i++) {
            result[cnt] = input[i];
            recursive(cnt+1, i+1);
        }
    }

    private static boolean np() {
        // STEP 1
        int i = N-1;
        while (i > 0 && P[i-1] >= P[i]) --i;

        if (i == 0) return false;

        // STEP 2
        int j = N-1;
        while (P[i-1] >= P[j]) --j;

        // STEP 3
        swap(i-1, j);

        // STEP 4
        int k = N-1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = P[i];
        P[i] = P[j];
        P[j] = temp;
    }
}
```

### 부분집합

- 집합에 포함된 원소들을 선택하는 것
- 집합의 원소가 n개일 때, 공집합을 포함한 부분집합(멱집합, power set)의 개수는 2<sup>N</sup>개이다.
  (각 원소를 포함시키거나 / 포함시키지 않거나)

#### 부분집합 구현 : 재귀 함수, 바이너리 카운팅

```java
public class SubsetTest {

    static int N;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {

        N = 3; // N 초기화
        input = new int[N]; // 입력 받은 숫자 배열
        isSelected = new boolean[N]; // 선택 정보를 관리할 배열

        for (int i = 0; i < N; i++) {
            input[i] = i; // input 배열 초기화
        }

        System.out.println("Subset Recursive");
        recursive(0);

        System.out.println("Subset Binary Counting");
        binaryCounting(1<<N); // 2^N
    }

    private static void recursive(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print( (isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        // 선택
        isSelected[cnt] = true;
        recursive(cnt+1);
        // 비선택
        isSelected[cnt] = false;
        recursive(cnt+1);
    }

    private static void binaryCounting(int caseCount) {

        for (int flag = 0; flag < caseCount; flag++) { // flag : 비트마스크되어 있는 수
            for (int j = 0; j < N; j++) {
                if ((flag & 1<<j) != 0) {
                    System.out.print(input[j] + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
```

---

## 백트래킹 (Backtracking)

---

## 분할 정복법 (Divide and Conquer)

---

## 탐욕 알고리즘 (Greedy)

---

## 동적 계획법 (Dynamic Programming)
