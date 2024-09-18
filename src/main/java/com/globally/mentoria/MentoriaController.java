package com.globally.mentoria;

import com.globally.commom.dtos.RequestPageDTO;
import com.globally.mentoria.dtos.SendMentoriaDTO;
import com.globally.mentoria.dtos.ViewMentoriaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/mentorias")
public class MentoriaController {

    @Autowired
    MentoriaService mentoriaService;

    @PostMapping
    public ResponseEntity<ViewMentoriaDTO> createMentoria(@Valid @RequestBody SendMentoriaDTO dto){
        ViewMentoriaDTO createdMentoria = mentoriaService.createMentoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMentoria);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<ViewMentoriaDTO>> getAllByUserId(@PathVariable Long userId,
                                                                @ModelAttribute RequestPageDTO requestPageDTO){
        Sort sort = Sort.by(Sort.Direction.fromString(requestPageDTO.getSortDirection()), requestPageDTO.getSortAttribute());
        Pageable pageable = PageRequest.of(requestPageDTO.getPageNumber(), requestPageDTO.getPageSize(), sort);
        Page<ViewMentoriaDTO> allMentoriasByUserIdPage = mentoriaService.getAllMentoriasByUserId(userId, pageable);
        return ResponseEntity.ok(allMentoriasByUserIdPage);
    }

    @GetMapping("/user/{userId}/{year}/{month}")
    public ResponseEntity<Page<ViewMentoriaDTO>> getAllByUserIdMonth(@PathVariable Long userId,
                                                                     @PathVariable Integer month,
                                                                     @PathVariable Long year,
                                                                     @ModelAttribute RequestPageDTO requestPageDTO){
        Sort sort = Sort.by(Sort.Direction.fromString(requestPageDTO.getSortDirection()), requestPageDTO.getSortAttribute());
        Pageable pageable = PageRequest.of(requestPageDTO.getPageNumber(), requestPageDTO.getPageSize(), sort);
        Page<ViewMentoriaDTO> allMentoriasByUserIdPage = mentoriaService.getAllByUserPerMonth(userId, month, year, pageable);
        return ResponseEntity.ok(allMentoriasByUserIdPage);
    }

    @GetMapping("/mentor/{mentorId}/{year}/{month}")
    public ResponseEntity<Page<ViewMentoriaDTO>> getAllByMentorIdMonth(@PathVariable Long mentorId,
                                                                     @PathVariable Integer month,
                                                                     @PathVariable Long year,
                                                                     @ModelAttribute RequestPageDTO requestPageDTO){
        Sort sort = Sort.by(Sort.Direction.fromString(requestPageDTO.getSortDirection()), requestPageDTO.getSortAttribute());
        Pageable pageable = PageRequest.of(requestPageDTO.getPageNumber(), requestPageDTO.getPageSize(), sort);
        Page<ViewMentoriaDTO> allMentoriasByUserIdPage = mentoriaService.getAllByMentorPerMonth(mentorId, month, year, pageable);
        return ResponseEntity.ok(allMentoriasByUserIdPage);
    }

}
