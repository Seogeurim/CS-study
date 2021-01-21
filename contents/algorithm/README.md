# Algorithm (알고리즘)

> 작성자 : [권혁진](https://github.com/KimKwon), [장주섭](https://github.com/wntjq68)

<details>
<summary>Table of Contents</summary>

- [DFS와 BFS](#dfs와-bfs)
- [정렬 알고리즘의 종류와 개념](#정렬-알고리즘의-종류와-개념)

</details>

## DFS와 BFS

- [깊이우선탐색 DFS 에 대하여](https://nukw0n-dev.tistory.com/5)

## 정렬 알고리즘의 종류와 개념

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

### Quick Sort

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

- 권혁진 : DFS와 BFS
- 정희재 : [Segment Tree](./materials/세그먼트트리.pdf)
## 질의응답

> 아직 없습니다.
