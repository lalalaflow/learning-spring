package dev.helloworld.springcorebasic.singletone;

public class SingletonService {
    private static final SingletonService instatnce = new SingletonService();

    public static SingletonService getInstance() {
        return instatnce;
    }

    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 로직");
    }
}
