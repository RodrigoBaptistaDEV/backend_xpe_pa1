package com.globally.mentor;


import com.globally.commom.dtos.RequestPageDTO;
import com.globally.mentor.dtos.ViewMentorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/mentores")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity<Page<ViewMentorDTO>> getPaginatedMentors(@ModelAttribute RequestPageDTO requestPageDTO){
        Sort sort = Sort.by(Sort.Direction.fromString(requestPageDTO.getSortDirection()), requestPageDTO.getSortAttribute());
        Pageable pageable = PageRequest.of(requestPageDTO.getPageNumber(), requestPageDTO.getPageSize(), sort);
        Page<ViewMentorDTO> allMentorsPage = mentorService.getPaginatedMentors(pageable);
        return ResponseEntity.ok(allMentorsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewMentorDTO> getMentorById(@PathVariable Long id){
        ViewMentorDTO mentorDTO = mentorService.getMentorById(id);
        return ResponseEntity.ok(mentorDTO);
    }

}
