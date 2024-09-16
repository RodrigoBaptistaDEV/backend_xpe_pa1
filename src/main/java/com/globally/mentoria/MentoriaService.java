package com.globally.mentoria;

import com.globally.mentoria.dtos.SendMentoriaDTO;
import com.globally.mentoria.dtos.ViewMentoriaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MentoriaService {

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ViewMentoriaDTO createMentoria(SendMentoriaDTO dto) {
        Mentoria mentoria = new Mentoria(dto);
        Mentoria createdMentoria = mentoriaRepository.save(mentoria);
        return new ViewMentoriaDTO(createdMentoria);
    }

    public Page<ViewMentoriaDTO> getAllMentoriasByUserId(Long userId, Pageable pageable) {
        // remover try catch depois ( global )
        try {
            Page<Mentoria> entityPage = mentoriaRepository.findAllByUserKey(userId, pageable);
            return entityPage.map(ViewMentoriaDTO::new);
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<ViewMentoriaDTO> getAllByUserPerMonth(Long userId, Integer month, Long year, Pageable pageable) {
        try {
            Page<Mentoria> entityPage = mentoriaRepository.getAllByUserPerMonth(userId, month, year,pageable);
            return entityPage.map(ViewMentoriaDTO::new);
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
