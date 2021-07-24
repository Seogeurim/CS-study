

# Observer(옵저버) 디자인 패턴

> 작성자 : [장주섭](https://github.com/wntjq68) 

## Observer 패턴 개요

옵저버 패턴 (observer pattern)은 객체의 상태 변화를 관찰하는 관찰자들, 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다. 주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. 발행/구독 모델로 알려져 있기도 하다.

출처: [wikipedia: 옵저버 패턴](https://ko.wikipedia.org/wiki/%EC%98%B5%EC%84%9C%EB%B2%84_%ED%8C%A8%ED%84%B4)

 이 말을 좀 더 구체적으로 풀어서 얘기하자면 Observer패턴을 사용하기 위한 객체 및 인터페이스로 **Observavle**(주체) 과 **Observer** 두 가지가 존재한다. 여기서 Observable 객체는 상태가 변화 되는 주체이고 이러한 주체를 관찰하고 있는 것이 Observer 이다. Observable은 하나 또는 여러 Observer를 등록하거나 해제할 수 있고 어떠한 상태 변화시 Observer들에 알릴 수 있다. 각각의 Observer들은 이러한 상태변화에 대해서 전달 받으면 각각의 알맞는 행동을 수행한다. 



## Observer 패턴 장점

1. 한 객체의 변경사항을 참조하고 있는 다른 객체에서 실시간으로 변경사항을 전파 할 수 있다.
2. 객체간의 의존성을 제거함으로써 느슨한 결합으로 시스템이 유연해진다.
   - 옵저버를 언제든 새로 추가 및 제거 가능하다.
   - 새로운 형식의 옵저버라도 Observable(주체)를 변경할 필요 없다.
   - Observable(주체) 와 Observer는 독립적으로 재사용 가능하다.



## Observer 패턴 단점

1. observer 를 필요한 시점외에 제거하지 않으면 메모리 누수가 일어날 수 있다.
2. 너무 빈번하게 사용하게 되면 상태 관리가 힘들 수 있다.



## Netflix 구독 예제 (Java)

 Observer 패턴을 이용한 Netflix구독 예제이다.

 NerflixUser(Observer)는 Netflix(Observable)에 영화 또는 애니메이션이 업데이트 되는 것을 관찰 하고 있다. 만약 영화 또는 애니메이션이 업데이트 되면 Netflix(Observable)은 자신을 구독하고 있는 NerflixUser(Observer)에게 알려주고 NerflixUser(Observer)는 영화이냐 애니메이션이냐에 따라 각기 다른 로직을 수행하게 된다.

### Netflix Class (Observable)

```java
public class Netflix implements Observable {
		// 구독하고 있는 user 리스트
	  ArrayList<NetflixUser> userList;

    public Netflix() {
        this.userList = new ArrayList<NetflixUser>();
    }

  	// movie를 update해주고 구독 중인 구독자에게 알림
    public void updateMovie(String movie){ 
      	// movie update code
        notifyMovie(movie);
    }

	  // animation을 update해주고 구독 중인 구독자에게 알림
    public void updateAnimation(String animation){
      	// animation update code
        notifyAnimation(animation);
    }

  	// 구독자 추가
    @Override
    public synchronized void addObserver(NetflixUser user) {
        System.out.println(user.name + "가 Netflix를 구독하기 시작했습니다.");
        userList.add(user);
    }

    // 구독자 삭제
    @Override
    public synchronized void deleteObserver(NetflixUser user) {
        System.out.println(user.name + "가 Netflix를 구독 취소했습니다.");
        userList.remove(user);
    }
  
		// Movie가 update되었다고 구독자들에게 알림
    @Override
    public void notifyMovie(String content) {
        for (NetflixUser user : userList) {
            user.updateMovie(content);
        }
    }

  	// Animation이 update되었다고 구독자들에게 알림
    @Override
    public void notifyAnimation(String content) {
        for (NetflixUser user : userList) {
            user.updateAnimation(content);
        }
    }
}
```



### NetflixUser Class (Observer)

```java
public class NetflixUser implements Observer {
		// 구독자 이름
    public String name;

    public NetflixUser(String name){
        this.name = name;
    }
		// movie update시 알림을 받음
    @Override
    public void updateMovie(String content) {
        System.out.println(name+ " | 영화 : " + content +"가 업로드 되었습니다.");
    }

  	// animation update시 알림을 받음
    @Override
    public void updateAnimation(String content) {
        System.out.println(name+ " | 애니메이션 : " + content +"가 업로드 되었습니다.");
    }
}
```



### Main Class

```java
public class Main {

    public static void main(String[] args) {
        Netflix netflix = new Netflix();
        NetflixUser user1 = new NetflixUser("user1");
        NetflixUser user2 = new NetflixUser("user2");
        NetflixUser user3 = new NetflixUser("user3");

				// user1 이 구독을 시작 함
      	netflix.addObserver(user1);

        System.out.println("-------------------------------------------");

				// netflix에 Dark Knight가 업데이트 됨
        netflix.updateMovie("Dark Knight");

        System.out.println("-------------------------------------------");

      	// user2, user3 가 구독을 시작함
        netflix.addObserver(user2);
        netflix.addObserver(user3);

        System.out.println("-------------------------------------------");

      	// netflix에 Shutter Island가 업데이트 됨
        netflix.updateMovie("Shutter Island");

        System.out.println("-------------------------------------------");

      	// user3가 구독을 취소함
        netflix.deleteObserver(user3);

        System.out.println("-------------------------------------------");

      	// netflix에 짱구는 못말려14가 업데이트 됨
        netflix.updateAnimation("짱구는 못말려14");
    }
}
```



### Result

<p>
<img src = "https://user-images.githubusercontent.com/22047374/126872520-12ed83c7-1bdf-427e-bba0-d1551c092eaf.png" width = 350px />
</p>

