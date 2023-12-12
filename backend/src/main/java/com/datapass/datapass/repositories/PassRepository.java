package com.datapass.datapass.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datapass.datapass.entities.Pass;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
	
}
