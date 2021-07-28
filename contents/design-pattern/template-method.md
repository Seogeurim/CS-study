# 템플릿 메소드 패턴

> 작성자 : [정희재](https://github.com/Hee-Jae)

본 자료는 '파이썬 디자인 패턴 2/e (Chetan Giridhar)' 책을 토대로 작성되었습니다. 따라서 모든 예시 코드에는 저자를 표시하는 `__author__ = 'Chetan'` 이 포함됩니다.

<details>
<summary>Table of Contents</summary>

- [템플릿 메소드 패턴 개요](#템플릿-메소드-패턴-개요)
- [템플릿 메소드 패턴의 구성요소](#템플릿-메소드-패턴의-구성요소)
- [템플릿 메소드 패턴 구현 코드](#템플릿-메소드-패턴-구현-코드)
- [템플릿 메소드 패턴 예시 (iOS 컴파일러)](#템플릿-메소드-패턴-예시-ios-컴파일러)
- [템플릿 메소드 패턴 – 후크](#템플릿-메소드-패턴-후크)
- [할리우드 원칙과 템플릿 메소드](#할리우드-원칙과-템플릿-메소드)
- [템플릿 메소드 패턴의 장단점](#템플릿-메소드-패턴의-장단점)
- [자주 묻는 질문](#자주-묻는-질문)

</details>

---

## 템플릿 메소드 패턴 개요

행동 패턴에서는 각 객체의 역할이 중요하다. 객체는 상호 작용을 통해 더 큰 긴능을 구현할 수 있다. **템플릿 메소드 패턴**은 행동 패턴의 한 종류로 애플리케이션의 뼈대나 핵심 알고리즘을 `Template Method`라는 곳에 정의한다. 템플릿 메소드 패턴은 알고리즘의 일부 단계를 서브클래스화해 알고리즘의 부분적 수정 및 재정의를 쉽게 한다. 즉 서브클래스를 자유롭게 재정의할 수 있다.


### 템플릿 메소드 패턴은 다음과 같은 상황에 적합하다.
1. 여러 알고리즘 또는 클래스의 구조나 로직이 비슷할 때
2. 알고리즘을 단계별로 서브클래스화해 코드의 중복을 줄일 수 있는 경우
3. 서브클래스를 오버라이드해 여러 알고리즘을 구현할 수 있는 경우


### 템플릿 매소드 패턴의 목적
1. 알고리즘의 뼈대를 원시 연산으로 구현
2. 알고리즘의 구조를 수정하지 않고 일부 서브클래스를 재정의
3. 코드의 재사용과 중복 최소화
4. 공통 인터페이스 및 구현 활용

---
### 템플릿 메소드 패턴의 구성요소
#### 1. AbstractClass
- **알고리즘의 단계를 정의하는 인터페이스**
- 알고리즘의 각 단계를 정의하는 추상 메소드로 구성되어 있다.
- `ConcreteClass`에서 오버라이드한다.
#### 2. ConcreteClass
- **단계별 서브클래스**
- 여러 추상 메소드로 구성된 알고리즘의 서브클래스를 구현한다.
#### 3. template_method()
- **단계별 메소드를 호출하는 알고리즘 정의**
- 알고리즘의 뼈대를 정의한다.
- 전체 알고리즘을 정의하는 여러 추상 메소드를 호출한다.

### 템플릿 메소드 패턴 구현 코드
```python
__author__ = 'Chetan'

from abc import ABCMeta, abstractmethod

# 알고리즘의 인터페이스 정의
class AbstractClass(metaclass=ABCMeta):
    def __init__(self):
        pass

    @abstractmethod
    def operation1(self):
        pass

    @abstractmethod
    def operation2(self):
        pass
    
    # 단계별 메소드를 호출하여 알고리즘 뼈대 정의
    def template_method(self):
        print("Defining the Algorithm. Operation1 follows Operation2")
        self.operation2()
        self.operation1()

# 인터페이스를 오버라이드하여 서브클래스 구현
class ConcreteClass(AbstractClass):

    def operation1(self):
        print("My Concrete Operation1")

    def operation2(self):
        print("Operation 2 remains same")

# 사용 예시
class Client:
    def main(self):
        self.concreate = ConcreteClass()
        self.concreate.template_method()

client = Client()
client.main()
```

### 템플릿 메소드 패턴 예시 (iOS 컴파일러)
```python
__author__ = 'Chetan'

from abc import  ABCMeta, abstractmethod

# 컴파일러 알고리즘 인터페이스
class Compiler(metaclass=ABCMeta):

    # 소스 수집
    @abstractmethod
    def collectSource(self):
        pass

    # 객체로 컴파일
    @abstractmethod
    def compileToObject(self):
        pass

    # 실행
    @abstractmethod
    def run(self):
        pass

    # 단계별 메소드를 호출하여 컴파일 과정 설계
    def compileAndRun(self):
        self.collectSource()
        self.compileToObject()
        self.run()

# 인터페이스를 오버라이드하여 알고리즘 구체화
class iOSCompiler(Compiler):
    def collectSource(self):
        print("Collecting Swift Source Code")

    def compileToObject(self):
        print("Compiling Swift code to LLVM bitcode")

    def run(self):
        print("Program runing on runtime environment")

# 사용 예시
iOS = iOSCompiler()
iOS.compileAndRun()
```

---
### 템플릿 메소드 패턴 – 후크
**후크**는 추상 클래스(`AbstactClass`)에 정의되는 메소드다. 일반적으로 기본 구현을 포함하여 정의된다. **후크**는 서브클래스가 알고리즘 중간 단계를 제어할 수 있는 기능을 제공한다. 예를 들어 앞서 다룬 [iOS 컴파일러](#템플릿-메소드-패턴-예시-ios-컴파일러) 예제에서 `run()` 메소드 실행 전에 유저에게 실행 여부를 확인하는 간단한 **후크**를 추가할 수 있다. 다만 서브클래스는 **후크**를 꼭 사용하지 않아도 된다. 서브클래스는 추상 메소드를 반드시 구현하여 구체화 해야하지만 **후크**는 선택적으로 구현할 수 있다.

### 할리우드 원칙과 템플릿 메소드
할리우드 원칙은 `“먼저 연락하지 마세요. 저희가 연락 드리겠습니다.”` 에 기반하는 디자인 철학이다. 할리우드 영화 제작사에서 배우가 필요할 때 제작사가 배우에게 연락하는 것에서 비롯된 원칙이다. **상위 요소가 언제 어떤 하위 요소가 필요한지 결정한다.** 즉 상위 요소가 하위 요소에 대한 접근 및 필요성을 직접 결정하는 개념이다. **템플릿 메소드 패턴에서는 상위 추상 클래스가 알고리즘에 필요한 단계를 정리한다.** 알고리즘에 따라 각 단계에 맞는 하위 클래스가 호출된다.



---
### 템플릿 메소드 패턴의 장단점

#### 장점
1. 코드 중복이 없다.
2. 컴포지션이 아닌 상속을 사용하므로 코드를 재활용할 수 있다. 일부의 함수만 오버라이드하면 된다.
3. 알고리즘의 각 단계를 서브클래스에서 구현할 수 있는 유연성을 제공한다.

#### 단점
1. 코드 디버깅 및 이해가 어려울 수 있다. 추상 메소드에 구현되지 않은 메소드를 구현하거나 추상 메소드를 아예 구현하지 않는 실수를 저지를 수 있다. 에러 핸들링과 문서화가 필수적이다.
2. 어떤 계층의 클래스(상위 및 하위 클래스)를 수정한다면 전체 구조 및 구현에 영향을 줄 수 있어 유지 보수가 어렵다.

---
### 자주 묻는 질문
**1. 하위 클래스가 상위 클래스를 호출하는 것을 막아야 하는가?**
아니다. 하위 클래스는 상속을 통해 상위 클래스를 호출할 수 있어야 한다. 하지만 프로그래머는 상하위 클래스가 서로 의존하는 순환 종속성이 없도록 주의해야 한다.

**2. 전략 패턴과 템플릿 패턴의 차이점은 무엇인가?**
두 패턴 모두 알고리즘을 캡슐화한다. 하지만 템플릿 패턴은 상속을 사용하는 반면에 전략 패턴은 컴포지션을 사용한다. 템플릿 메소드 패턴은 서브클래스를 사용해 컴파일 단계에서 알고리즘을 선택하지만 전략 패턴은 런타임에 선택한다.


