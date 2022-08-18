package com.sparta.assignment01.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ResponseDto {


    private final LocalDateTime createdAt;
    // 마지막 수정일자임을 나타냅니다.
    private final LocalDateTime modifiedAt;
    private final String title;
    private final String name;
    private final String comments;
    private final String password;
    // 생성일자임을 나타냅니다.

    public ResponseDto(Assignment assignment)
    {
        this.createdAt=assignment.getCreatedAt();
        this.modifiedAt=assignment.getModifiedAt();
        this.title=assignment.getTitle();
        this.name=assignment.getName();
        this.comments=assignment.getComments();
        this.password=assignment.getPassword();
    }




}
