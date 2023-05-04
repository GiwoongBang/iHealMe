package com.project.ihealme.community.domain;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMNO_GEN")
    @SequenceGenerator(sequenceName = "COMMENT_COMMNO_SEQ", name = "COMMNO_GEN", allocationSize = 1)
    private Long commno;

    @Column(nullable = false, length = 600)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userEmail", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postNo", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @CreatedDate
    private LocalDateTime regdate;

    public Comment(String content, User user, Post post, LocalDateTime regdate) {
        this.content = content;
        this.user = user;
        this.post = post;
        this.regdate = regdate;
    }

    public boolean isOwnComment(User user){
        return this.user.equals(user);
    }
}