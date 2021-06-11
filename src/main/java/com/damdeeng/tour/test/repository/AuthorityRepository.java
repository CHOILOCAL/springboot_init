package com.damdeeng.tour.test.repository;


import com.damdeeng.tour.test.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
