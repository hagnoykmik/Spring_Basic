package com.hello.core.lifecycle;

public class NetworkClient {

    private String url;

    // 생성자

    public NetworkClient() {
        // 생성할 때 생성자 호출
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");

    }

    // url은 외부에서 setter로 넣을 수 있음
    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    // 실제로 연결이 된 상태에서 call을 부를 수 있음
    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }
}
