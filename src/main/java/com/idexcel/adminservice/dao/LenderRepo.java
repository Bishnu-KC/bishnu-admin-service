package com.idexcel.adminservice.dao;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.idexcel.adminservice.entity.Lender;


@Repository
public interface LenderRepo extends MongoRepository<Lender, String> {
	Optional<Lender> findByName(String name);

}
