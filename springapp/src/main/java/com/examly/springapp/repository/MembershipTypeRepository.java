package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.MembershipType;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {

    List<MembershipType> findByTypeName(String typeName);

    @Query("SELECT m FROM MembershipType m WHERE m.price BETWEEN ?1 AND ?2")
    List<MembershipType> findByPriceBetween(double min, double max);

    @Query("SELECT m FROM MembershipType m WHERE m.price < ?1")
    List<MembershipType> findByPriceLessThan(double price);

    @Query("SELECT m FROM MembershipType m WHERE m.durationInMonths > ?1")
    List<MembershipType> findByDurationGreaterThan(int duration);
}
