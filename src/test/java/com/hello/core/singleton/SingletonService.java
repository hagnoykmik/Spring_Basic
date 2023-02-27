package com.hello.core.singleton;

public class SingletonService {

    // 자신을 내부에 private, static으로 가지고 있기 때문에 딱 하나만 존재
    private static final SingletonService instance = new SingletonService();
    // SingletonService() 객체를 생성해서 instance에 참조를 넣는다

    // 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자
    private SingletonService() {
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    // psvm
    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }




}
