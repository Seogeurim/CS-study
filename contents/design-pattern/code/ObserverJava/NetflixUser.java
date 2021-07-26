public class NetflixUser implements Observer {

    public String name;

    public NetflixUser(String name){
        this.name = name;
    }

    @Override
    public void updateMovie(String content) {
        System.out.println(name+ " | 영화 : " + content +"가 업로드 되었습니다.");
    }

    @Override
    public void updateAnimation(String content) {
        System.out.println(name+ " | 애니메이션 : " + content +"가 업로드 되었습니다.");
    }
}
