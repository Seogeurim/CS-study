# Data Structure (자료구조)

## 기본 자료 구조 [▶︎ 🗒](basic.md)

- [Array](basic.md#array-배열)
- [Linked List](basic.md#linked-list-연결-리스트)
- [Stack](basic.md#stack-스택)
- [Queue](basic.md#queue-큐)
- [Tree](basic.md#tree-트리)
- [Binary Tree](basic.md#binary-tree-이진-트리)
- [Graph](basic.md#graph-그래프)

## 응용 자료 구조 [▶︎ 🗒](advanced.md)

- [Deque](advanced.md#deque-덱)
- Heap & Priority Queue
- [Indexed Tree (Segment Tree)](advanced.md#세그먼트-트리-indexed-tree--segment-tree)
- [Trie](advanced.md#trie-트라이)

---

## 질의응답

<details>
<summary>Array와 Linked List를 그 차이점을 이용해 설명해봅시다.</summary>

- 데이터 접근 속도
  - Array는 인덱스를 통한 Random Access를 지원하므로 시간 복잡도 O(1)로 빠르게 찾을 수 있다.
  - LinkedList는 순차 접근 방식을 사용하므로 시간 복잡도 O(N)이 걸린다.
- 데이터의 삽입/삭제 속도
  - Array는 데이터를 중간이나 맨 앞에 삽입/삭제하는 경우 shift가 필요하므로 데이터가 많을수록 비효율적이다.
  - LinkedList는 중간 삽입/삭제는 똑같이 O(N)의 시간 복잡도를 갖지만, 맨 앞 또는 뒤에 삽입할 경우 O(1)의 시간복잡도를 갖는다.
  - 다만 LinkedList는 데이터 삽입/삭제마다 메모리 할당/해제가 일어나므로 시간복잡도는 빠를지라도 시스템 콜(System Call)에 있어서 Array보다 더 시간이 걸린다.
- 메모리 할당
  - Array는 정적 메모리 할당이 이루어진다. (Compile time)
  - LinkedList는 동적 메모리 할당이 이루어진다. (Runtime)
  - Array의 경우 데이터 삽입 시 모든 공간이 다 차버렸다면 새로운 메모리 공간이 필요하지만 LinkedList는 동적으로 할당받을 수 있다.

데이터 삽입/삭제가 빈번하다면 LinkedList를 사용하는 것이 좋고, 데이터 접근 속도가 중요하다면 Array를 사용하는 것이 좋다.

</details>

<details>
<summary>스택으로 큐를 구현할 수 있을까요?</summary>
네. 2개의 스택을 이용하여 구현할 수 있습니다. Enqueue 연산은 첫번째 스택에 원소를 추가하면 됩니다. Dequeue 연산은 두번째 스택을 이용합니다. 우선 두번째 스택이 비어있다면 첫번째 스택이 빌 때까지 첫번째 스택의 원소를 pop하고 두번째 스택에 push하는 것을 반복합니다. 그리고 두번째 스택이 비어있지 않다면 두번째 스택의 원소를 pop하면 됩니다.
</details>

<details>
<summary>큐로 스택을 구현할 수 있을까요?</summary>
네. 2개의 큐를 이용하여 구현할 수 있습니다. `push` 연산은 첫번째 큐에 원소를 추가하기 전에 첫번째 큐가 빌때까지 두번째 큐로 값을 옮겨줍니다. 그 후 첫번째 큐에 원소를 추가하고 두번째 큐에서 다시 첫번째 큐로 빌때까지 원소들을 전부 다시 옮겨줍니다. 쉽게 말하자면 원소를 추가할 때마다 원소들의 위치를 스택에 맞게 변경시키는 것입니다. `pop` 연산은 첫번째 큐에서 dequeue만 하면 됩니다.
</details>

<!-- Data Structure study 질의응답 정리 -->


<details>
<summary>자료구조가 무엇인지 말씀해주세요.</summary>
  
자료구조는 컴퓨터 과학에서 `효율적인 접근 및 수정`을 가능케 하는 자료의 조직, 관리, 저장을 의미한다.   
더 정확히 말해, 자료 구조는 데이터 값의 모임, 또 데이터 간의 관계, 그리고 데이터에 적용할 수 있는 함수나 명령을 의미한다.
</details>

<details>
<summary>Queue와 Dequeue의 차이점은 무엇일까요?</summary>
  
`Queue` 는 front에서만 output이 발생하고 rear에서만 input이 발생하는 입출력의 방향이 제한되어 있는 자료구조이다.
  반면 `Dequeue` 는 양방향에서 입출력이 가능하다. 
</details>


<details>
<summary>Queue보다 Dequeue를 사용했을 때 더 효율적인 경우가 있을까요?</summary>
  
스케줄링 알고리즘을 수행할 때 스케줄링이 복잡해질수록 덱이 더 효율적으로 동작한다.  
즉, 우선순위를 관리하는 데 있어 스택과 큐에 비해 이점을 갖는다.
예를 들어 오래된 프로세스에 우선순위를 주고 싶다면 앞에 있는 프로세스를 빼내야하는데 이는 스택에서 불가능하고 최근에 들어온 프로세스에 우선순위를 두고 싶다면 큐에서 불가능하다.  
반면 덱은 두 경우 모두에서 사용 가능하다.
</details>

<details>
<summary>Heap이란 무엇일까요?</summary>
  
힙은 최댓값 및 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 완전이진트리를 기본으로 한 자료구조로서 다음과 같은 힙 속성을 만족한다.  
A가 B의 부모노드 이면, A의 키값과 B의 키값 사이에는 대소관계가 성립한다.
Max-Heap의 경우 `A > B`를 만족하고,  
Min-Heap의 경우 `A < B`를 만족한다.
                     
이렇게 Heap은 부모와 자식노드 간의 대소관계를 만족하는 `느슨한 정렬 상태`를 가진 자료구조이다. 
</details>
  
  <details>
<summary>그림의 Heap구조에서 삭제연산이 일어났을 때 Heap의 변화를 서술하세요.</summary>
    
<img width="491" alt="스크린샷 2021-06-01 오전 11 47 16" src="https://user-images.githubusercontent.com/22493971/120898116-7b253f80-c664-11eb-9f84-39d795b36bff.png">

1. 루트 노드 값을 삭제한다. (44 삭제)  
2. 가장 마지막 리프노드를 루트 노드로 이동한다. (14가 루트 노드로 이동)  
3. Heapify 진행  
     a. 현재 노드의 자식노드가 현재 노드보다 클 경우 SWAP한다. (14<->42) (14<->33)  

<img width="491" alt="ㅋㅋ" src="https://user-images.githubusercontent.com/22493971/120898448-defc3800-c665-11eb-95f1-76d75ad804fd.png">

</details>
