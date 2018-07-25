package wang.ismy.bloga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.ismy.bloga.entity.User;

public interface TestRepository extends JpaRepository<User,Integer> {
}
