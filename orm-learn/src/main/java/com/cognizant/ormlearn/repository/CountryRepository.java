package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;

/**
 * Spring Data JPA Repository interface for Country entity database transactions.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
