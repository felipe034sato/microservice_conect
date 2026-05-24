package com.example.microservice_conect.repository;

import com.example.microservice_conect.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(nativeQuery = true, value =
            "SELECT t1.id, t1.lane1, t1.lane2, t1.state, t1.zip_code, t1.employee_id " +
                    "FROM address AS t1 " +
                    "JOIN employees AS t2 ON t2.id = t1.employee_id " +
                    "WHERE t1.employee_id = :employeeId")
    Address findAddressById(@Param("employeeId") Long employeeId);
}
