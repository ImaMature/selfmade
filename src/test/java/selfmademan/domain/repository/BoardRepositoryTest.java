package selfmademan.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import selfmademan.domain.entity.Board;
import selfmademan.service.BoardService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardRepositoryTest {
    @Autowired
    BoardService boardService;


    @Test
    @DisplayName("게시판 등록 테스트")
    public void createBoard(){
        Board board = new Board();
        board.setB_writer("작성자");
        board.setB_title("제목");
        board.setB_contents("내용");
        board.setRegTime(LocalDateTime.now());
        board.setUpdateTime(LocalDateTime.now());
        boardService.boardwrite(board);
    }

    @Test
    @DisplayName("게시판 모든 조회")
    public void createManyBoard(){
        for(int i =1; i<=8; i++){
            Board board = new Board();
            board.setB_writer(i+"번 작성자");
            board.setB_title(i+"번 제목");
            board.setB_contents(i+ "번 내용");
            board.setRegTime(LocalDateTime.now());
            board.setUpdateTime(LocalDateTime.now());
            boardService.boardwrite(board);
        }
    }

    @Test
    @DisplayName("게시판 개별 조회")
    public void findByBoardNo(){
        Board board = new Board();
        board.setB_no(1);
        int b_no = board.getB_no();
        boardService.getBoardByNo(b_no);

    }

    @Test
    @DisplayName("게시판 수정")
    public void updateBoard(){
        boardService.updateBoard(1);
    }

    @Test
    @DisplayName("게시판 삭제")
    public void deleteBoard(){
        this.createManyBoard();
        boardService.getdeleteBoard(1);
    }
}