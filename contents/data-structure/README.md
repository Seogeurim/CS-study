# Data Structure (자료구조)

> 작성자 : [서그림](https://github.com/Seogeurim)

자료구조(Data Structure)란 **자료에 효율적으로 접근하고 수정할 수 있도록 데이터를 구성하고 저장하는 방법**을 이야기한다. 자료구조는 저장되는 데이터의 형태에 따라 **선형 자료구조**와 **비선형 자료구조**로 구분되며, 선형 자료구조는 데이터가 일렬로 나열되어 있고 비선형 자료구조는 데이터가 특정한 형태를 띄고 있다. 선형 자료구조의 종류에는 array, linked list, stack, queue 등이 있으며 비선형 자료구조로는 tree, graph 등이 있다.

## Array (배열)

동일한 자료형의 데이터를 일렬로 나열한 자료구조이다.

- 선형 자료구조
- 데이터 접근이 용이하다. (인덱스로 접근 - Random Access가 가능)
- 데이터 삽입/삭제가 어렵다. (Shift 해줘야 함)
- 구조가 간단하여 프로그램 작성이 쉽다.

### Array 구현

#### Java

```java
/* 선언 (Declaring Arrays) */
int[] arrayOfInt;
String[] arrayOfString;

/* 생성 (Creating Arrays) */
arrayOfInt = new int[100];
arrayOfString = new String[10];

/* 초기화 (Initializing Arrays) */
for (int i = 0; i < arrayOfInt.length; i++) {
  arrayOfInt[i] = i;
}
arrayOfString = new String[]{"hello", "world"};
String[] name = {"Stacy", "Tracy", "Dorothy"};
```

### Array 시간 복잡도 & 공간 복잡도

#### 시간 복잡도

- 데이터 조회 : O(1)
- 데이터 삽입/삭제하기 : O(n)

---

## Linked List (연결 리스트)

각 노드가 **데이터**와 **포인터**를 가지고 일렬로 연결되어 있는 방식이다.

- 선형 자료구조
- 데이터의 접근이 느리다. (링크를 타고 가서 찾아야 한다.)
- 데이터의 삽입/삭제 연산이 용이하다.
- 포인터를 위한 추가 공간이 필요하다.

### Linked List 구현

- [Singly Linked List](./code/LinkedList/SinglyLinkedList.java)
- [Doubly Linked List](./code/LinkedList/DoublyLinkedList.java)
- 위 코드 실행 : [LinkedListExample.java](./code/LinkedList/LinkedListExample.java)

### Linked List 시간 복잡도

- 데이터 조회 : O(n)
- **맨 앞/뒤에** 데이터 삽입/삭제하기 : O(1) (SinglyLinkedList의 경우 맨 뒤의 데이터 삭제 연산은 O(n))
- **중간의 원하는 위치에** 데이터 삽입/삭제하기 : O(n) _(원하는 원소까지 데이터를 조회하는 과정이 있으므로 O(n) + O(1))_

---

## Stack (스택)

- 선형 자료구조
- 삽입, 삭제 연산이 한 방향에서 이루어진다.
- **LIFO(Last In First Out)** : 나중에 들어간 원소가 먼저 나오는 구조이다.

### Stack 용어

- `Top` : 스택에 데이터가 삽입될 위치

### Stack 주요 명령어

### Stack 구현

### Stack 시간 복잡도 & 공간 복잡도

### Stack 활용

- 시스템 스택(System Stack) / 실행시간 스택(Runtime stack) : 프로그램의 함수 호출과 복귀에 따른 실행 순서 관리
- 인터럽트 루틴 처리
- 수식의 후위 표기법(Postfix Notation)
- 수식의 괄호식 검사
- 웹 브라우저 방문 기록 (뒤로가기)
- 실행 취소 (undo)

---

## Queue (큐)

- 선형 자료구조
- 한 방향에서는 삽입 연산이, 반대 방향에서는 삭제 연산이 이루어진다.
- **FIFO(First In First Out)** : 먼저 들어간 원소가 먼저 나오는 구조이다.

### Queue 용어

- `Front` / `Head` : 큐에서 데이터가 삭제될 위치
- `Rear` / `Tail` : 큐에서 마지막 데이터가 삽입된 위치

### Queue 주요 명령어

### Queue 구현

### Queue 시간 복잡도 & 공간 복잡도

### Queue 활용

- 프로세스 레디 큐
- 스케쥴링
- 네트워크 패킷 전송시 필요한 버퍼 대기 큐
- 캐시(Cache) 구현
- javascript의 Event Loop 관리 (비동기 처리)
- 너비 우선 탐색(BFS, Breadth-First Search)
- 프린터의 출력 처리

---

## Deque (덱)

- 선형 자료구조
- Double-ended Queue
- 양방향에서 삽입, 삭제 연산이 모두 이루어지는 큐를 말한다.
- Stack(LIFO), Queue(FIFO)처럼 활용이 가능하기 때문에 대신해서 사용할 수 있다.

### Deque 용어

### Deque 주요 명령어

### Deque 구현

### Deque 시간 복잡도 & 공간 복잡도

### Deque 활용

---

## Tree (트리)

자료들 사이의 계층적 관계를 나타내는데 사용하는 자료구조로 부모-자식 관계로 표현된다.

- 비선형 자료구조
- 트리는 다음의 조건을 만족한다.
  - 루트 노드(root node)가 존재한다. _(→ 트리는 반드시 1개 이상의 노드를 가진다.)_
  - 트리의 부분 트리(sub tree) 또한 트리 구조를 따른다.

### Tree 용어

- **루트 노드 (Root Node)** : 트리의 최상위 노드. unique
- **부모 노드 (Parent Node)** : 부모-자식 관계에서 상위 계층의 노드
- **자식 노드 (Child Node)** : 부모-자식 관계에서 하위 계층의 노드
- **형제 노드** : 부모가 동일한 노드
- **조상 노드** : 해당 노드의 부모 노드 ~ 루트 노드까지 가는 경로에 존재하는 모든 노드들
- **후손 노드** : 해당 노드를 루트로 하는 부분 트리(sub tree)에 있는 모든 노드들
- **내부 노드 (internal/nonterminal node)** : 자식이 있는 노드
- **외부 노드 (단말 노드, 잎새 노드, leaf/external/terminal node)** : 자식이 없는 노드
- **깊이 (Depth)** : 루트 노드에서 해당 노드까지 도달하는데 사용하는 간선의 개수
  - 루트 노드의 깊이는 0
- **레벨 (Level)** : 노드의 깊이(depth) + 1
- **높이 (Height)** : 루트 노드에서 해당 노드까지 도달하는데 지나간 정점의 개수
  - 트리의 높이 : 해당 트리 내 모든 노드의 높이 중 최댓값
- **노드의 차수 (Degree)** : 노드의 자식 수
  - 트리의 차수 : 해당 트리 내 모든 노드의 차수 중 최댓값

### Tree 구현

### Tree 시간 복잡도 & 공간 복잡도

### Tree 활용

---

## Binary Tree (이진 트리)

트리의 차수가 2 이하인 트리이다.

- 비선형 자료구조
- 자식이 최대 2개이기 때문에 자식을 왼쪽 자식과 오른쪽 자식으로 구분한다.
- 높이가 `N`인 이진 트리의 최대 노드 개수는 ![formula](https://render.githubusercontent.com/render/math?math=2^{N}-1)개 이다.

### Binary Tree의 종류

- **정 이진 트리 (Fully Binary Tree)** : 모든 노드의 차수가 0 또는 2인 이진트리
- **포화 이진 트리 (Perfect Binary Tree)** : 정 이진 트리에서 모든 외부 노드(leaf node)의 깊이가 같은 이진 트리
  - 높이가 `H`인 포화 이진 트리의 노드 개수는 ![formula](https://render.githubusercontent.com/render/math?math=2^{H}-1)개 이다.
  - 반대로 노드의 개수가 `N`개인 포화 이진 트리의 높이는 ![formula](<https://render.githubusercontent.com/render/math?math=\log_2(N%2B1)>)개 이다.
  - 깊이가 `D`인 포화 이진 트리의 외부 노드(leaf node) 개수는 ![formula](https://render.githubusercontent.com/render/math?math=2^{D})개 이다.
- **완전 이진 트리 (Complete Binary Tree)** : 마지막 레벨은 노드가 왼쪽에 몰려있고, 마지막 레벨을 제외하면 포화 이진 트리 구조를 띄고 있는 이진 트리
- **사향 이진 트리 (Skewed Binary Tree)** : linked list처럼 한 줄로 연결되어 있는 형태의 이진 트리

### Binary Tree 구현

### Binary Tree 시간 복잡도 & 공간 복잡도

### Binary Tree 활용

---

## Trie (트라이)

Trie는 **문자열을 빠르게 검색할 수 있는 자료 구조**로, **단어 사전**과 같은 개념이라 볼 수 있다.

- 비선형 자료구조 (Tree의 응용)
- Prefix Tree, Digital Search Tree, Retrieval Tree 라고도 부름
- 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조
- K진 트리 구조
- 단어 사전을 트라이로 생성, 그 후 찾을 단어를 트라이를 사용해 검색
- 트라이의 root 노드는 항상 빈 문자열

![Trie](https://user-images.githubusercontent.com/22045163/91132291-1c4f9480-e6e8-11ea-831b-e063f1a145e0.jpg)

> 위 그림을 살펴보면, 트리의 깊이에 따라 단어를 1글자, 2글자, 3글자씩 저장한 것을 볼 수 있다. (root 노드는 빈 문자열)
>
> - 'tea' 찾기 : 트리를 따라 가서 t, e, a 를 찾는다.
> - 'tee' 찾기 : 트리를 따라 갔을 때 t, e 다음 e가 없기 때문에 없는 글자이다.
> - 'te' 찾기 : t, e까지는 있지만 e가 단어의 끝이 아니므로 없는 글자이다. (즉 트라이에는 단어의 끝을 알리는 flag가 필요하다.)

### Trie 구현

예제 코드는 알파벳 소문자만 저장하는 트라이라고 생각하고 구현해보겠다.

#### Trie Node 설계

트라이 노드에 필요한 정보는 **자식 노드에 대한 정보** `children`, **현재 노드가 단어의 끝인지 여부** `isEnd` 이 두 가지이다. 구현의 편의를 위해 `getChild`, `hasChild` 메서드도 추가해준다.

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 알파벳 소문자만
    boolean isEnd;

    TrieNode getChild(char c) {
        return children[c - 'a'];
    }

    boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }
}
```

#### Trie 생성하기 (단어 사전 만들기)

단어 사전의 단어를 트라이에 하나씩 삽입한다고 생각해보자.

1. 루트 노드부터 시작하여 단어의 첫 글자부터 트라이를 탐색한다.
2. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **있다면**, 그 자식 노드로 이동한다.
3. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **없다면**, 새로운 자식 노드를 추가한다.
4. 단어의 마지막 글자까지 왔다면, isEnd를 true로 해주면 단어에 대한 정보가 트라이에 저장된다.

#### Trie를 이용하여 검색하기

1. 루트 노드부터 시작하여 단어의 첫 글자부터 트라이를 탐색한다.
2. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **있다면**, 그 자식 노드로 이동한다.
3. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **없다면**, `return false`
4. 단어의 마지막 글자까지 왔는데, isEnd가 false라면 `return false`
5. 단어의 마지막 글자까지 왔고, isEnd가 true라면 `return true`

트라이 생성, 검색에 관한 Trie 클래스를 구현해보면 다음과 같다.

```java
class Trie {
    TrieNode root = new TrieNode(); // 루트 노드 생성

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) { // 단어의 첫 글자 ~ 끝 글자까지 탐색
            char c = word.charAt(i);
            if (!current.hasChild(c)) { // 해당 문자에 대한 자식 노드 있는지 검색 후 그 자식 노드로 이동
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.getChild(c);
        }
        current.isEnd = true; // 끝 글자임을 알리는 플래그 적용
    }

    boolean checkWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) { // 단어의 첫 글자 ~ 끝 글자까지 탐색
            char c = word.charAt(i);
            if (current.hasChild(c)) { // 해당 문자에 대한 자식 노드 있다면 그 자식 노드로 이동
                current = current.getChild(c);
            } else { // 해당 문자에 대한 자식 노드 없으면 return false
                return false;
            }
        }
        return current.isEnd; // 끝까지 왔는데 isEnd라면 true, 아니면 false
    }
}
```

예제 코드 바로 가기 ▶️ [TrieExample.java](./code/TrieExample.java)

### Trie 시간 복잡도

제일 긴 단어의 길이를 M, 총 단어들의 수를 N이라고 할 때,

- **트라이 생성** 시 시간 복잡도 : **O(N\*M)**  
  단어 하나를 삽입하는데 가장 긴 단어의 길이 M 만큼 걸리므로 O(M)이고, 이를 N개 넣으므로 O(N\*M)이다.
- **단어 검색** 시 시간 복잡도 : **O(M)**  
  가장 긴 문자열의 길이만큼 걸리므로 O(M)이다.

단어를 하나씩 비교하며 탐색하는 것보다 **시간적으로 훨씬 효율적**이지만,  
각 노드에서 그 자식 노드에 대한 정보를 배열로 가지고 있고, 그 노드들의 개수를 생각해봤을 때 **공간 복잡도 측면에서는 비효율적**이다.

### Trie 활용

- 문자열 탐색
- 검색어 자동 완성
- 사전 찾기

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
네, 2개의 스택을 이용하여 구현할 수 있습니다. Enqueue 연산은 첫번째 스택에 원소를 추가하면 됩니다. Dequeue 연산은 두번째 스택을 이용합니다. 우선 두번째 스택이 비어있다면 첫번째 스택이 빌 때까지 첫번째 스택의 원소를 pop하고 두번째 스택에 push하는 것을 반복합니다. 그리고 두번째 스택이 비어있지 않다면 두번째 스택의 원소를 pop하면 됩니다.
</details>

<details>
<summary>큐로 스택을 구현할 수 있을까요?</summary>
네, 2개의 스택을 이용하여 구현할 수 있습니다. `Enqueue` 연산은 첫번째 스택에 원소를 추가하면 됩니다. `Dequeue` 연산은 두번째 스택을 이용합니다. 우선 두번째 스택이 비어있다면 첫번째 스택이 빌 때까지 첫번째 스택의 원소를 pop하고 두번째 스택에 push하는 것을 반복합니다. 그리고 두번째 스택이 비어있지 않다면 두번째 스택의 원소를 pop하면 됩니다.
</details>
