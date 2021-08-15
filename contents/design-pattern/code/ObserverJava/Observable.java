public interface Observable {
    void addObserver(NetflixUser user);

    void deleteObserver(NetflixUser user);

    void notifyMovie(String content);

    void notifyAnimation(String content);
}
