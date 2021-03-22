# Operating System (운영체제)

> 작성자 : [권혁진](https://github.com/KimKwon), [이세명](https://github.com/3people), [장주섭](https://github.com/wntjq68)

<details>
<summary>Table of Contents</summary>

- [프로세스와 스레드](#프로세스와-스레드)
- [스케줄러](#스케줄러)
- [CPU 스케줄러](#CPU-스케줄러)
- [동기와 비동기의 차이](#동기와-비동기의-차이)
- [프로세스 동기화](#프로세스-동기화)
- [메모리 관리 전략](#메모리-관리-전략)
- [가상 메모리](#가상-메모리)
- [캐시](#캐시)

</details>

---

## 프로세스와 스레드

## 스케줄러

## CPU 스케줄러

---

## 동기와 비동기의 차이

**Synchronous == Blocking ? Asynchronous == Non-blocking?**

결론 부터 말하자면 다르다.

동기와 비동기, Blocking 과 Non-blocking은 각각 관심을 갖는 부분이 다르다.

Sync & Async

> 동기와 비동기는 호출 되는 함수의 완료를 호출한 쪽에서 신경을 쓰냐 호출 받은 쪽에서 신경을 쓰냐의 차이다.

Blocking & Non-blocking

> Blocking 호출받은 쪽이 호출한 쪽에 제어권을 넘겨주지 않는 것이고 Non-blocking은 다시 제어권을 넘겨 주는 것이다.

네가지 조합

|     Sync & Blocking     |     Async & Blocking     |
| :---------------------: | :----------------------: |
| **Sync & Non-blocking** | **Async & Non-blocking** |

이 모든 경우의 수가 가능하다.

- Sync & Blocking

  가장 기본적으로 생각하는 Sync 이다. 함수를 호출하면 호출 받은 쪽에서 제어권을 가지고 있기 때문에 결과값이 반환 될때 까지 다음 동작을 시행 하지 않는다.

- Sync & Non-Blocking

  Non-Blocking 이라 함수가 완료 되지 않아도 제어권은 넘겨 주어 함수를 호출한 쪽에서 다음 동작을 시행 할 수는 있지만 함수가 완료되는 것을 신경을 써야하기 때문에 주기적으로 함수가 완료 되었는지 확인 해야한다.

- Async & Blocking

  잘 상상이 안 가는 그림이다. 작업완료 여부를 호출된 쪽에서 신경 쓰고 제어권도 호출된 쪽에서 가지고 있다. 사실상 Sync & Blocking과 거의 같아 잘 사용되지 않는다.

- Async & Non-blocking

  가장 기본적으로 생각하는 Async이다. 함수를 호출하면 제어권을 다시 호출 한쪽으로 넘겨주어 다음 동작을 이어 나가면서 호출 받은 쪽에서 알아서 콜백 함수의 결과를 리턴하여준다.

---

## 프로세스 동기화

### Critical Section(임계구역) 이란?

- 동일한 자원을 동시에 접근하는 작업을 실행하는 코드영역
- 멀티 쓰레딩의 문제점이 발생

Example

> ```c
> Counter++;
> =>
> LOAD register1 = counter
> INCREASE register1 = register1 +1
> STORE counter = register1
> Counter--;
> =>
> LOAD register2 = counter
> DECREASE register2 = counter -1
> STORE counter = register2
> ```
>
> 만약, counter = 5 라고 가정하고 counter++ 과 counter-- 를 서로다른 쓰레드에서 실행 시키면 실행 순서에 따라 4, 5 ,6 모두 결과 값으로 나올 수 있다.

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
> => 화장실(Critical Section)안에 칸(자원) n개 , 전광판에 n 표시
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

---

## 메모리 관리 전략

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 이세명 | [Paging, Segmentation](./materials/이세명_operating-system_memory-management.pdf)

---

## 가상 메모리

---

## 캐시

아래의 자료에서 자세한 설명과 코드를 볼 수 있다.

- 작성자 권혁진 | [[CS] 캐시 메모리](https://nukw0n-dev.tistory.com/9)

---

## 질의응답



<details>
<summary>프로그램과 프로세스의 차이에 대하여 설명해보세요.</summary>
<p>
  
**프로그램**: 작업을 위해 실행할 수 있는 파일의 단위를 의미함.

**프로세스**: 메모리에 적재되어 ```CPU```를 할당받아 실행중인 프로그램을 프로세스라 일컫음.

</p>
</details>

<details>
<summary>프로그램이 실행중이라는게 어떤상태를 말하나요?</ummary>
<p>
  
```메모리에 적재되어 CPU를 할당```받아 실행중인 프로그램을 실행중인 프로그램 이라고함.

</p>
</details>

<details>
<summary>프로세스가 도중에 중지되는 경우, 그 원인과 다시 실행할 수 있는 방법은 무엇일까요?</summary>
<p>
  
```인터럽트``` 혹은 ``시스템 콜`` 등에 의해 프로세스가 중지될 수 있다.

PCB안에 해당 프로세스의 정보(프로그램카운터와 같은 실행정보 등)가 저장되어 있기 때문에 추후에 실행가능한 상태가 되면 PCB를 통해 다시 실행할 수 있다. 
</p>
</details>

<details>
<summary>프로세스에 힙 또는 스텍영역이 있는데, 이중에서 힙 또는 스택영역에는 어떤 정보가 있나요?</summary>
<p>
  
**힙 영역**: 동적 할당되는 모든 요소들

**스택 영역**: 매개변수, 로컬변수, 복귀주소
</p>
</details>


<details>
<summary>스레드와 멀티 스레드의 차이에 대하여 설명하고, 멀티 스레드의 장단점을 설명해보세요.</summary>
<p>  

**스레드**는 할당받은 자원을 이용한 프로세스의 실행 흐름의 단위이다. 
  
`멀티 스레드`는 한 프로세스 내에서 이러한 스레드가 여러개 동작하는 방식을 의미한다.

스레드는 프로세스 내에서 스택을 제외한 영역을 같은 프로세스 내의 스레드들과 공유한다. 

즉 자원을 공유한다는 것인데, 이는 스레드간 `자원 동기화 관련 문제`를 유발한다. 

또한 프로세스가 종료되면 내부 스레드들 역시 모두 종료되므로 한 스레드가 프로세스를 의도치않게 종료했을 경우 나머지 스레드들도 모두 종료 될 수 있다는 단점이 있다.

반면 프로세스를 여러개 두는 방식에 비해 멀티스레드 방식은` 컨텍스트 스위칭 비용이 적게 들며 응답시간 역시 빠르다`는 장점이 있다.
</p>
</details>

<details>
<summary>멀티 스레드와 멀티 프로세스의 차이를 말해주세요.</summary>
<p>  

**멀티 스레드** : 적은 메모리 공간 차지, context switch 빠름. 하지만, 동기화 문제가 있고 하나의 스레드가 종료되면 전체 스레드가 종료될 수 있음.

**멀티 프로세스** : 하나의 프로세스가 죽더라도 다른 프로세스에는 영향을 끼치지 않음. 하지만, 많은 메모리 공간을 차지하고 CPU시간을 많이 차지함.
</p>
</details>


<details>
<summary>스택을 스레드마다 독립적으로 할당하는 이유가 무엇인가요?</summary>
<p>  
  
각 스레드가 독립적인 실행 흐름단위를 가진다는 것에서 유추 할 수 있다.

스레드가 독립적인 실행흐름을 갖기위해서는 `독립적인 함수호출이 보장`되어야하기 때문이다.
</p>
</details>

<details>
<summary>커널 스레드에 대하여 설명해보세요.</summary>

</details>

<details>
<summary>Context Switching에 대하여 설명해보세요.</summary>
<p>
  
위에서 말했듯이 프로세스는 CPU를 할당받은 상태의 프로그램이다.
  
현재 CPU를 할당받아 실행중인 프로세스 A와 대기중인 프로세스 B가 있다고 가정했을 때,

A 프로세스에서 B 프로세스로 CPU 사용/제어권이 이전되는 것을 `Context Switching` 이라고한다.
</p>
</details>

<details>
<summary>스케쥴링이 왜 필요한가요?</summary>
<p>
  
한정적인 메모리(자원)를 효율적으로 관히하기 위해, 공정성을 주기 위해 필요하다.
</p>
</details>

<details>
<summary>스케줄러와 CPU 스케줄러의 차이에 대하여 설명해보세요.</summary>
<p>
  
스케줄러(=Job Scehduler, 장기 스케줄러)는 디스크와 메모리 간 스케줄링을 담당한다.
  
CPU 스케쥴러(= 단기 스케줄러)는 메모리와 CPU 간 스케줄링을 담당한다.  
</p>
</details>

<details>
<summary>스케줄러의 종류에 대하여 설명해보세요.</summary>

</details>

<details>
<summary>CPU 스케줄러의 종류에 대하여 설명해보세요.</summary>

</details>

<details>
<summary>중기 스케쥴러에서 suspended상태와 blocked상태의 다른점은 무엇인가요?</summary>
<p>
  
blocked 상태는 다른 I/O 작업을 기다리는 상태이기 때문에 스스로 ready queue로 돌아갈수 있지만, suspended는 외부적인 이유로 유예됐기 때문에 스스로 돌아갈 수 없다.
</p>
</details>

<details>
<summary>FCFS 스케줄링을 개선한 스케줄링 방식에 대하여 설명해보세요.</summary>
<p>
  
FCFS는 먼저 도착한 프로세스에게 CPU를 할당하는 기법이다. 
  
하지만 먼저 도착한 프로세스가 실행 시간이 긴 경우 나중에 도착한 프로세스들의 대기 시간이 길어지는 ```Convoy Effect``` 라는 문제점을 가지고 있다.

이를 개선한 `SJF(Shortest Job First)` 기법이 있다.

SJF는 짧은 실행시간을 갖는 프로세스에게 CPU를 먼저 할당하는 기법이다. 

Convoy Effect는 해결하였지만, 실행시간이 긴 프로세스는 계속 CPU를 할당받지 못하는 `Starvation 현상`이 일어날 수 있다.
</p>
</details>

<details>
<summary>Round Robin 스케줄링 방식에서 time quantum 설정에 따른 결과를 설명해보세요.</summary>
<p>

RR 기법에서 

 - 타임퀀텀이 긴 경우: 타임퀀텀이 프로세스의 실행시간과 비슷해진다면 FCFS랑 다를 바 없어진다.
  
 - 타임퀀텀이 짧은 경우: 타임퀀텀이 짧아 Context Switching이 자주 일어나게 되어 오버헤드가 발생한다.
</p>
</details>

<summary>오버헤드가 어떤건가요?</summary>
<p>

프로그램의 실행흐름 도중에 동떨어진 위치의 코드를 실행시켜야 할 때 , 추가적으로 시간,메모리,자원이 사용되는 현상을 오버헤드라 한다.

</p>
</details>
