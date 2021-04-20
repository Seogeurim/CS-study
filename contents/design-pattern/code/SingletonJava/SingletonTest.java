public class SingletonTest {

    public static void main(String[]args) {
        SingletonClass sclass = SingletonClass.getInstance();
        SingletonClass sclass2 = SingletonClass.getInstance();
        System.out.println(sclass);
        System.out.println(sclass2);
        // sclass, sclass2 를 출력해보면 그 주소값이 같은 것을 확인할 수 있다.

        NonSingletonClass nclass = new NonSingletonClass();
        NonSingletonClass nclass2 = new NonSingletonClass();
        System.out.println(nclass);
        System.out.println(nclass2);
        // nclass, nclass2 를 출력해보면 주소값이 다르다.
    }
}

class SingletonClass {
    private SingletonClass() {}

    static { sClass = new SingletonClass(); }
    private static SingletonClass sClass;

    public static SingletonClass getInstance() {
        return sClass;
    }
}

class NonSingletonClass {
    public NonSingletonClass() {}
}