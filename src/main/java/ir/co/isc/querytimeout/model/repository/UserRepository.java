package ir.co.isc.querytimeout.model.repository;

import ir.co.isc.querytimeout.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(timeout = 2)
    @Query(value = "SELECT pg_sleep(10)", nativeQuery = true)
    void timeout();
}
