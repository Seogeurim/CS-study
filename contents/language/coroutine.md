# Coroutine

> 작성자 : [박재용](https://github.com/ggjae)

본 자료는 작성자인 '박재용'의 팀 Repository의 글과 유니티 교과서 책을 재구성하여 작성되었습니다. 다양한 언어(javascript, C++, Kotlin, C#)에서 코루틴을 사용하지만 예제는 C#에 국한된 설명으로 코루틴에 대한 이해를 도와줍니다.

<details>
<summary>Table of Contents</summary>

- [What is Coroutine](#Coroutine이란?)
- [코루틴이 언제 쓰이는데?](#Coroutine이-언제-쓰이는데)
- [코루틴이 주는 이점](#코루틴이-주는-이점)

</details>

---

## Coroutine이란?

코루틴(Coroutine)은 Cooperative routine을 의미하며 서로 협력하는 루틴이라는 뜻이다. 메인 루틴과 서브 루틴처럼 종속된 관계가 아닌 서로 대등한 관계이다. 글을 전부 정독한 후 다시 올라왔을 때는 충분히 이해가 될 것이다.

![image](https://user-images.githubusercontent.com/22047551/128828164-fbf664c0-600c-42c7-b832-9f1b35c88709.png)


## Coroutine이 언제 쓰이는데?

직접 누구나 이해할 수 있는 코드로 예시를 들어보겠다.  
예시1)
```cs
void start(){
    startA();
    startB();
}
void startA(){
    for(int a=0;a<10;a++){
        Debug.Log("a");
    }
}
void startB(){
    for(int b=0;b<5;b++){
        Debug.Log("b");
    }
}
```
프로그램은 startA의 a가 열번, startB의 b가 다섯번 출력될 것이다.

위와는 다르게 **동시에 일어나는 것처럼 프로그램을 구현**하고 싶거나 **약속된 신호를 줬을 때 시작하는 비동기를 구현**할 때 코루틴을 사용한다.

예시2)   
코루틴의 공식문서에서는 한 오브젝트의 투명도를 완전히 투명해질 때까지 Fadeout시킬 때 코루틴을 사용하지 않으면 중간값은 시각적으로 알 수 없고 순간적으로 투명해지므로 코루틴을 이용하여 투명도를 설정할 것을 권장하고 있다. 아래 코드는 순식간에 투명도가 0으로 변해버린다.
```cs
void Fade() {
    for (float f = 1f; f >= 0; f -= 0.1f) {
        Color c = renderer.material.color;
        c.a = f;
        renderer.material.color = c;
    }
}
```

아래 코드는 코루틴을 적용시킨 코드이다. 정해진 시간이나 프레임마다 투명도를 서서히 줄게 자신이 속도를 컨트롤할 수 있게 된다.
```cs
IEnumerator Fade() {
    for (float f = 1f; f >= 0; f -= 0.1f) {
        Color c = renderer.material.color;
        c.a = f;
        renderer.material.color = c;
        yield return null;
    }
}
```

## 코루틴이 주는 이점

결론만 말하자면 코루틴을 협력형 멀티태스킹(cooperative multitasking)을 구현하는 용도로 사용하기 때문에 코루틴이 주는 이점이 많다고 이야기 할 수 있다.

**협력형 멀티태스킹**은 일종의 **시분할 - time sharing** 방식으로 여러 task가 하나의 CPU를 나눠쓰는 방식인데 운영체제의 개입 없이 각 task가 **독점적으로 CPU를 사용하고 사용이 끝나면 자발적으로 양보**하게 된다. 리소스를 사용하는 도중 강제로 CPU를 선점해가는 일이 없으므로 크리티컬 섹션을 보호하기 위한 동기화 수단이 필요 없다는것이 가장 큰 이점이다.

---

## 코루틴과 일반함수의 차이점

일반적인 함수의 진입점은 함수의 시작 부분이다. 함수를 호출하게 되면 함수의 시작 부분부터 return이나 함수의 끝까지 실행을 한 후 함수를 종료한다. Coroutine은 여러개의 진입점과 여러개의 중단점을 가져 루틴이 종료되기 전에 몇번이든 진입과 중단이 가능하다.

또한 위에서 언급한 것과 같이 함수는 return을 사용하지만 코루틴은 suspend(중단)을 사용하여 힙 메모리 영역에 다시 resume(재개)하기 위해 필요한 모든 정보를 저장하고 제어권을 호출자에게 다시 넘기게 된다.

## 코루틴과 스레드의 차이점

Background Task라는 점과 **비동기**로 일어나는 것처럼 보이는 부분에서는 공통점이 있어 보이지만 개념이 다르다. 코루틴은 특정 작업을 단계적으로 쪼개어 순차적으로 발생하게 만들고 메인 루틴과 **동시에 발생하지 않는다**는 큰 특징을 가지고 있다. 또한 가장 큰 차이점은 실제로 코루틴은 **병렬적으로 수행**되는 것이 아닌 **작업을 잘게 쪼개서 동시에 일어나는것처럼 보이게하는 멀티태스킹**과 비슷한 방법을 사용한다. 하지만 스레드의 경우는 **병렬 처리**를 중심으로 **하나의 프로그램에서 동시에 많은 일을 처리하게 된다.** 아래의 사진에서 더 이해를 도와줄것이다.

![image](https://user-images.githubusercontent.com/22047551/129317126-ef247969-807b-4034-8c60-9b14b3a3e327.png) 

## Coroutine의 사용 방법

StartCoroutine(함수이름())으로 사용할 수 있다.
위의 코드에 StartCoroutine을 아래의 코드처럼 적용시킬 수 있다.

> C#
```cs
void start(){
    StartCoroutine(startA());
    StartCoroutine(startB());
}
IEnumerator startA(){
    for(int a=0;a<10;a++){
        Debug.Log("a");
        yield return null;
    }
}
IEnumerator startB(){
    for(int b=0;b<5;b++){
        Debug.Log("b");
        yield return null;
    }
}
```

## IEnumerator란?

데이터의 목록을 하나씩 넘겨줄 때 사용되는 인터페이스로, 코루틴은 호출한 함수와 서로 상호작용하며 진행하도록 설계되어 있다. 호출한 함수에게 데이터를 넘겨주고 쉰 후 데이터를 받아야 할 때 쉬고 있던 코루틴이 일어나서 다시 데이터를 받고, 넘겨주는 반복하는 구조로 동작하게 된다.

## yield란?
프로그래밍 언어마다 해석의 차이점이 있을 수 있지만 C#의 yield 키워드는 호출자(Caller)에게 컬렉션 데이타를 하나씩 리턴할 때 사용한다. 
흔히 Enumerator(Iterator)라고 불리우는 이러한 기능은 집합적인 데이터셋으로부터 데이타를 하나씩 호출자에게 보내주는 역할을 한다. C++의 iterator(반복자)와 같은 개념이다.

## 다양한 yield return type

- yield return null
> 다음 프레임까지 대기

- yield return new WaitForSeconds(time)
> time초 만큼 대기

- yield return new WaitForFixedUpdate()
> 다음 FixedUpdate까지 대기

- yield return StartCoroutine(string name)
> 다른 코루틴이 중단될때까지 대기
