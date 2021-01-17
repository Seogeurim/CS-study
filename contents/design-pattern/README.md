# Design Pattern (디자인 패턴)

> 작성자 : [정희재](https://github.com/Hee-Jae)

본 자료는 '파이썬 디자인 패턴 2/e (Chetan Giridhar)' 책을 토대로 작성되었습니다. 따라서 모든 예시 코드에는 저자를 표시하는 `__author__ = 'Chetan'` 이 포함됩니다.

디자인 패턴(Design Pattern)은 **소프트웨어 설계의 효율성을 높이는 최선의 해결책** 중 하나다. 소프트웨어 최적화에 대한 관심이 높아지면서 소프트웨어 아키텍트는 객체 생성과 코드 구조, 객체 간의 상호작용 등을 반드시 설계 단계부터 생각해야 한다. 디자인 패턴을 잘 활용하면 소프트웨어 **유지보수 비용이 줄어들고 코드 재사용성이 증가하며** 쉽게 확장할 수 있는 구조가 될 것이다. 재사용할 수 있는 모듈간 독립적인 프레임워크를 제공하는 일이 현대 소프트웨어 개발의 핵심이다.

## 싱글톤 (Singleton)

싱글톤 디자인 패턴은 글로벌하게 접근 가능한 단 한 개의 객체만을 허용하는 패턴이다.

### 싱글톤 디자인 패턴의 목적
- 클래스에 대한 단일 객체 생성
- 전역 객체 제공
- 공유된 리소스에 대한 동시 접근 제어

### 싱글톤 패턴 구현

#### Python
```python
__author__ = 'Chetan'

class Singleton(object):
    def __new__(cls):
      if not hasattr(cls, 'instance'):
        cls.instance = super(Singleton, cls).__new__(cls)
      print(cls.instance)
      return cls.instance
```
- 한 개의 instance 클래스 인스턴스를 생성한다.
- 이미 생성된 인스턴스가 있다면 재사용한다.

### 게으른 초기화
인스턴스가 꼭 필요한 상황일 때 초기화를 한다. 사용할 수 있는 리소스가 제한적일 때 사용하는 방식이다.

```python
__author__ = 'Chetan'   

class Singleton:

    __instance = None
    
    def __init__(self):
        if not Singleton.__instance:
            print(" __init__ method called..")
        else:
            print("Instance already created:", self.getInstance())
    
    @classmethod
    def getInstance(cls):
        if not cls.__instance:
            cls.__instance = Singleton()
        return cls.__instance

s = Singleton()
## 클래스는 초기화 되었지만 아직 객체는 생성되지 않았다.
print("Object created", Singleton.getInstance())
## 객체를 생성했다.
s1 = Singleton()
## 객체는 이미 생성되었다.

''' <실행 결과>
__init__ method called..
 __init__ method called..
Object created <__main__.Singleton object at 0x10ca025c0>
Instance already created: <__main__.Singleton object at 0x10ca025c0>
'''
```

- getInstance()로 얻어오는 주소가 일치하는 것을 볼 수 있다.

### 모듈 싱글톤

파이썬에서 모든 모듈은 기본적으로 싱글톤이다. 한 개의 객체만 유지하고 반환하는 싱글톤 방식이다. 파이썬의 모듈 임포트 방식은 다음과 같다.

- 파이썬 모듈이 임포트됐는지 확인한다.
- 임포트 됐다면 해당 객체를 반환한다.
- 임포트되지 않았다면 임포트하고 인스턴스화 한다.
- 모듈은 임포트와 동시에 초기화된다. 하지만 같은 모듈을 다시 임포트하면 초기화하지 않는다.

```python
import sys
import sys
```
이처럼 같은 모듈을 중복해서 임포트해도 sys객체는 하나만 생성된다.

### 모노스테이트 싱글톤 패턴
싱글톤 패턴과 달리 두 개 이상의 객체가 생성될 수 있지만 모든 객체가 상태를 공유한다.

### 모노스테이트 싱글톤 예시
```python
__author__ = 'Chetan'   

class Borg:
    __shared_state = {}
    def __init__(self):
        self.x = 1
        self.__dict__ = self.__shared_state
        pass

b = Borg()
b1 = Borg()
b.x = 3

print("Borg Object 'b': ", b)
print("Borg Object 'b1': ", b1)
## b와 b1은 서로 다른 객체다.
print("Object State 'b':", b.__dict__)
print("Object State 'b1':", b1.__dict__)
## 그러나 서로 state를 공유한다.

''' <실행 결과>
Borg Object 'b':  <__main__.Borg object at 0x10d6d95c0>
Borg Object 'b1':  <__main__.Borg object at 0x10d6d95f8>
Object State 'b': {'x': 3}
Object State 'b1': {'x': 3}
'''
```

### 싱글톤과 메타클래스

메타클래스는 클래스의 클래스다. 즉 클래스는 자신의 메타클래스의 인스턴스다. 클래스는 메타클래스가 정의한다. 


**class A** 구문으로 클래스를 생성하면 파이썬은 **A = type(name, bases, dict)** 를 실행한다. 이미 정의된 메타클래스가 있다면 파이썬은 **A = MetaKls(name, bases, dict)** 를 실행해 클래스를 생성한다.

- `name` :  클래스명
- `base` : 베이스 클래스
- `dict` : 속성 값

### 메타클래스 구현코드

```python
__author__ = 'Chetan'

class MyInt(type):
    
    def __call__(cls, *args, **kwds):
        print("***** Here's My int *****", args)
        print("Now do whatever you want with these objects...")
        return type.__call__(cls, *args, **kwds)

class int(metaclass=MyInt):
    
    def __init__(self, x, y):
        self.x = x
        self.y = y
        pass

i = int(4,5)
i = int(7,8)

''' <실행 결과>
***** Here's My int ***** (4, 5)
Now do whatever you want with these objects...
***** Here's My int ***** (7, 8)
Now do whatever you want with these objects...
'''

```

- `__call__` 메소드는 이미 존재하는 클래스의 객체를 생성할 때 호출되는 파이썬의 특수 메소드다.
- 객체 생성을 메타클래스가 제어한다.
- 메타클래스가 클래스와 객체 생성을 제어하기 때문에 싱글톤을 생성하는 용도로 사용할 수 있다.

### 메타클래스를 사용한 싱글톤 패턴 구현

```python
__author__ = 'Chetan'

class MetaSingleton(type):
    
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(MetaSingleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]

class Logger(metaclass=MetaSingleton):
    pass

logger1 = Logger()
logger2 = Logger()
print(logger1)
print(logger2)

''' <실행 결과>
<__main__.Logger object at 0x1059635c0>
<__main__.Logger object at 0x1059635c0>
'''
```

### 싱글톤 패턴 사용 사례1

한 개의 DB를 공유하는 클라우드 서비스의 예.
- 데이터베이스의 일관성을 보존해야 한다. 연산 간의 충돌이 없어야 한다.
- 다수의 DB 연산을 처리하려면 메모리와 CPU를 효율적으로 사용해야 한다.

```python
__author__ = 'Chetan'

import sqlite3
class MetaSingleton(type):
    
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(MetaSingleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]

class Database(metaclass=MetaSingleton):
    connection = None
    def connect(self):
        if self.connection is None:
            self.connection = sqlite3.connect("db.sqlite3")
            self.cursorobj = self.connection.cursor()
        return self.cursorobj

db1 = Database().connect()
db2 = Database().connect()

print ("Database Objects DB1", db1)
print ("Database Objects DB2", db2)

''' <실행 결과>
Database Objects DB1 <sqlite3.Cursor object at 0x1005d9c00>
Database Objects DB2 <sqlite3.Cursor object at 0x1005d9c00>
'''
```

- `Database` 클래스는 `MetaSingleton` 메타클래스의 도움으로 싱글톤 역할을 한다. 단 한 개의 `Database` 클래스 객체만 생성된다.
- 웹 앱이 DB 연산을 요청할 때마다 `Database` 클래스를 생성하지만 내부적으로 한 개의 객체만 생성된다. 따라서 데이터베이스의 동기화가 보장된다. 리소스를 적게 사용해 메모리와 CPU사용량을 최적화할 수 있다.

### 싱글톤 패턴 사용 사례 2

인프라 상태를 확인하는 서비스의 예.
- `HealthCheck` 클래스를 싱글톤으로 구현한다.
- 상태를 확인해야 하는 서버의 목록을 만들고 목록에서 제거된 서버의 상태는 확인하지 않아야 한다.

``` python
__author__ = 'Chetan'

class HealthCheck:
    
    _instance = None
    def __new__(cls, *args, **kwargs):
        if not HealthCheck._instance:
            HealthCheck._instance = super(HealthCheck, cls).__new__(cls, *args, **kwargs)
        return HealthCheck._instance
    
    def __init__(self):
        self._servers = []
    
    def addServer(self):
        self._servers.append("Server 1")
        self._servers.append("Server 2")
        self._servers.append("Server 3")
        self._servers.append("Server 4")
    
    def changeServer(self):
        self._servers.pop()
        self._servers.append("Server 5")

hc1 = HealthCheck()
hc2 = HealthCheck()

hc1.addServer()
print("Schedule health check for servers (1)..")
for i in range(4):
    print("Checking ", hc1._servers[i])


hc2.changeServer()
print("Schedule health check for servers (2)..")
for i in range(4):
    print("Checking ", hc2._servers[i])

''' <실행 결과>
Schedule health check for servers (1)..
Checking  Server 1
Checking  Server 2
Checking  Server 3
Checking  Server 4
Schedule health check for servers (2)..
Checking  Server 1
Checking  Server 2
Checking  Server 3
Checking  Server 5
'''
```

- `addServer()` 메소드는 서버를 목록에 추가한다.
- `changeServer()` 메소드는 서버를 목록에서 제거하고 새로운 서버를 추가한다.
- `h1`과 `h2`는 싱글톤으로 생성된 객체이므로 동일한 객체다.

### 싱글톤 패턴의 단점
- 전역 변수의 값이 실수로 변경된 것을 모르고 애플리케이션에서 사용될 수 있다.
- 같은 객체에 대한 여러 참조자가 생길 수 있다. 싱글톤은 한 개의 객체만을 만들기 때문에 같은 객체에 대한 여러 개의 참조자가 생긴다.
- 전역 변수에 종속적인 모든 클래스 간 상호관계가 복잡해진다. 전역 변수 수정이 의도치 않게 다른 클래스에도 영향을 줄 수 있다.


## 질의응답

> 아직 없습니다.
