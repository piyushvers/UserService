package com.usp.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usp.medicare.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
   List<Property> findByPropertyName(String propertyName);
}
