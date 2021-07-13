# MVC (Model-View-Controller) 디자인 패턴

> 작성자 : [정희재](https://github.com/Hee-Jae)

본 자료는 '파이썬 디자인 패턴 2/e (Chetan Giridhar)' 책을 토대로 작성되었습니다. 따라서 모든 예시 코드에는 저자를 표시하는 `__author__ = 'Chetan'` 이 포함됩니다.

<details>
<summary>Table of Contents</summary>

- [컴파운드 패턴 개요](#컴파운드-패턴-개요)
- [MVC 패턴](#mvc-패턴)
- [MVC 구성요소 이해](#mvc-구성요소-이해)
- [MVC 패턴 예시 1](#mvc-패턴-예시-1)
- [MVC 패턴 예시 2](#mvc-패턴-예시-2)
- [MVC 패턴의 장점](#mvc-패턴의-장점)
- [자주 묻는 질문](#자주-묻는-질문)

</details>

---

## 컴파운드 패턴 개요

소프트웨어 개발에서는 하나의 디자인 패턴만을 사용하지 않고 여러 가지 패턴을 섞어 사용한다. 일반적으로 여러 패턴을 합쳐 목적을 달성한다. **GoF**에 따르면 **컴파운드 패턴**은 2개 이상의 패턴을 합쳐 문제를 해결하는 패턴이다. 하지만 **컴파운드 패턴**은 단순히 여러 패턴의 조합이 아닌 문제를 해결하는 독립적인 솔루션이다.

---

## MVC 패턴
**MVC 패턴**은 유저 인터페이스를 구현할 수 있는 유지보수가 용이한 디자인 패턴이다. **MVC 패턴**은 애플리케이션을 모델과 뷰, 컨트롤러로 나누어 구성한다. 각 파트는 맞물려 있으며 요청의 처리와 표현을 분리한다.

### MVC 패턴의 원리
**모델**은 데이터와 비즈니스 로직을 처리하고 **뷰**는 데이터의 시각적 표현을 담당하며 **컨트롤러**는 사용자의 요청에 따라 **모델**과 **뷰** 사이에서 요청을 처리한다. **뷰**와 **컨트롤러**는 **모델**에 의존하지만 그 반대는 아니다. 사용자가 데이터를 직접 요청하는 구조이기 때문이다. 이와 같은 **모델**의 독립성이 MVC 패턴의 중요한 부분이다.

### MVC 패턴의 전형적인 예시, 웹사이트 로직
1. 사용자는 뷰를 통해 요청을 보낸다. 뷰는 사용자에게 보여지는 웹사이트다. 뷰에 있는 버튼을 클릭하면 뷰는 컨트롤러에게 요청을 전달한다.
2. 컨트롤러는 뷰에 전달받은 인풋을 모델로 보낸다. 모델은 요청에 맞는 작업을 수행한다.
3. 컨트롤러는 사용자의 요청에 따라 버튼 교체 및 UI 추가 등을 뷰에 지시할 수 있다.
4. 모델은 뷰에 상태 변경을 알린다. 내부 로직 또는 버튼 클릭 등의 외부 트리거에 의한 상태 변경이다.
5. 뷰는 모델이 전달한 상태를 출력한다. 예를 들어 사용자가 웹사이트에 로그인하면 대시보드를 표시한다. 대시보드의 세부 내용은 모델이 뷰에 전달한다.

### MVC 패턴의 4가지 구성요소
1. 모델 : 데이터를 저장하고 조작하는 클래스
2. 뷰 : 유저 인터페이스와 데이터의 시각적 표현을 담당하는 클래스
3. 컨트롤러 : 모델과 뷰를 연결하는 클래스
4. 클라이언트 : 목적에 따라 정보를 요청하는 클래스

### 개발 관점에서 본 MVC 패턴의 메인 클래스
1. Model : 데이터의 생성과 수정, 소멸 등 데이터에 관한 모든 작업을 정의하고 데이터를 사용하는 메소드를 제공한다.
2. View : 유저 인터페이스를 담당한다. 애플리케이션에 필요한 웹이나 GUI를 생성하는 메소드를 포함한다. 전달받는 데이터를 시각적으로 표현하는 기능 외 개별적인 로직을 포함하지 않아야 한다.
3. Controller : 데이터를 받고 전달한다. 요청을 라우팅하는 메소드를 포함한다.

### MVC 패턴의 목적
1. 데이터 조작과 표현의 분리
2. 쉬운 유지보수와 구현
3. 유연한 데이터 저장과 표현 방식의 수정. 서로 독립적이므로 쉽게 수정할 수 있다.

---

## MVC 구성요소 이해

### 모델 - 애플리케이션의 뇌
- 모델은 뷰와 컨트롤러와는 독립적인 애플리케이션의 일부이다. 뷰와 컨트롤러는 모델에 의존적이다.  
- 모델은 사용자가 요청한 데이터를 제공한다. 일반적으로 모델은 데이터를 저장하고 반환하는 데이터베이스 테이블이다. 모델은 상태 정보와 상태를 변경하는 메소드를 포함하지만 데이터가 사용자에게 어떤 형태로 보여지는지 알지 못한다.  
- 모델은 반드시 여러 작업 간 일관성을 유지해야 한다. 그렇지 않으면 사용자는 일관성 없는 오래된 데이터를 전달 받는다.
- 모델은 완전히 독립적이므로 개발자는 뷰와 상관없이 모델 유지보수에 집중할 수 있다.

### 뷰 - 외모
- 뷰는 사용자가 인터페이스에서 보게 되는 데이터의 시각적 표현이다. 뷰를 독립적으로 작성할 수 있으나 복잡한 로직을 포함하면 안된다. 모든 로직은 컨트롤러나 모델에 포함되어야 한다.
- 특히 요즘처럼 데스크톱과 모바일 등의 여러 플랫폼과 다양한 화면 크기의 기기를 모두 지원하려면 뷰는 최대한 유연해야 한다.
- 뷰는 데이터베이스와 직접 통신하지 않고 원하는 정보를 얻기 위해 모델에 의존해야 한다.

### 컨트롤러 - 접착제
- 컨트롤러는 이름에서 짐작할 수 있듯이 사용자의 행동을 제어한다. 사용자가 인터페이스 내의 특정 요소를 클릭하면 행동(클릭 또는 터치)에 따라 컨트롤러는 모델을 호출해 데이터를 생성 또는 갱신, 삭제한다.
- 컨트롤러는 뷰에 데이터를 전달하고 뷰는 해당 데이터를 렌더링해 사용자에게 보여준다.
- 컨트롤러는 데이터베이스를 직접 호출하거나 데이터를 시각화하지 않는다. 컨트롤러는 모델과 뷰 사이에서 얇은 접착제 역할을 한다.

---

## MVC 패턴 예시 1
### 이메일, SMS, 음성 메시지를 제공하는 클라우드 서비스
#### Python
```python
__author__ = 'Chetan'
class Model(object):
    services = {
        'email': {'number': 1000, 'price': 2,},
        'sms': {'number': 1000, 'price': 10,},
        'voice': {'number': 1000, 'price': 15,},
    }

class View(object):
    def list_services(self, services):
        for svc in services:
            print(svc, ' ')

    def list_pricing(self, services):
        for svc in services:
            print("For" , Model.services[svc]['number'],
                    svc, "message you pay $",
                    Model.services[svc]['price'])

class Controller(object):
    def __init__(self):
        self.model = Model()
        self.view = View()

    def get_services(self):
        services = self.model.services.keys()
        return(self.view.list_services(services))

    def get_pricing(self):
        services = self.model.services.keys()
        return(self.view.list_pricing(services))

class Client(object):
    controller = Controller()
    print("Services Provided:")
    controller.get_services()

    print("Pricing for Services:")
    controller.get_pricing()
```

---

## MVC 패턴 예시 2
### 모든 클래스를 구현한 코드 예시
#### Python

```python
class Model(object):
    def logic(self):
        data = 'Got it!'
        print("Model: Crunching data as per business logic")
        return data

class View(object):
    def update(self, data):
        print("View: Updating the view with results: ", data)

class Controller(object):
    def __init__(self):
        self.model = Model()
        self.view = View()

    def interface(self):
        print("Controller: Relayed the Client asks")
        data = self.model.logic()
        self.view.update(data)

class Client(object):
    print("Client: asks for certain information")
    controller = Controller()
    controller.interface()
```

---

## MVC 패턴의 장점

1. MVC를 사용하면 애플리케이션을 모델과 뷰, 컨트롤러 총 3개의 파트로 나눌 수 있다. 이 구조는 유지보수가 쉽고 요소 간의 독립성이 높아져 복잡성이 줄어든다.
2. 백엔드 로직을 거의 건드리지 않고 독립적으로 프론트 엔드를 수정할 수 있다.
3. 모델이나 비즈니스 로직도 마찬가지로 뷰와 상관없이 수정될 수 있다.
4. 컨트롤러 또한 뷰와 모델과는 독립적으로 수정될 수 있다.
5. 플랫폼 개발자와 UI 개발자 같이 특정 분야의 전문가들이 독립적으로 일할 수 있는 환경을 제공한다.

---

## 자주 묻는 질문

1. MVC도 하나의 패턴인데 왜 컴파운드 패턴이라고 불리는가?
> 컴파운드 패턴은 더 큰 문제를 해결하기 위해 여러 패턴을 합친 것이다. MVC 패턴은 가장 많이 쓰이는 컴파운드 패턴이다. 안정적이며 많이 쓰이기 때문에 개별적인 패턴처럼 취급된다.
> <details>
> <summary> MVC에는 어떤 패턴들이 포함되어 있는가? </summary>
> <p>
> 출처 : https://sgc109.github.io/2020/07/18/compound-pattern-feat-mvc/  </br></br>
> MVC 는 Model-View-Controller 의 약자로서, 역할에 따라 3개의 컴포넌트로 분리하고 여러 디자인 패턴을 적용하여 재사용성을 높인 대표적인 컴파운드 패턴의 예다.  </br>
> 그렇다면 MVC 패턴에서 사용된다는 여러 디자인 패턴은 대체 무엇일까?  </br>
> 전통적인 MVC 패턴에서는 다음 3가지 패턴이 사용된다.  </br></br>
> - 옵저버(Observer) 패턴  </br>
> Model 의 상태가 변경 되었을 때 Controller, 혹은 View 에게 이 사실을 알리는데 사용된다.  </br>
> - 컴포지트(Composite) 패턴  </br>
> View 를 구성하는 컴포넌트들은 계층 구조를 이룬다. (e.g. Java Swing 의 JFrame/JLabel 등, Android 의 View/ViewGroup, HTML 의 DOM)  </br>
> - 스트래티지(Strategy) 패턴  </br>
> Controller 의 핵심 기능을 인터페이스로 분리하여 View 가 이 인터페이스를 통해 Controller 를 구성(Composition) 한다. 그렇기 때문에 View 는 Controller 를 갈아 끼우며 기능을 변경할 수 있다.  </br>
> - 또한, 필요에 따라 어댑터(Adapter) 패턴 을 함께 사용할 수도 있다.
> </p>
> </details>

2. MVC 웹사이트에서만 쓰이는가?
> 그렇지 않다. 웹사이트가 MVC를 설명하기 가장 좋은 예다. MVC 패턴은 GUI기반 애플리케이션이나 프로그램 내 요소 간의 높은 독립성이 요구되는 경우 적합하다. 블로그나 영화 데이터베이스 애플리케이션, 비디오 스트리밍 애플리케이션 등이 MVC가 적합한 전형적인 예다. 하지만 MVC가 아무리 좋다 해도 랜딩 페이지나 마케팅 콘텐츠, 단일 페이지 애플리케이션 등에 쓰는 것은 적합하지 않다.

3. 여러 개의 뷰와 모델을 사용해도 되는가?
> 물론이다. 여러 모델에서 데이터를 수집해 한 개의 뷰에 보여줘야 하는 경우가 자주 있다. 요즘 웹 어플리케이션에서는 일대일 매핑을 쓰는 경우가 흔치 않다.
