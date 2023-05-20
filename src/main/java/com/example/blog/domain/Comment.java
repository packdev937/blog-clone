package com.example.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public void setPost(Post post) {
        if (this.post != null) {
            this.post.getComments().remove(this);
        }
        this.post = post;
        post.getComments().add(this);
    }

    private String name;
    private String text;
    private LocalDateTime createDate;

    // 카테고리도 추가하자.

    // 연관 관계 메소드는 일반적으로 1 대 다에서 다의 관계에서 써주는 것이 좋나?

    // 비즈니스 로직은 어떠한 경우에 짜야할까?
}
