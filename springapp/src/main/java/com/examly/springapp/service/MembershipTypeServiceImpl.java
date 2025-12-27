package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    @Autowired
    private MembershipTypeRepository repo;

    @Override
    public MembershipType create(MembershipType membershipType) {
        return repo.save(membershipType);
    }

    @Override
    public MembershipType update(int id, MembershipType membershipType) {
        membershipType.setTypeId(id);
        return repo.save(membershipType);
    }

    @Override
    public List<MembershipType> getAll() {
        return repo.findAll();
    }

    @Override
    public MembershipType getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<MembershipType> getByName(String name) {
        return repo.findByTypeName(name);
    }

    @Override
    public List<MembershipType> getByPriceRange(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    @Override
    public List<MembershipType> getByPriceLessThan(double price) {
        return repo.findByPriceLessThan(price);
    }

    @Override
    public List<MembershipType> getByDurationGreaterThan(int duration) {
        return repo.findByDurationGreaterThan(duration);
    }
}
