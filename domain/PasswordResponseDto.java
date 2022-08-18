package com.sparta.assignment01.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PasswordResponseDto {

    private final boolean data;
    private final boolean success;

    private final String error;


    public PasswordResponseDto(Assignment assignment,RequestDto requestDto)
    {

        if(requestDto.getPassword().equals(assignment.getPassword()))
            success=true;

        else{
            success=false;
        }
        if(!requestDto.getPassword().equals(null))
        {
            this.data=true;
            this.error=null;
        }
        else {
            this.data=false;
            this.error="error";
        }


    }


}
