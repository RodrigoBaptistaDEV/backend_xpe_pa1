package com.globally.mentoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {

    Page<Mentoria> findAllByUserKey(Long userId, Pageable pageable);

    @Query("SELECT m FROM Mentoria m WHERE m.userKey = :userId " +
            "AND MONTH(m.dataHora) = :mes " +
            "AND YEAR(m.dataHora) = :ano")
    Page<Mentoria> getAllByUserPerMonth(@Param("userId") Long userId,
                                        @Param("mes") Integer mes,
                                        @Param("ano") Long ano,
                                        Pageable pageable);

    @Query("SELECT m FROM Mentoria m WHERE m.mentorKey = :mentorId " +
            "AND MONTH(m.dataHora) = :mes " +
            "AND YEAR(m.dataHora) = :ano")
    Page<Mentoria> getAllByMentorPerMonth(@Param("mentorId") Long mentorId,
                                          @Param("mes") Integer mes,
                                          @Param("ano") Long ano,
                                          Pageable pageable);

}
