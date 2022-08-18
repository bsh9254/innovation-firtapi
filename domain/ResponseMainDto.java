package com.sparta.assignment01.domain;


import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ResponseMainDto {
    private final LocalDateTime createdAt;
    // 마지막 수정일자임을 나타냅니다.
    private final LocalDateTime modifiedAt;
    private final Long id;
    private final String title;
    private final String name;
    private final String password;
    // 생성일자임을 나타냅니다.


    public ResponseMainDto(Assignment assignment)
    {
        this.createdAt=assignment.getCreatedAt();
        this.modifiedAt=assignment.getModifiedAt();

        this.id= assignment.getId();
        this.title=assignment.getTitle();
        this.name=assignment.getName();
        this.password=assignment.getPassword();

    }

}
