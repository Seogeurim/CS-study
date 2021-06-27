# Algorithm (알고리즘)

## 알고리즘 기본 [▶︎ 🗒](basic.md)

- [시간복잡도와 공간복잡도](basic.md#시간복잡도와-공간복잡도)
- 완전 탐색 알고리즘 (Brute Force)
  - [DFS와 BFS](basic.md#dfs와-bfs)
  - [순열, 조합, 부분집합](basic.md#순열-조합-부분집합)
- 백트래킹 (Backtracking)
- 분할 정복법 (Divide and Conquer)
- 탐욕 알고리즘 (Greedy)
- 동적 계획법 (Dynamic Programming)

## 알고리즘 응용

- [정렬 알고리즘](sort.md) (Insertion / Selection / Bubble / Merge / Quick / Heap / Radix / Counting Sort)
- [그래프](graph.md)
  - [최단 경로 알고리즘](graph.md#최단-경로-알고리즘) (다익스트라, 벨만-포드, 플로이드-워셜)
  - [분리 집합(Union Find)과 크루스칼(Kruskal) 알고리즘](graph.md#분리-집합Union-Find과-크루스칼Kruskal-알고리즘)
- [두 포인터 (two-pointer)](two-pointer.md)
- [문자열 처리 알고리즘](string.md)
  - [KMP 알고리즘](string.md#문자열-패턴-매칭)

---

## 질의응답

<!-- 탐색 알고리즘 -->

<details>
<summary>질문을 작성해주세요.</summary>
<p>

답변을 작성해주세요.

</p>
</details>

<!-- 정렬 알고리즘 -->

<details>
<summary>라이브러리 없이 정렬을 구현하려고 할 때 어떤 정렬 방식을 사용해 구현할 것이고 왜 그렇게 생각하는지 성능 측면에서 얘기를 해주세요.</summary>
<p>

(예시 답안)
퀵소트로 구현할 것입니다. 퀵소트는 average case에서 nlgn의 시간복잡도를 가지며 공간복잡도 측면에서도 제자리 정렬이기 때문에 좋은 성능을 가집니다. worst case의 경우 n^2의 시간복잡도를 가지지만 worst case가 나타날 경우는 확률적으로 매우 낮습니다. (자료가 n개일 때 오름차순 또는 내림차순 -> 2/n!)

</p>
</details>

<details>
<summary>퀵소트에서 최악의 경우 시간복잡도를 개선시킬 수 있는 방법이 있을까요?</summary>
<p>

피벗의 위치를 다르게 설정함으로써 시간복잡도를 개선시킬 수 있습니다. 일정한 위치에 대해서만(ex. 첫번째 element) 피벗을 설정하는 것보다 첫번째, 마지막 element 중 무작위로 선택한다거나 첫번째, 가운데, 마지막 element 중 중간값을 계산하여 피벗을 설정했을 때 시간복잡도를 더 개선시킬 수 있습니다.

</p>
</details>

<details>
<summary>머지소트의 분할 정복 과정에 대해 단계별로 설명해주세요.</summary>
<p>

- Divide : 초기 배열을 2개의 배열로 분할
- Conquer : 각 부분 배열을 정렬
- Combine : 부분 배열을 하나의 배열로 결합

</p>
</details>

<!-- MST -->

<!-- 최단 경로 -->
