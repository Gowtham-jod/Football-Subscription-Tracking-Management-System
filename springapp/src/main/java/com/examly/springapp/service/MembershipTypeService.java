package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.MembershipType;

public interface MembershipTypeService {

    MembershipType create(MembershipType membershipType);

    MembershipType update(int id, MembershipType membershipType);

    List<MembershipType> getAll();

    MembershipType getById(int id);

    List<MembershipType> getByName(String name);

    List<MembershipType> getByPriceRange(double min, double max);

    List<MembershipType> getByPriceLessThan(double price);

    List<MembershipType> getByDurationGreaterThan(int duration);
}
