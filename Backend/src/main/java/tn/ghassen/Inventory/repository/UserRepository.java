package tn.ghassen.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ghassen.inventory.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}