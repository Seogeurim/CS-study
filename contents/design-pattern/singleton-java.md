# 싱글톤 (Singleton) Java 구현 방법

> 작성자 : [서그림](https://github.com/Seogeurim)

싱글톤 디자인 패턴에 대한 자세한 설명은 [싱글톤 (Singleton) 문서](singleton.md)를 참고하세요. 여기서는 싱글톤 디자인 패턴의 Java 구현 방법을 정리합니다.

## private 생성자

Java의 싱글톤 구현은 생성자에 대한 이해로부터 시작한다. 생성자를 public으로 둔다면 누구나 접근하여 객체 생성이 가능하기 때문에 오직 하나의 객체 생성에 대한 제약을 걸 수 없다. 따라서 **생성자를 private**으로 두고, **생성된 객체는 static 변수로 관리**, **객체 접근에 대한 부분은 별도의 public한 method**를 둬서 싱글톤 디자인 패턴을 구현한다.

```java
class ClassName {
    private ClassName() {}
}
```

## 객체 생성의 3가지 방법

생성자를 private으로 뒀을 때 객체를 생성하는 방법은 다음의 3가지 경우가 있을 수 있다.

### getInstance

코드가 직관적이나 if 조건 체크가 번거롭다는 단점이 있다.

```java
class ClassName {
    private ClassName() {}

    static ClassName className;

    public static ClassName getInstance() {
        if (className == null) className = new ClassName();
        return className; // 객체 접근
    }
}
```

### static block

가장 간결한 방법이다.

```java
class ClassName {
    private ClassName() {}
    
    private static ClassName className;
    static { className = new ClassName(); }
}
```

### member 변수 선언 시 생성

이 방법은 되도록 지양하는 방법이다.

```java
class ClassName {
    private ClassName() {}
    
    private static ClassName className = new ClassName();
}
```

## 객체 접근

자기 자신을 return하는 public static method를 구현한다. static 변수에는 static 끼리만 접근이 가능하기 때문에 static으로 선언해야 한다.

```java
class ClassName {
    private ClassName() {}

    private static ClassName className;
    static { className = new ClassName(); }
    
    public static ClassName getInstance() {
        return className;
    }
}
```

Singleton Java 전체 구현 ▶️ [SingletonTest.java](./code/SingletonJava/SingletonTest.java)
