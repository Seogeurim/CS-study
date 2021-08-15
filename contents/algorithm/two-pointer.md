# 두 포인터 (two-pointer)

> 작성자 : [권혁진](https://github.com/KimKwon), [윤가영](https://github.com/yoongoing)

<details>
<summary>Table of Contents</summary>

- [최장 증가 부분수열 알고리즘](#최장-증가-부분수열-알고리즘)
- [최장 감소 부분수열 알고리즘](#최장-감소-부분수열-알고리즘)
- [투 포인터 알고리즘](#투-포인터-알고리즘)

</details>

---

## 최장 증가 부분수열 알고리즘

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 권혁진 | [최장증가부분수열 LIS](./materials/최장증가수열.pdf)

LIS 완전탐색 알고리즘 구현 ▶️ [lis_brute.cpp](./code/lis_brute.cpp)

LIS 동적계획법 알고리즘 구현 ▶️ [lis_dp.cpp](./code/lis_dp.cpp)

LIS 이분탐색 알고리즘 구현 ▶️ [lis_bs.cpp](./code/lis_bs.cpp)

---

## 최장 감소 부분수열 알고리즘

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 윤가영 | [최장감소부분수열 LDS & 두포인터](./materials/최장감소수열_두포인터.pdf)

LDS 이분탐색 알고리즘 구현 ▶️ [LDS_bs.cpp](./code/LDS_bs.cpp)

---

## 투 포인터 알고리즘

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 윤가영 | [최장감소부분수열 LDS & 두포인터](./materials/최장감소수열_두포인터.pdf)

투 포인터 알고리즘 구현 ▶️ [two_pointer.cpp](./code/two_pointer.cpp)

### 특징

- 배열이 정렬되어있다면 O(n)의 시간복잡도를 가지며, 그렇지 않을 경우 O(logn)의 복잡도를 가진다.
