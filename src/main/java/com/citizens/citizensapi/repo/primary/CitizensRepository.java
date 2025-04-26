package com.citizens.citizensapi.repo.primary;

import com.citizens.citizensapi.primary.entity.Citizens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizensRepository extends JpaRepository<Citizens, Integer> {


}
