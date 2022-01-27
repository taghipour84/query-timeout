package ir.co.isc.querytimeout.model.repository;

import ir.co.isc.querytimeout.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(timeout = 1)
    User findByUsername(String username);
}
