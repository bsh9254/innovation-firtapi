package com.sparta.assignment01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Assignment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private String comments;
    @Column
    private String Password;

    public Assignment(RequestDto requestDto)
    {
        this.title= requestDto.getTitle();
        this.name= requestDto.getName();
        this.comments=requestDto.getComments();
        this.Password=requestDto.getPassword();
    }
    public Assignment(String title,String name,String Password,String comments)
    {
        this.title=title;
        this.name=name;
        this.Password=Password;
        this.comments=comments;
    }

    public void update(RequestDto requestDto)
    {
        this.title= requestDto.getTitle();
        this.name= requestDto.getName();
        this.comments=requestDto.getComments();
        this.Password=requestDto.getPassword();

    }


}
