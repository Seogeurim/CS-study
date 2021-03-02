# Basic Knowledge of Computer Science

> Since 2020.09.04

## Table of Contents

- [Basic Knowledge of Computer Science](#basic-knowledge-of-computer-science)
  - [Table of Contents](#table-of-contents)
  - [About](#about)
    - [Repository Rule](#repository-rule)
    - [Collaborator](#collaborator)
    - [Reference](#reference)
  - [Data Structure (자료구조)](#data-structure-자료구조)
    - [📖 정리노트](#-정리노트)
      - [기본 자료 구조](#기본-자료-구조)
      - [응용 자료 구조](#응용-자료-구조)
  - [Algorithm (알고리즘)](#algorithm-알고리즘)
    - [📖 정리노트](#-정리노트-1)
      - [알고리즘 기본](#알고리즘-기본)
      - [알고리즘 응용](#알고리즘-응용)
  - [Operating System (운영체제)](#operating-system-운영체제)
    - [📖 정리노트](#-정리노트-2)
  - [Database (데이터베이스)](#database-데이터베이스)
    - [📖 정리노트](#-정리노트-3)
  - [Network (네트워크)](#network-네트워크)
    - [📖 정리노트](#-정리노트-4)
  - [Design Pattern (디자인 패턴)](#design-pattern-디자인-패턴)
    - [📖 정리노트](#-정리노트-5)
  - [Software Engineering (소프트웨어 공학)](#software-engineering-소프트웨어-공학)
    - [📖 정리노트](#-정리노트-6)
  - [Language](#language)
    - [📖 정리노트](#-정리노트-7)

## About

컴퓨터 공학 전공자 및 예비 개발자로서 알아야 할 필수 전공 지식들을 정리한 저장소입니다. 더 나아가 기술 면접 준비까지를 목표로 합니다.

### Repository Rule

- **주제별 정리** : 자료 정리, 질의응답
- **Commit convention rule** : [대주제]-소주제-분류(자료정리/질의응답)  
  _ex) [DataStructure] Stack 자료정리_

### Collaborator

<a href="https://github.com/KimKwon">
  <img src="https://github.com/KimKwon.png" width="100">
</a>
<a href="https://github.com/Seogeurim">
  <img src="https://github.com/Seogeurim.png" width="100">
</a>
<a href="https://github.com/yoongoing">
  <img src="https://github.com/yoongoing.png" width="100">
</a>
<a href="https://github.com/3people">
  <img src="https://github.com/3people.png" width="100">
</a>
<a href="https://github.com/wntjq68">
  <img src="https://github.com/wntjq68.png" width="100">
</a>
<a href="https://github.com/Hee-Jae">
  <img src="https://github.com/Hee-Jae.png" width="100">
</a>

### Reference

- [JaeYeopHan/Interview_Question_for_Beginner](https://github.com/JaeYeopHan/Interview_Question_for_Beginner)
- [gyoogle/tech-interview-for-developer](https://github.com/gyoogle/tech-interview-for-developer)
- [WeareSoft/tech-interview](https://github.com/WeareSoft/tech-interview)
- [jobhope/TechnicalNote](https://github.com/jobhope/TechnicalNote)

## Data Structure (자료구조)

### [📖 정리노트](./contents/data-structure)

#### 기본 자료 구조

- Array
- Linked List
- Stack
- Queue
- Tree
- Binary Tree
- Graph
  
#### 응용 자료 구조

- Deque
- Heap & Priority Queue
- Indexed Tree (Segment Tree)
- Trie

[🔝 목차로 돌아가기](#table-of-contents)

## Algorithm (알고리즘)

### [📖 정리노트](./contents/algorithm)

#### 알고리즘 기본

- 시간복잡도와 공간복잡도
- 완전 탐색 알고리즘 (Brute Force)
  - DFS와 BFS
  - 순열, 조합, 부분집합
- 백트래킹 (Backtracking)
- 분할 정복법 (Divide and Conquer)
- 탐욕 알고리즘 (Greedy)
- 동적 계획법 (Dynamic Programming)

#### 알고리즘 응용

- 정렬 알고리즘
- 그래프
  - 최단 경로 알고리즘
  - Union Find & Kruskal
- 두 포인터 (two-pointer)
- 문자열 처리 알고리즘

[🔝 목차로 돌아가기](#table-of-contents)

## Operating System (운영체제)

### [📖 정리노트](./contents/operating-system)

- 프로세스와 스레드의 차이
- 스케줄러
- CPU 스케줄러
  - FCFS
  - SJF
  - SRT
  - Priority scheduling
  - RR
- 동기와 비동기의 차이
- 멀티스레드
- 프로세스 동기화
  - Critical Section
- 메모리 관리 전략
  - Paging
  - Segmentation
- 가상 메모리
  - Demand Paging (요구 페이징)
  - 페이지 교체 알고리즘
- [캐시](https://nukw0n-dev.tistory.com/9?category=877997)
  - Locality
  - Caching line

[🔝 목차로 돌아가기](#table-of-contents)

## Database (데이터베이스)

### [📖 정리노트](./contents/database)

- 데이터베이스
- 데이터베이스 성능
  - Index
- 정규화
- Transaction
- Statement vs PreparedStatement
- NoSQL
  - CAP 이론
  - 저장방식에 따른 분류
    - Key-Value Model
    - Document Model
    - Column Model

[🔝 목차로 돌아가기](#table-of-contents)

## Network (네트워크)

### [📖 정리노트](./contents/network)

- OSI 7 계층
- GET, POST 방식의 차이점
- TCP 3-way-handshake
- [TCP 와 UDP](https://nukw0n-dev.tistory.com/10)
- HTTP 와 HTTPS
- DNS round robin 방식
- 웹 통신의 큰 흐름

[🔝 목차로 돌아가기](#table-of-contents)

## Design Pattern (디자인 패턴)

### [📖 정리노트](./contents/design-pattern)

- 디자인 패턴의 개념과 종류
- Singleton 패턴

[🔝 목차로 돌아가기](#table-of-contents)

## Software Engineering (소프트웨어 공학)

### [📖 정리노트](./contents/software-engineering)

- 프로그래밍 패러다임
  - 명령형 프로그래밍 vs 선언형 프로그래밍
  - 함수형 프로그래밍
  - 객체지향 프로그래밍

[🔝 목차로 돌아가기](#table-of-contents)

## Language

### [📖 정리노트](./contents/language)

- Java
- C++

[🔝 목차로 돌아가기](#table-of-contents)
