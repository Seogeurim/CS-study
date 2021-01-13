# Operating System (운영체제)

## 정리 자료

<!-- ex) 홍길동 : [자료명](./materials/자료명) -->

- 정희재 : 프로세스와 스레드, 스케줄러
- 장주섭 : 동기와 비동기의 차이 , 프로세스의 동기화
- 이세명 : Paging, Segmentation
- 서그림 : 가상 메모리
- 권혁진 : 캐시



## 프로세스와 스레드의 차이





## 스케줄러





## CPU 스케줄러





## 동기와 비동기의 차이

**Synchronous == Blocking ? Asynchronous == Non-blocking?** 

 결론 부터 말하자면 다르다. 

동기와 비동기 , Blocking 과 Non-blocking은 각각 관심을 갖는 부분이 다르다.

Sync & Async

> 동기와 비동기는 호출 되는 함수의 완료를 호출한 쪽에서 신경을 쓰냐 호출 받은 쪽에서 신경을 쓰냐의 차이다.

Blocking & Non-blocking

> Blocking  호출받은 쪽이 호출한 쪽에 제어권을 넘겨주지 않는 것이고 Non-blocking은 다시 제어권을 넘겨 주는 것이다.

네가지 조합 

|    Sync &  Blocking     |     Async & Blocking     |
| :---------------------: | :----------------------: |
| **Sync & Non-blocking** | **Async & Non-blocking** |

이 모든 경우의 수가 가능하다.

- Sync & Blocking

  가장 기본적으로 생각하는 Sync 이다. 함수를 호출하면 호출 받은 쪽에서 제어권을 가지고 있기 때문에 결과값이 반환 될때 까지 다음 동작을 시행 하지 않는다.

- Sync & Non-Blocking

  Non-Blocking 이라 함수가 완료 되지 않아도 제어권은 넘겨 주어 함수를 호출한 쪽에서 다음 동작을 시행 할 수는 있지만 함수가 완료되는 것을 신경을 써야하기 때문에 주기적으로 함수가 완료 되었는지 확인 해야한다.

- Async & Blocking

  잘 상상이 않가는 그림이다. 작업완료 여부를 호출된 쪽에서 신경 쓰고 제어권도 호출된 쪽에서 가지고 있다. 사실상 Sync & Blocking과 거의 같아 잘 사용되지 않는다.

- Async & Non-blocking 

  가장 기본적으로 생각하는 Async이다. 함수를 호출하면 제어권을 다시 호출 한쪽으로 넘겨주어 다음 동작을 이어 나가면서 호출 받은 쪽에서 알아서 콜백 함수의 결과를 리턴하여준다.

  

## 멀티 스레드





## 프로세스 동기화

### Critical Section(임계구역) 이란?

- 동일한 자원을 동시에 접근하는 작업을 실행하는 코드영역
- 멀티 쓰레딩의 문제점이 발생

Example

>```c
>Counter++;
>=>
>		LOAD register1 = counter
>	INCREASE register1 = register1 +1
>	STORE counter = register1
>Counter--;
>=>
>LOAD register2 = counter
>DECREASE register2 = counter -1
>STORE counter = register2
>```
>
>만약, counter = 5 라고 가정하고 counter++ 과 counter-- 를 서로다른 쓰레드에서 실행 시키면 실행 순서에 따라 4, 5 ,6 모두 결과 값으로 나올 수 있다.



### Ctritical Section Problem

 공통된 (data) 영역에 하나의 프로세스(task or thread) 만 들어 갈 수 있도록 설계하는 것. 이러한 설계를 위해서는 세가지 요구조건이 충족 되어야 한다.

1. Mutual Exclusion(상호배타)

> 어떠한 Task(Thread)가 Critical Section 을 사용중이면 다른 Task는 사용이 불가함.

2. Progress

> 현재 Critical Section 을 사용중인 Task가 없고 Critical Section에 들어가길 원하는 Task 가 있다면 바로 들여보냄

3. Bounded Waiting

> 한정된 대기시간을 가져야 한다 => 무한 대기 X



#### Hardware Solution

1. Memory Barriers
2. Compare & Swap
3. Atomic Variables. 



#### Software Solution

1. Mutex Lock (hardware-based)

> - Acquire() : Lock 획득
> - Release() : Lock 방출
>
> Task가 Crtical Section에 들어갈 때 acquire() 하고 나올 때 release() 하여 한 Task만 Critical Section 에 들어 갈 수 있게 한다. 
>
> => 화장실 칸 한개 열쇠 한개!
>
> ```c
> while(true){ 
>   acquire();
>   /* Critical Section*/
>   release();
>   /* Remainder Section*/
> }
> 
> acquire(){ // 사용가능 해지면 크리티컬 섹션에 들어간후 문을 잠금!
>   while(!available) // Busy Waiting
>     available = false; 
> }
> release(){ // 사용가능 하게 해줌
>   available = true;
> }
> ```
>
> 문제점 : Busy waiting(spin lock) 으로 인해 효율이 떨어진다.


2. Semaphores

> Wait 과 Signal을 이용하여 control 한다.
>
> Semaphore는 Critical Section에 들어갈 수 있는 task의 수이다. 자원의 갯수가 여러개라고 생각하는 것이 편하다. 따라서 Critical Section에 상호 배타적으로 들어 갈 수 있는 것이다.
>
> => 화장실(Critical Section)안에  칸(자원) n개 , 전광판에 n 표시
>
> Semaphore = 1 이면 Mutex Lock 과 같은 방식으로 움직인다.
>
> ```c
> Semaphore s // Integer Value & Positive #
> ```
>
> - Busy Waiting 을 사용하는 Semaphore
>
> ```c
> wait(s){
>   while(s <= 0){} // busy waiting
>   s--
> }
> signal(s){
>   s++
> }
> ```
>
> s 값이 양수여야지만 Critical Section에 들어가 작업을 수행 할 수 있음.
>
> Busy waiting을 사용하는 구현은 Critical Section 은 있지만 사용하고자 하는 Task의 수가 적을 때 사용함.
>
> - Busy Waiting 을 사용하지 않는 Semaphore
>
> ```c
> // waiting queue를 사용
> wait(s){
>   s--;
>   if(s < 0){ // s < 0 이면 s의 절댓값 만큼 waiting queue에서 Task 대기중
>     // waiting queue에 task t 를 집어넣음
>     block();
>   }
> }
> signal(s){
>   s++;
>   if(s <= 0){ // waiting queue에서 대기중인 task 존재
>     // waiting queue에서 task t 를 제거
>     wakeup(t);
>   }
> }
> ```

**Mutex Lock 과 Semaphore 의 차이!**

- Semaphore 는 Mutex Lock이 될 수 있지만 역은 성립하지 않는다.
- Semaphore 는 프로세스 범위에서 소유 불가능 , Mutex는 소유 가능

- Mutex Lock은 Lock을 갖고 있는 thread가 해제 가능한 반면, Semaphore는 외부에서도 해제 가능
- Semaphore 는 시스템 범위에 걸쳐져 있고 파일형태로 존재하는 반면, Mutex Lock은 프로세스 범위 내에 잇어서 종료시 자동으로 clean up 되어짐

3. Monitor

> 가장 발전된 기술, 이런게 있다는 것만 알고 있어도 되긴 하지만 궁금하다면, 
>
> Operating System Concepts 10th Edition(공룡책) 6장 내용을 참고하길 바람.



## 메모리 관리 전략





## 가상메모리





## 캐시





## 질의응답

> 아직 없습니다.
