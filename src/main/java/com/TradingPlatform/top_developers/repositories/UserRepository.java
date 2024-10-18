package com.TradingPlatform.top_developers.repositories;

import com.TradingPlatform.top_developers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
