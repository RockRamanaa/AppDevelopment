package com.example.travelguidewebapplication.repository;

import com.example.travelguidewebapplication.enums.Status;
import com.example.travelguidewebapplication.model.UserComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCommentRepository extends JpaRepository<UserComment, String> {
    @Query("SELECT u FROM UserComment u " +
            "INNER JOIN u.travelDestinationDetailsId d " +
            "INNER JOIN d.travelDestination p " +
            "WHERE p.id = :id AND p.status= :status " +
            "ORDER BY u.localDateTime DESC")
    List<UserComment> findByFkPlacesToVisitDetailsIdPlacesId(String id, Status status, Pageable pageable);

    @Query("""
            SELECT c FROM UserComment c
            INNER JOIN c.travelDestinationDetailsId d
            INNER JOIN d.travelDestination p
            WHERE p.id = :id
            """)
    List<UserComment> findByTravelDestinationId(@Param("id") String travelDestinationId);
}
