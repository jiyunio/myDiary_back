package com.jiyunieo.demo.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "contents")
    private String contents;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    public void update(String contents, int x, int y) {
        this.contents = contents;
        this.x = x;
        this.y = y;
    }
}
