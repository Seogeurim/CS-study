import java.util.ArrayList;


public class Netflix implements Observable {
    ArrayList<NetflixUser> userList;

    public Netflix() {
        this.userList = new ArrayList<NetflixUser>();
    }

    public void updateMovie(String movie){
        notifyMovie(movie);
    }

    public void updateAnimation(String animation){
        notifyAnimation(animation);
    }

    @Override
    public synchronized void addObserver(NetflixUser user) {
        System.out.println(user.name + "가 Netflix를 구독하기 시작했습니다.");
        userList.add(user);
    }

    @Override
    public synchronized void deleteObserver(NetflixUser user) {
        System.out.println(user.name + "가 Netflix를 구독 취소했습니다.");
        userList.remove(user);
    }

    @Override
    public void notifyMovie(String content) {
        for (NetflixUser user : userList) {
            user.updateMovie(content);
        }
    }

    @Override
    public void notifyAnimation(String content) {
        for (NetflixUser user : userList) {
            user.updateAnimation(content);
        }
    }


}
