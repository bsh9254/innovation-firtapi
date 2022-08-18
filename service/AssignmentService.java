package com.sparta.assignment01.service;


import com.sparta.assignment01.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;



    @Transactional //DB바꿀 때 트랜잭션이 일어난다, DB바꿀때 필요한 어노테이션
    public ResponseDto update(long id, RequestDto requestDto)
    {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );


        assignment.update(requestDto);
        ResponseDto responseDto = new ResponseDto(assignment);


        return responseDto;
    }

    public Assignment createAssignmentService(RequestDto requestDto)
    {
        Assignment assignment=new Assignment(requestDto);

        return assignmentRepository.save(assignment);

    }
    public ResponseDto getDetailAssignmentService(Long id)
    {
        ResponseDto responseDto = new ResponseDto(assignmentRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 없습니다.")
        ));

        return responseDto;
    }
    public PasswordResponseDto checkPassword(Long id, RequestDto requestDto)
    {

        Assignment assignment= assignmentRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 없습니다.")
        );

        PasswordResponseDto passwordresponseDto=new PasswordResponseDto(assignment,requestDto);



        return passwordresponseDto;

    }

    public List<ResponseMainDto> getAssignmentService(){
        List<Assignment> assignmentList=assignmentRepository.findAllByOrderByModifiedAtDesc();
        List<ResponseMainDto> responseMainDtoList =new ArrayList<>();
        for(int i=0;i<assignmentList.size();i++)
        {
            Assignment assignment = assignmentList.get(i);
            ResponseMainDto responseMainDto = new ResponseMainDto(assignment);
            responseMainDtoList.add(responseMainDto);
        }
        return responseMainDtoList;
    }

    public Long deleteAssignmentService(Long id){

        assignmentRepository.deleteById(id);
        return id;

    }


}
