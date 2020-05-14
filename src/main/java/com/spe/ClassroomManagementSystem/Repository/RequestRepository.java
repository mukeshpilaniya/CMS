package com.spe.ClassroomManagementSystem.Repository;

import com.spe.ClassroomManagementSystem.Models.Request;
import com.spe.ClassroomManagementSystem.Models.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Request req " +
            "SET req.requestStatus = 'FULFILLED' " +
            "WHERE ((req.requestStatus = 'GRANTED') " +
            "AND ((req.classRequestDate < :curr_date) " +
            "OR ((req.classRequestDate = :curr_date) AND (req.endTime < :curr_time))))"
    )
    void updateRequestStatus(@Param("curr_date")Date currdate, @Param("curr_time")Time currtime);
}