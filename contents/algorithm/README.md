# Algorithm (알고리즘)

## 정리 자료

- 권혁진 : DFS와 BFS



## 정렬 알고리즘

### Insertion Sort (삽입정렬)

삽입정렬이란, 배열의 모든 요소를 배열의 시작부터 끝까지 현재 배열의 요소들과 비교해 가면서 적절한 위치에 삽입하는 정렬 알고리즘이다.

**Example**

>28 13  23 25 19 : 초기 배열
>
>28 **13** 23 25 19  : 2번째 자리 13 부터 시작
>
>13 28 **23** 25 19 : 13은 적절한 자리를 찾아가고 다음으로 3번째 자리 23을 본다.
>
>13 23 28 **25** 19 : 23도 적절한 자리를 찾아가고 다음으로 4번째 자리 25를 본다.
>
>13 23 25 28 **19** : 25도 적절한 자리를 찾아가고 다음으로 5번쨰 자리 19를 본다.
>
>13 19 23 25 28 : 정렬 완료!



**시간복잡도**

$O(n^2)$



**Source Code**

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

**Example**

>**28 13 23 25 19 **: 초기배열
>
>13 **28 23 25 19** : 최솟값 13을 맨 앞의 수 28과 자리 바꾸기
>
>13 19 **23 25 28** : 다음 최솟값 19를  맨 앞의 수 28과 자리 바꾸기
>
>13 19 23 **25 28** : 다음 최솟값은 23이니깐 자리 그대로!
>
>13 19 23 25 **28** : 다음 최솟값은 25이니깐 자리 그대로!
>
>13 19 23 25 28 : 정렬 완료!



**시간복잡도**

$O(n^2)$



**Source Code**

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

**Example**

> **(28 13) 23 25 19 **: 28 > 13 Change!
>
> **13 (28 23) 25 19** : 28 > 23 Change!
>
> **13 23 (28 25) 19** : 28 > 25 Change!
>
> **13 23 25 (28 19)** : 28 > 19 Change!
>
> **(13 23) 25 19 **28 : 28 최댓값으로 고정, 13 < 23 Pass!
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



**시간복잡도**

$O(n^2)$



**Source Code**

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

합병정렬이란, 문제를 분리하고 각각을 해결한 후 다시 합치는 Divide & Concuer 방식을 사용한다.

- Divide(분할) : 초기 배열을 2개의 배열로 분할한다.

- Concuer(정복) : 각 부분배열을 재귀적으로 병합정렬을 사용하여 정렬한다.

- Combine(결합) : 부분배열을 하나의 배열로 결합한다.

  

**Example**

<img width="800" src="https://user-images.githubusercontent.com/22047374/104850221-255c2f00-5931-11eb-8ea3-4497d2a16346.png">

**시간복잡도**

Avaerage Case : $O(n\log_2n)$

Worst Case : $O(n\log_2n)$

**Source Code**

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

 

**장점**

- 안정적인 정렬 방법이다. 입력데이터의 분포에 상관없이 $O(n\log_2 n)$ 를 유지 할 수 있다. 

**단점**

- 배열을 사용하면 임시 배열을 사용해야 한다.
- 배열의 크기 가 커지면 데이터의 이동 횟수가 많아져 시간이 커질 수 있다.

### Quick Sort



## 질의응답

> 아직 없습니다.
