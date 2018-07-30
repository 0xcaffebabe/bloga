package wang.ismy.bloga.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.ismy.bloga.entity.SqlLog;

public interface SqlLogRepository extends JpaRepository<SqlLog,Integer> {
}
