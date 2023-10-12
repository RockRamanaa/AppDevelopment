package com.example.travelguidewebapplication.repository;

import com.example.travelguidewebapplication.enums.Status;
import com.example.travelguidewebapplication.model.TravelDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelDestinationRepository extends JpaRepository<TravelDestination, String> {

    @Query("SELECT p FROM TravelDestination p INNER JOIN p.category k WHERE k.category = :key AND p.status = :status")
    List<TravelDestination> findByTravelPlaceKeyValue(@Param("key") String key, @Param("status") Status status);

    @Query("SELECT p FROM TravelDestination p WHERE p.createdBy = :userId" +
            " AND (:status IS NULL OR p.status = :status)")
    List<TravelDestination> createdByUserList(@Param("userId") Integer id, @Param("status") Status status);


    @Query("SELECT count(p.id) FROM TravelDestination p WHERE p.createdBy = :userId" +
            " AND (:status IS NULL OR p.status IN :status)")
    Integer createdByUserListStatusCount(@Param("userId") Integer id, @Param("status") Status status);

}
