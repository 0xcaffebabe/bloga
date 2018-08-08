package wang.ismy.bloga.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.ismy.bloga.entity.Situation;

public interface SituationRepoisory extends JpaRepository<Situation,Integer> {
}
