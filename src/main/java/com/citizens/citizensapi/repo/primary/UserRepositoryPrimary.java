package com.citizens.citizensapi.repo.primary;

import com.citizens.citizensapi.primary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPrimary extends JpaRepository<User, Long> {
}
