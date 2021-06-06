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
<summary>선형구조와 비선형 구조의 차이가 무엇인가요?</summary>

자료구조는 저장되는 데이터의 형태에 따라 구분되며, 선형구조는 데이터가 일렬로 나열되어있고, 비선형 구조는 데이터가 특정한 형태를 띄고 있다.
</details>

<details>
<summary>배열과 연결리스트 차이에 대해 설명해주세요</summary>
  
배열은 동일한 자료형의 데이터를 일렬로 나열한 자료구조로서, 데이터 접근이 용이하나 데이터의 삽입과 삭제가 어렵다. 
연결리스트는 각 노드가 데이터와 포인터를 가지고 일렬로 연결된 자료구조로서, 데이터의 접근이 O(n)으로 느리지만 데이터의 삽입과 삭제가 용이하다.
</details>

<details>
<summary>A-B-C-D 순서로 연결된 연결 리스트가 있다. C다음에 F노드를 삽입할때의 과정을 설명해라.</summary>
  
1. F의 next node를 C의 next node인 D로 설정한다.
`A-B-C-D`
`F-D`

2. C의 next node를 F로 설정한다.
`A-B-C-F-D`

</details>

<details>
<summary>큐와 덱의 차이점은 무엇일까요?</summary>
  
`큐` 는 front에서만 output이 발생하고 rear에서만 input이 발생하는 입출력의 방향이 제한되어 있는 자료구조이다.
  반면 `덱` 은 양방향에서 입출력이 가능하다. 
</details>

<details>
<summary>큐보다 덱을 사용했을 때 더 효율적인 경우가 있을까요?</summary>
  
스케줄링 알고리즘을 수행할 때 스케줄링이 복잡해질수록 덱이 더 효율적으로 동작한다.  
즉, 우선순위를 관리하는 데 있어 스택과 큐에 비해 이점을 갖는다.
예를 들어 오래된 프로세스에 우선순위를 주고 싶다면 앞에 있는 프로세스를 빼내야하는데 이는 스택에서 불가능하고 최근에 들어온 프로세스에 우선순위를 두고 싶다면 큐에서 불가능하다.  
반면 덱은 두 경우 모두에서 사용 가능하다.
</details>

<details>
<summary>트리라는 자료구조가 무엇인지 간략하게 한줄로 설명해보세요.</summary>
  
자료들 사이의 계층적 관계를 나타내는데 사용하는 자료구조로 부모-자식관계로 표현합니다.
</details>

<details>
<summary>트리의 용어중 '깊이' 라는 용어의 정의는 무엇인가?</summary>
  
루트 노드에서 해당노드까지 도달하는데 사용하는 간선의 개수며, 루트노드의 깊이는 0입니다.
</details>

<details>
<summary>포화 이진트리와 완전이진트리의 차이점은 무엇인가?</summary>
  
포화 이진 트리(Perfect Binary Tree) : 정 이진트리(Full Binary Tree)에서 모든 단말 노드의 깊이가 같은 이진트리
완전 이진 트리(Complete Binary Tree) : 마지막 레벨은 노드가 왼쪽에 몰려있고, 마지막 레벨을 제외하면 포화이진트리(Perfect Binary Tree) 구조를 띄고 있음
</details>

<details>
<summary>트리의 순회에 대해 알고있는것 한가지 말해주세요</summary>
  
전위 순회(Pre-order)  : __현재 노드 방문__ -> 왼쪽 자식 탐색 -> 오른쪽 자식 탐색
중위 순회(In-order)   : 왼쪽 자식 탐색 -> __현재 노드 방문__ -> 오른쪽 자식 탐색
후위 순회(Post-order) : 왼쪽 자식 탐색 -> 오른쪽 자식 탐색 -> __현재노드 방문__
</details>

<details>
<summary>구간합을 푸려고 할때 누적합으로 풀려한다. 단점은 무엇이며 그에 비해 인덱스 트리가 갖는 장점을 시간복잡도를 들어 설명해라</summary>
  
누적합으로 풀 경우 누적합을 구하는데 O(N), 이를 M번 수행하면 O(MN)이 걸린다. 하지만 인덱스 트리를 사용할 경우 누적합을 구하는데 O(logN)이 걸리므로, 이를 M번 수행하면 O(MlogN)이 걸리기에 구간합을 여러차례 구하는 중간에 배열의 값이 바뀌는 경우 인덱스 트리가 적합하다.
</details>

<details>
<summary>인덱스 트리에서 삽입이 일어날때의 시간복잡도는 몇인가?</summary>
  
수행시간은 O(logN)이다.
</details>

<summary>힙이란 무엇일까요?</summary>
  
힙은 최댓값 및 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 완전이진트리를 기본으로 한 자료구조로서 다음과 같은 힙 속성을 만족한다.  
A가 B의 부모노드 이면, A의 키값과 B의 키값 사이에는 대소관계가 성립한다.
최대 힙의 경우 `A > B`를 만족하고,  
최소 힙의 경우 `A < B`를 만족한다.
                     
이렇게 힙은 부모와 자식노드 간의 대소관계를 만족하는 `느슨한 정렬 상태`를 가진 자료구조이다. 
</details>
  
  <details>
<summary>그림의 힙 구조에서 삭제연산이 일어났을 때 힙의 변화를 서술하세요.</summary>
    
<img width="491" alt="스크린샷 2021-06-01 오전 11 47 16" src="https://user-images.githubusercontent.com/22493971/120898116-7b253f80-c664-11eb-9f84-39d795b36bff.png">

1. 루트 노드 값을 삭제한다. (44 삭제)  
2. 가장 마지막 리프노드를 루트 노드로 이동한다. (14가 루트 노드로 이동)  
3. Heapify 진행  
> Heapify란 루트노드부터 시작하여 힙의 구조를 만족할 때까지 부모/자식 노드 간 Swap연산을 하며 밑으로 내려가는 연산을 의미한다. 
    
     a. 현재 노드의 자식노드가 현재 노드보다 클 경우 SWAP한다. (14<->42) (14<->33)  

<img width="491" alt="ㅋㅋ" src="https://user-images.githubusercontent.com/22493971/120898448-defc3800-c665-11eb-95f1-76d75ad804fd.png">

</details>
