package com.sparta.assignment01.controller;


import com.sparta.assignment01.domain.*;
import com.sparta.assignment01.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//보일러 플레이트, 컴포넌트, 스프링빈, 의존성 주입
@RestController //jason으로 받음
@RequiredArgsConstructor
public class AssignmengtController {
    private final AssignmentRepository assignmentRepository;
    private final AssignmentService assignmentService;
    //겟 포스트





    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/post")
    public Assignment createAssignment(@RequestBody RequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.


        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return assignmentService.createAssignmentService(requestDto);
    }
    @PostMapping("/api/post/{id}")
    public PasswordResponseDto checkPassword(@PathVariable Long id,@RequestBody RequestDto requestDto)
    {
        return assignmentService.checkPassword(id,requestDto);
    }

    @PutMapping("/api/post/{id}")
    public ResponseDto updateAssignment(@PathVariable Long id, @RequestBody RequestDto requestDto) {

        return assignmentService.update(id, requestDto);
    }

    @GetMapping("/api/post")
    public List<ResponseMainDto> getAssignment(){
        return assignmentService.getAssignmentService();
    }

    @GetMapping("api/post/{id}")
    public ResponseDto getDetailAssignment(@PathVariable Long id){return assignmentService.getDetailAssignmentService(id);}

    @DeleteMapping("/api/post/{id}")
    public Long deleteAssignment(@PathVariable Long id){
        return assignmentService.deleteAssignmentService(id);
    }


}
