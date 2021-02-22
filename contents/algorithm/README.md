# Algorithm (알고리즘)

> 작성자 : [권혁진](https://github.com/KimKwon), [장주섭](https://github.com/wntjq68), [정희재](https://github.com/Hee-Jae), [이세명](https://github.com/3people), [서그림](https://github.com/Seogeurim)

<details>
<summary>Table of Contents</summary>

- [DFS와 BFS](#dfs와-bfs)
- [정렬 알고리즘의 종류와 개념](#정렬-알고리즘의-종류와-개념)
- [최단 경로 알고리즘](#최단-경로-알고리즘)
- [최장 증가 부분수열 알고리즘](#최장-증가-부분수열-알고리즘)

</details>

## DFS와 BFS

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 권혁진 | [깊이우선탐색 DFS 에 대하여](https://nukw0n-dev.tistory.com/5)

---

## 정렬 알고리즘의 종류와 개념

- 작성자 장주섭

### Insertion Sort (삽입정렬)

삽입정렬이란, 배열의 모든 요소를 배열의 시작부터 끝까지 현재 배열의 요소들과 비교해 가면서 적절한 위치에 삽입하는 정렬 알고리즘이다.

#### Example

> 28 13 23 25 19 : 초기 배열
>
> 28 **13** 23 25 19 : 2번째 자리 13 부터 시작
>
> 13 28 **23** 25 19 : 13은 적절한 자리를 찾아가고 다음으로 3번째 자리 23을 본다.
>
> 13 23 28 **25** 19 : 23도 적절한 자리를 찾아가고 다음으로 4번째 자리 25를 본다.
>
> 13 23 25 28 **19** : 25도 적절한 자리를 찾아가고 다음으로 5번쨰 자리 19를 본다.
>
> 13 19 23 25 28 : 정렬 완료!

#### 시간복잡도

![formula](<https://render.githubusercontent.com/render/math?math=O(n^2)>)

#### Source Code

```java
void insertionSort(int[] arr)
{

   for(int index = 1 ; index < arr.length ; index++){

      int temp = arr[index];
      int aux = index - 1;

      while( (aux >= 0) && ( arr[aux] > temp ) ) {

         arr[aux+1] = arr[aux];
         aux--;
      }
      arr[aux + 1] = temp;
   }
}
//출처 위키피디아
```

### Selection Sort (선택정렬)

선택정렬이란, 주어진 배열 중에 최솟값을 찾아 정렬 되지 않은 배열의 맨앞의 값과 자리를 바꾸어 나가는 정렬 알고리즘이다.

배열의 맨앞부터 차례로 정렬이 된다.

#### Example

> **28 13 23 25 19** : 초기배열
>
> 13 **28 23 25 19** : 최솟값 13을 맨 앞의 수 28과 자리 바꾸기
>
> 13 19 **23 25 28** : 다음 최솟값 19를 맨 앞의 수 28과 자리 바꾸기
>
> 13 19 23 **25 28** : 다음 최솟값은 23이니깐 자리 그대로!
>
> 13 19 23 25 **28** : 다음 최솟값은 25이니깐 자리 그대로!
>
> 13 19 23 25 28 : 정렬 완료!

#### 시간복잡도

![formula](<https://render.githubusercontent.com/render/math?math=O(n^2)>)

#### Source Code

```java
void selectionSort(int[] list) {
    int indexMin, temp;

    for (int i = 0; i < list.length - 1; i++) {
        indexMin = i;
        for (int j = i + 1; j < list.length; j++) {
            if (list[j] < list[indexMin]) {
                indexMin = j;
            }
        }
        temp = list[indexMin];
        list[indexMin] = list[i];
        list[i] = temp;
    }
}
//출처 위키피디아
```

### Bubble Sort (거품정렬)

거품정렬이란, 인접한 두 원소를 비교해 가면서 자리를 바꾸는 방식의 정렬 알고리즘이다.

배열의 맨뒤부터 차례로 정렬이 된다.

#### Example

> **(28 13) 23 25 19** : 28 > 13 Change!
>
> **13 (28 23) 25 19** : 28 > 23 Change!
>
> **13 23 (28 25) 19** : 28 > 25 Change!
>
> **13 23 25 (28 19)** : 28 > 19 Change!
>
> **(13 23) 25 19** 28 : 28 최댓값으로 고정, 13 < 23 Pass!
>
> **13 (23 25) 19** 28 : 23 < 25 Pass!
>
> **13 23 (25 19)** 28 : 25 > 19 Change!
>
> **(13 23) 19** 25 28 : 25 다음 최댓값으로 고정, 13 < 23 Pass!
>
> **13 (23 19)** 25 28 : 23 > 19 Change!
>
> **(13 19)** 23 25 28 : 23 다음 최댓값으로 고정, 13 < 19 Pass!
>
> 13 19 23 25 28 : 19 다음 최댓값으로 고정, 정렬 완료!

#### 시간복잡도

![formula](<https://render.githubusercontent.com/render/math?math=O(n^2)>)

#### Source Code

```java
void bubbleSort(int[] arr) {
    int temp = 0;
    for(int i = 0; i < arr.length; i++) {
        for(int j= 1 ; j < arr.length-i; j++) {
            if(arr[j]<arr[j-1]) {
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    System.out.println(Arrays.toString(arr));
}
```

### Merge Sort (합병정렬)

합병정렬은 문제를 분리하고 각각을 해결한 후 다시 합치는 Divide & Concuer 방식을 사용한다.

- Divide(분할) : 초기 배열을 2개의 배열로 분할한다.
- Concuer(정복) : 각 부분배열을 재귀적으로 병합정렬을 사용하여 정렬한다.
- Combine(결합) : 부분배열을 하나의 배열로 결합한다.

#### Example

<img width="800" src="https://user-images.githubusercontent.com/22047374/104850221-255c2f00-5931-11eb-8ea3-4497d2a16346.png">

#### 시간복잡도

- Avaerage Case : ![formula](<https://render.githubusercontent.com/render/math?math=O(n\log_2n)>)
- Worst Case : ![formula](<https://render.githubusercontent.com/render/math?math=O(n\log_2n)>)

#### Source Code

```java
void mergeSort(int[] arr, int start, int end) {
  if (start < end) {
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }
}

void merge(int[] arr, int start, int mid, int end) {
  int i = start; // 왼쪽 배열의 시작
  int j = mid + 1; // 오른쪽 배열의 시작
  int k = 0; // 병합된 배열의 시작

  int[] temp = new int[end - start + 1];
  while (i <= mid && j <= end) {
    if (arr[i] < arr[j]) {
      temp[k++] = arr[i++];
    } else {
      temp[k++] = arr[j++];
    }
  }
  // 남은 값 복사
  if (i > mid) { // 왼쪽 배열 값 다 사용함 , 오른쪽 다 복사
    for (int idx = j; idx <= end; idx++, k++) {
      temp[k] = arr[idx];
    }
  } else { // 오른쪽 배열 값 다 사용함, 왼쪽 다 복사
    for (int idx = i; idx <= mid; idx++, k++) {
      temp[k] = arr[idx];
    }
  }
  // 임시 배열 -> 원래 배열
  for (int num : temp) {
    arr[start++] = num;
  }
}
```

#### 장점

- 안정적인 정렬 방법이다. 입력데이터의 분포에 상관없이 ![formula](<https://render.githubusercontent.com/render/math?math=O(n\log_2n)>) 를 유지 할 수 있다.

#### 단점

- 배열을 사용하면 임시 배열을 사용해야 한다.
- 배열의 크기가 커지면 데이터의 이동 횟수가 많아져 시간이 커질 수 있다.

### Quick Sort (퀵정렬)

합병정렬은 문제를 분리하고 각각을 해결한 후 다시 합치는 Divide & Concuer 방식을 사용한다.

1. 주어진 배열에서 pivot을 선정한다.(밑에 소스코드에선 맨 앞의 값으로 함)
2. pivot을 기준으로 작은 값들이 모인 배열과 큰 값들이 모인 배열로 비균등하게 배열을 두 부분으로 나눈다.
3. 해당 pivot을 기준으로 배열을 나누고 나면 pivot은 고정 된다. (재귀 호출마다 pivot의 위치는 매번 고정 되므로 이 알고리즘이 반드시 끝나는 것을 보장한다.)
4. 분할된 두 배열에서 재귀적으로 이 과정을 반복한다.

#### 시간복잡도

- Avaerage Case : ![formula](<https://render.githubusercontent.com/render/math?math=O(n\log_2n)>)
- Worst Case : ![formula](<https://render.githubusercontent.com/render/math?math=O(n^2)>)

#### Example

> 3 7 6 5 1 4 2 : 초기배열
>
> **pivot = 3**
>
> 3 **7** 6 5 1 4 **2** : low = 1, high = 6, swap!
>
> 3 2 **6** 5 1 **4** 7 : low = 2, high, = 5
>
> 3 2 **6** 5 **1** 4 7 : low = 2, high = 4, swap!
>
> 3 2 1 **5** 6 4 7 : low = 3, high = 3
>
> 3 2 **1** **5** 6 4 7 : low = 3, high = 2 (서로 지나침) => high 와 pivot swap!
>
> 1 2 **3** 5 6 4 7
>
> **pivot = 1**
>
> ...
>
> **pivot = 5**
>
> ...

#### Source Code

```java
void quickSort(int[] arr, int start, int end) {
  if (start < end) { // 배열의 크기가 충분히 작아 질 때 까지 나눔
    int p = partition(arr, start, end); // 파티션을 적용 했을 때 피봇의 인덱스를 구함

    quickSort(arr, start, p - 1); // 처음 부터 피봇 전,
    quickSort(arr, p + 1, end); // 피봇 후 부터 마지막 까지 다시 퀵소트를 함
  }
}

int partition(int[] arr, int start, int end) {
  int low = start + 1; // pivot을 맨 왼쪽 값으로 할것이기 때문에 그 다음 값부터 확인
  int high = end;
  int pivot = arr[start]; // 가장 왼쪽 값을 pivot으로 설정

  while (low <= high) { // 양쪽에서 탐색하면서 둘이 겹쳐져 지나칠때 까지 한다.
    while (low <= end && arr[low] < pivot) { // 앞에서 부터 비교중 pivot 보다 크면 stop
      low++;
    }
    while (high >= start && arr[high] > pivot) { // 뒤에서 부터 비교중 pivot 보다 작으면 stop
      high--;
    }
    if (low < high) { // low , high 가 겹쳐져 지나친게 아니면 둘을 바꿔줌
      swap(arr, low, high);
    }
  }
  swap(arr, start, high); // 마지막으로 pivot과 high index의 값을 바꾸면 high index 가 pivot의 index가 됨
  return high; // pivot 위치 반환
}

void swap(int[] arr, int i, int j) {
  int temp = arr[j];
  arr[j] = arr[i];
  arr[i] = temp;
}

```

#### 장점

- 속도가 매우 빠르다
- 추가적인 메모리 공간을 필요로 하지 않는다

#### 단점

- 불균형 분할이 많아질 경우 최악의 경우 시간이 오래 걸릴 수 있다.
  - 불균형 분할을 방지하기 위해 세 값의 중위법을 사용해서 피벗을 선택하는 경우가 많다.

### Quick Sort vs Merge Sort

두 정렬 알고리즘 다 average case ![formula](<https://render.githubusercontent.com/render/math?math=O(n\log_2n)>) 이고 심지어 Quick Sort는 worst case ![formula](<https://render.githubusercontent.com/render/math?math=O(n^2)>)이다. 하지만 보통 일반적으로 퀵소트가 빠른것으로 알고 있다.

일단 Quick Sort 의 worst case 는 (맨앞의 수를 pivot으로 가정) 아이러니 하게 정렬이 잘 되어 있는 배열에서 나온다.

이렇게 Quick Sort의 worst case 와 평균 적인 Merge Sort 를 비교해 보아도 Quick Sort가 더 빠르게 나온다. 그 이유는 실제 시간 정렬 되는 중 Merge Sort는 분할 과정에서 추가적인 배열을 생성해야 한다는 문제가 있다. 이러한 과정에서 계속적으로 Delay 가 생기다 보니 결과적으로 Quick Sort가 더욱 빠르게 정렬이 되는 것이다.

### Heap, Radix, Counting Sort

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 이세명 | [Heap, Radix, Counting Sort](./materials/이세명_algorithm_sorting.pdf)

---



---

## 최단 경로 알고리즘

- 작성자 서그림 | [최단 경로 알고리즘](./materials/최단경로알고리즘.pdf)

### 최단 경로 문제

최단 경로 문제란, 가중 그래프에서 간선의 가중치의 합이 최소가 되는 경로를 찾는 문제이다. 최단 경로 문제는 다음과 같은 유형들이 있다.

- 단일 출발 (single-source) 최단 경로 : 어떤 하나의 정점에서 출발하여 나머지 모든 정점까지의 최단 경로를 찾는다.
- 단일 도착 (single-destination) 최단 경로 : 모든 정점에서 출발하여 어떤 하나의 정점까지의 최단 경로를 찾는다.  
  _(그래프 내의 간선들을 뒤집으면 단일 출발 최단 경로 문제로 바뀔 수 있다.)_
- 단일 쌍 (single-pair) 최단 경로 : 어떤 정점 v에서 v'로 가는 최단 경로를 찾는다.
- 전체 쌍 (all-pair) 최단 경로 : 모든 정점 쌍들 사이의 최단 경로를 찾는다.

최단 경로 문제를 해결하는 알고리즘으로는 대표적으로 **다익스트라, 벨만-포드, 플로이드-워셜 알고리즘**이 있다. 각 알고리즘을 적용하기 적합한 유형은 다음과 같다.

- 다익스트라 알고리즘 : **음이 아닌** 가중 그래프에서의 **단일 출발, 단일 도착, 단일 쌍** 최단 경로 문제
- 벨만-포드 알고리즘 : 가중 그래프에서의 **단일 출발, 단일 도착, 단일 쌍** 최단 경로 문제
- 플로이드-워셜 알고리즘 : **전체 쌍** 최단 경로 문제
- _BFS : 가중치가 없거나 가중치가 동일한 그래프에서 최단 경로를 찾는 경우 가장 빠르다._

### 다익스트라 알고리즘 (Dijkstra Algorithm)

그래프 G = (V, E) 에서 특정 출발 정점(S)에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘이다. 음의 가중치를 가지는 간선이 없을 때 정상적으로 동작한다.

#### 알고리즘 설계 및 구현

1. 출발 노드 S를 설정한다.
2. 출발 노드 S에서 모든 노드들까지의 최단 거리를 저장하는 배열 D를 초기화한다.
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다. (D 배열 검사)
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 배열 D를 갱신한다.
5. 모든 노드를 방문할 때까지 3, 4 과정을 반복한다.

![다익스트라](https://user-images.githubusercontent.com/22045163/106482569-eca38480-64f0-11eb-9c52-28a886a9f947.gif)

다익스트라 알고리즘 구현 ▶️ [DijkstraTest.java](./code/DijkstraTest.java)

#### 특징

- 각 정점을 최대 한 번씩만 방문하여 최단 거리를 확정한다.
- 아직 방문하지 않은 정점들 중 최단 거리인 정점을 찾아 방문하는 식으로 진행된다.
  - 이 때, 최단 거리가 최소인 정점을 찾는 과정에서 PriorityQueue 또는 Heap 자료구조를 이용하면 더욱 개선된 알고리즘이 가능하다.
- 매 순간마다 최단 거리의 정점을 선택하는 과정을 반복하므로 그리디 알고리즘으로 분류된다.
- 총 V x V 번 연산이 필요하므로 **O(V^2)** 의 시간복잡도를 가진다.

### 개선된 다익스트라 알고리즘

다익스트라 알고리즘에는 **방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택**하는 과정이 있다. 이 과정에서 다음과 같은 비용이 발생한다.

- 방문했는지 여부에 대한 정보를 저장하는 배열을 노드의 크기(V) 만큼 생성하고 접근해야 한다.
- D 배열을 모두 순회하여 최단 거리가 짧은 노드를 선택해야 한다.

이 과정을 PriorityQueue 또는 Heap 자료구조를 이용하면 노드를 선택하는 비용을 O(V)에서 O(log{`힙에 저장한 정점의 개수`})로 줄일 수 있다.
최단 거리가 가장 짧은 노드를 선택해야 하므로 **최소 힙**을 사용하면 되며, 힙을 통해 구현된 **Priority Queue**를 사용해도 좋다.
동작 과정은 다음과 같다.

1. 출발점에 대하여 D 배열을 초기화할 때 `D[S] = 0`을 해준다. 이와 동시에 힙에 노드 정보(번호, 거리 : `[S, 0]`)를 넣어준다.
2. 힙에서 맨 위에 있는 노드 I를 꺼낸다.
3. 만일 꺼낸 노드 I의 거리 정보가 현재 D[I]보다 크다면 이미 방문한 노드일 것이므로 무시한다.
4. I를 대상으로 다익스트라 알고리즘을 수행하는데, D 배열이 갱신될 경우 그 노드 정보를 힙에 넣는다.  
   (D[J] = D[I] + W 로 갱신될 경우 힙에 노드 J(`[J, D[J]]`)를 삽입한다.)
5. 힙에 노드가 없을 때까지 반복한다.

개선된 다익스트라 알고리즘의 시간 복잡도는 **O(ElogV)** 이다. (O(ElogE) → O(ElogV²) → O(2ElogV) → O(ElogV))

![개선다익스트라](https://user-images.githubusercontent.com/22045163/106778119-f9f37700-6688-11eb-8e6d-6e824596e184.jpg)

개선된 다익스트라 알고리즘 구현 ▶️ [DijkstraTest.java > class ImprovedDijkstra](./code/DijkstraTest.java)

### 벨만-포드 알고리즘 (Bellman-Ford-Moore Algorithm)

그래프 G = (V, E) 에서 특정 출발 정점(S)에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘이다. 다익스트라 알고리즘과 달리, 음의 가중치를 가지는 간선도 가능하다.

#### 아이디어

- 가중 그래프 (V, E)에서 **어떤 정점 A에서 정점 B까지의 최단 거리는 최대 V - 1개의 간선을 사용**한다. (= 시작 정점 A를 포함하여 최대 V개의 정점을 지난다.)

#### 알고리즘 설계 및 구현

1. 출발 노드 S를 설정한다.
2. 출발 노드 S에서 모든 노드들까지의 최단 거리를 저장하는 배열 D를 초기화한다.
3. 그래프의 모든 간선을 돌면서 각 노드로 가는 비용을 계산하여 최단 거리 배열 D를 갱신한다.
4. 3 과정을 (노드의 개수 - 1)번, 즉 V-1번 반복한다.
5. 3 과정을 한 번 더 반복하였을 때, 배열 D가 갱신되면 음의 사이클이 있는 것으로 판단한다.

![벨만포드](https://user-images.githubusercontent.com/22045163/106553083-f6160680-655b-11eb-8da9-cda67af0493e.gif)

벨만-포드 알고리즘 구현 ▶️ [BellmanFordTest.java](./code/BellmanFordTest.java)

#### 특징

- 음의 가중치를 가지는 간선도 가능하므로, 음의 사이클의 존재 여부를 따져야 한다.
- 최단 거리를 구하기 위해서 V - 1번 E개의 모든 간선을 확인한다.
- 음의 사이클 존재 여부를 확인하기 위해서 한 번 더 (V번째) E개의 간선을 확인한다. 이 때 거리 배열이 갱신되었다면, 그래프 G는 음의 사이클을 가진다.
- 따라서 총 V x E 번 연산하므로 **O(VE)** 의 시간복잡도를 가진다.

### 플로이드-워셜 알고리즘 (Floyd-Warshall Algorithm)

그래프 G = (V, E) 에서 모든 정점 사이의 최단 경로를 구하는 알고리즘이다.

#### 아이디어

- 어떤 두 정점 사이의 최단 경로는 **어떤 경유지(K)를 거치거나, 거치지 않는 경로 중 하나**이다. 즉 정점 A와 정점 B 사이의 최단 경로는 A-B 이거나 A-K-B 이다.
- 만약 경유지(K)를 거친다면 최단 경로를 이루는 부분 경로 역시 최단 경로이다. 즉 A-B의 최단 경로가 A-K-B라면 A-K와 K-B도 각각 최단 경로이다.

#### 알고리즘 설계 및 구현

1. 각 노드들 사이의 최단 거리를 저장하는 2차원 배열 D를 초기화한다.
2. 각 노드가 경유지 K를 지날 때마다 최단 경로를 계산하여 배열 D를 갱신한다.
3. 동적 계획법으로 해결하며, 점화식은 `D[A][B] = min(D[A][B], D[A][K] + D[K][B]` 이다.

![플로이드워셜](https://user-images.githubusercontent.com/22045163/106489876-95091700-64f8-11eb-91fa-bd903685f284.gif)

플로이드-워셜 알고리즘 구현 ▶️ [FloydWarshallTest.java](./code/FloydWarshallTest.java)

#### 특징

- 사이클이 없다면 음수 가중치를 가져도 적용 가능하다.
- 동적 계획법(Dynamic Programming)으로 접근한다.
- 모든 가능한 경유지에 대해서 모든 정점 -> 모든 정점으로 가는 최단 거리를 확인하므로 연산 횟수는 V^3이고, 따라서 시간복잡도는 **O(V^3)** 이다.

---

## 최장 증가 부분수열 알고리즘

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 권혁진 | [최장증가부분수열 LIS](https://github.com/Seogeurim/CS-study/blob/Algorithm/KwonHJ/contents/algorithm/materials/%EC%B5%9C%EC%9E%A5%EC%A6%9D%EA%B0%80%EC%88%98%EC%97%B4.pdf)

LIS 완전탐색 알고리즘 구현 ▶️ [lis_brute.cpp](./code/lis_brute.cpp)

LIS 동적계획법 알고리즘 구현 ▶️ [lis_dp.cpp](./code/lis_dp.cpp)

LIS 이분탐색 알고리즘 구현 ▶️ [lis_bs.cpp](./code/lis_bs.cpp)

---

## 질의응답

> 아직 없습니다.
