# 팩토리 (Factory) 디자인 패턴

> 작성자 : [서그림](https://github.com/Seogeurim)

팩토리 디자인 패턴이란 객체 생성 처리를 별도의 클래스(팩토리)에게 맡기는 것이다. 즉 객체를 생성할 때 `A a = new A();` 이런 식으로 하지 않고, `Factory.getInstance("A");` 처럼 팩토리에게 객체 생성을 부탁하는 방식이다. 팩토리 디자인 패턴을 적용하면 추후 객체 생성의 변경 사항이 생겼을 때 수정이 용이하다.

## 팩토리 디자인 패턴 구현

Factory 클래스를 통해 Product 객체를 생성하는 코드를 구현해보자.

### Product Interface

```java
interface Product {
    public void sell();
}
```

### Product Interface를 구현하는 클래스 Pencil, Note

```java
class Pencil implements Product {

    @Override
    public void sell() {
        System.out.println("sell Pencil !!!");
    }
}

class Note implements Product {

    @Override
    public void sell() {
        System.out.println("sell Note !!!");
    }
}
```

### Product 객체 생성

#### 팩토리 디자인 패턴을 적용하지 않았을 때

```java
Product pencil = new Pencil();
pencil.sell();
```

#### 팩토리 디자인 패턴을 적용한다면

팩토리 디자인 패턴을 적용하기 위해서는 먼저 객체를 생성하는 Factory 클래스를 생성해야 한다.

이 때, Factory 클래스의 객체 생성 메서드는 static으로 선언하는 것이 좋다. 외부에서는 Factory 클래스 내부에 전혀 관심이 없고, 문자열을 통해 생성한 객체와 그 인터페이스에만 관심이 있기 때문이다.

```java
class ProductFactory {
    public static Product getProduct(String className) {
        Product p = null;
        switch (className) {
            case "Pencil": p = new Pencil(); break;
            case "Note": p = new Note(); break;
        }
        return p;
    }
}
```

Factory 클래스를 통해 객체를 생성한다.

```java
Product pencil = ProductFactory.getProduct("Pencil");
pencil.sell();

/*
        // getProduct 메서드를 static으로 선언하지 않았을 때
        ProductFactory factory = new ProductFactory();
        Product pencil = factory.getTransportation("A");
 */
```

Factory Java 전체 구현 ▶️ [FactoryTest.java](./code/FactoryJava/FactoryTest.java)

## Factory Design Pattern의 장점

1. 계층 간 의존도가 낮아진다.

   만일 A 클래스 파일이 변경/삭제 되었을 때, 객체를 직접 생성(`new A()`)했을 때는 객체 생성 코드를 다 고쳐야 한다. 반면 팩토리 디자인 패턴을 쓰면, Factory 코드만 고치면 된다.

   즉 클래스에 변경사항이 생겼을 때, 객체를 생성해 사용하는 main 메서드 쪽에서는 영향을 받지 않는다. 대신 interface는 반드시 알고 있어야 한다. Factory를 통해 return 되어 오는 실제 객체 녀석에게는 관심이 없고, interface에만 관심이 있으며 비즈니스 로직에 따라서 interface에 있는 메서드를 호출하면 된다.

2. 외부에 소통 구조가 생긴다.

   문자열을 통해 객체 생성을 요청하기 때문에 외부에서 문자열을 읽어와 그 문자열로 객체 생성을 호출하는 등의 구현이 가능하다. 따라서 외부 소통 구조가 생기며 하드코딩 하는 것이 많이 줄어들 수 있다.
