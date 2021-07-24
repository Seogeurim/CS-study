public class Main {

    public static void main(String[] args) {
        Netflix netflix = new Netflix();
        NetflixUser user1 = new NetflixUser("user1");
        NetflixUser user2 = new NetflixUser("user2");
        NetflixUser user3 = new NetflixUser("user3");

        netflix.addObserver(user1);

        System.out.println("-------------------------------------------");


        netflix.updateMovie("Dark Knight");

        System.out.println("-------------------------------------------");

        netflix.addObserver(user2);
        netflix.addObserver(user3);

        System.out.println("-------------------------------------------");

        netflix.updateMovie("Shutter Island");

        System.out.println("-------------------------------------------");

        netflix.deleteObserver(user3);

        System.out.println("-------------------------------------------");

        netflix.updateAnimation("짱구는 못말려14");
    }
}
