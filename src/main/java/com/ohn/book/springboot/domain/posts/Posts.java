package com.ohn.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter메소드를 자동생성.
@NoArgsConstructor //기본 생성자 자동 추가
@Entity
public class Posts {//Entity클래스

    @Id //PK필드임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙
    private Long id;
 
    @Column(length = 500, nullable = false) //VARCHAR(255)가 기본인데 사이즈를 늘릴 때,
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //타입을 TEXT로 변경
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 포함됨!
    public Posts(String title, String content, String author) { //실제 테이블과 매칭될 클래스
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
