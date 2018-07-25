package wang.ismy.bloga.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
