package wang.ismy.bloga.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
}
