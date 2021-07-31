# Adapter(어댑터) 디자인 패턴

 어댑터  패턴이란 호환성이 없는 인터페이스 때문에 함께 동작할 수 없는 클래스들이 함께 작동할 수 있도록 해주는 패턴이다.

<p align="center">
  <img src="https://user-images.githubusercontent.com/22047374/127748250-222ee5f3-bccf-4746-8904-8e3df9166ef9.png" alt="어댑터패턴" width="500px" />
</p>



## Adapter 디자인 패턴의 장점

- 관계가 없는 인터페이스를 같이 사용 가능
- 프로그램을 테스트 하는데 용이
- 클래스 재활용성이 높아짐

## Adapter 디자인 패턴의 종류

- 객체 어댑터 패턴 - 위임을 이용한 어댑터 패턴

- 클래스 어댑터 패턴 - 상속을 이용한 어댑터 패턴

상속(Inheritance)과 위임(Delegation)에서 위임에 대해 익숙하지 않을 수 있는데 위임이란 다른 클래스의 객체를 멤버 변수로 갖는 형태의 클래스이다.

## Adapter 디자인 패턴 예제

### 시나리오

원래는 이미지만 보여줄 수 있는 뷰어가 있다. 여기서 요구사항에 의해 이미지가 아닌 동영상도 보여 주고 싶다. 

1. Image 클래스는 Media 인터페이스를 상속한다.
2. Video 클래스는 AdvancedMedia 인터페이스를 상속한다.
3. 현재 개발된 코드를 수정 할 수 없는 상황이다.
4. 새로운 Viewer를 만들 수 없는 상황이다.

어떤 파일들을 추가하고 main()에 어떤 코드들이 추가 되면 좋을 지 생각해보자.



### 요구사항 반영 전

Main.java

```java
public class Main {
    public static void main(String[] args) {
        Media media = new Image("Monalisa");
        Viewer viewer = new Viewer();
        viewer.view(media);
    }
}

```

Viewer.java

```java
public class Viewer { // media의 show()를 호출하는 역할
    public void view(Media media){
        media.show();
    }
}
```

Media.java( Media interface )

```java
public interface Media {
    public void show();
}
```

Image.java

```java
public class Image implements Media {
    public String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("Image :" + name);
    }
}
```

### 요구사항 반영 후

1. Video 클래스, AdvancedMedia 인터페이스에 대한 파일을 추가한다.
2. Image와 Video는 interface가 다르기 때문에 Video를 바로 Viewer에서 사용할 수 없기 때문에 Adapter를 추가해준다.



AdvancedMedia.java( AdvancedMedia interface )

```swift
public interface AdvancedMedia {
    public void play();
}
```

Video.java

```java
public class Video implements AdvancedMedia {
    public String name;

    public Video(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Video :" + name);
    }
}
```

#### 객체 어댑터 패턴(위임)

MediaAdapter.java

```java
public class MediaAdapter implements Media {
    public AdvancedMedia media; // 위임 
    public MediaAdapter(AdvancedMedia media) {
        this.media = media;
    }

    @Override
    public void show() {
        media.play();
    }
}
```

Main.java

```java
public class Main {
    public static void main(String[] args) {

        Media media = new Image("Monalisa");
        AdvancedMedia advancedMedia = new Video("IZONE M/V"); // 위임할 객체 생성

        MediaAdapter mediaAdapter = new MediaAdapter(advancedMedia); // MediaAdapter에 advancedMedia 위임
      
        Viewer viewer = new Viewer();
        viewer.view(media);
        viewer.view(mediaAdapter);
    }
}
```



#### 클래스 어댑터 패턴

MediaAdapter.java

```java
public class MediaAdapter extends Video implements Media { // 상속
    public MediaAdapter(String name) {
        super(name); // 상속한 Video 클래스 init
    }

    @Override
    public void show() {
        super.play(); // 상속한 Video 클래스의 play() 실행
    }
}
```

Main.java

```java
public class Main {
    public static void main(String[] args) {

        Media media = new Image("Monalisa");
        MediaAdapter mediaAdapter = new MediaAdapter("IZONE M/V");
      
        Viewer viewer = new Viewer();
        viewer.view(media);
        viewer.view(mediaAdapter);
    }
}
```

#### 결과

어떤 Adapter를 적용해도 결과는 같게 나온다.

![image](https://user-images.githubusercontent.com/22047374/127747979-77aadb92-4037-4b5b-9539-63db3ae7effb.png)

### 마무리

이렇게 어댑터 패턴을 사용하면 기존 소스코드를 수정하지 않고 새로운 또는 맞추고자 하는 인터페이스에 맞춰서 동작가능하게 한다. 그렇기 때문에 소스코드가 좀 더 간결해지고 유지보수 또한 원활해진다. 

