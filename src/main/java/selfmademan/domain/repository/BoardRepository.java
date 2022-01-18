package selfmademan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selfmademan.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
