package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.*;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.service.LoanService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    //post method
    @PostMapping("/result/{memberId}")
    public ResponseEntity<?> updateLoan(@PathVariable Long memberId, @RequestBody LoanCreateRequestDto loanDto) {
        try {
            loanService.updateLoan(memberId, loanDto);
            LoanResponseDto responseDto = mapToResponseDto(loanDto); // Map LoanCreateRequestDto to LoanResponseDto
            return ResponseEntity.ok(responseDto);
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private LoanResponseDto mapToResponseDto(LoanCreateRequestDto loanDto) {
        LoanResponseDto responseDto = new LoanResponseDto();
        responseDto.setName(loanDto.getName());
        responseDto.setInsert_time(loanDto.getInsert_time());
        responseDto.setLoan_limit(loanDto.getLoan_limit());
        responseDto.setLoan_initial(loanDto.getLoan_initial());
        responseDto.setLoan_range_min(loanDto.getLoan_range_min());
        responseDto.setLoan_range_max(loanDto.getLoan_range_max());
        return responseDto;
    }


/*    @PostMapping("/request/{memberId}")
    public ResponseEntity<?> applyLoan(@PathVariable Long memberId, @RequestBody ApplyRequestDto applyDto){
        return
    }*/


}
/*
    @PostMapping("/request/{memberId}")
    public ResponseEntity<?> updateLoan(@PathVariable Long memberId, @RequestBody LoanCreateRequestDto loanDto){
        try {
            loanService.updateLoan(memberId,loanDto);
            return ResponseEntity.ok("Loan 업데이트 성공");
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}*/
