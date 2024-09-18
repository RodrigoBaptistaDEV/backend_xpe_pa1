package com.globally.mentor;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.globally.mentor.dtos.ViewMentorDTO;
import org.springframework.data.domain.Pageable;

@Service
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    ModelMapper modelMapper;

    public Page<ViewMentorDTO> getPaginatedMentors(Pageable pageable){
        try {
            Page<Mentor> entityPage = mentorRepository.findAll( pageable);
            return entityPage.map(e -> modelMapper.map(e, ViewMentorDTO.class));
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ViewMentorDTO getMentorById(Long id) {
        try {
            Mentor mentor = mentorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return modelMapper.map(mentor, ViewMentorDTO.class);
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
