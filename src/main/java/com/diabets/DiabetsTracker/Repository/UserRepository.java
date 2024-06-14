package com.diabets.DiabetsTracker.Repository;

import com.diabets.DiabetsTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
