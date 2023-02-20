package com.hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    // 생성자 - private 인스턴스 변수에도 접근할 수 있는 초기화만을 위한 public 메서드
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
