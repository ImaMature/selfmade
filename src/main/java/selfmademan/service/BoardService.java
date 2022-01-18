package selfmademan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selfmademan.domain.entity.Board;
import selfmademan.domain.entity.Item;
import selfmademan.domain.repository.BoardRepository;
import selfmademan.domain.repository.ItemRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public void boardwrite( Board board){
        Board board2 = boardRepository.save(board);
        System.out.println(board2.toString());
    }

    public void getBoard(Board board){
        List<Board> boardentities = boardRepository.findAll();
        for(Board temp : boardentities) {
            Board board2 = boardRepository.save(board);
        }
        System.out.println(boardentities.toString());
    }

    public void getBoardByNo(int b_no) {
        Optional<Board> list = boardRepository.findById(b_no);
        System.out.println(list.toString());
    }

    public void updateBoard(int b_no) {
        Optional<Board> entity = boardRepository.findById(b_no);
        try {
            entity.get().setB_title("ddd");
            entity.get().setB_contents("ddd");
            entity.get().setB_writer("aa");
            System.out.println(entity.toString());
        }catch(Exception e){

        }
    }

    public Optional<Board> getdeleteBoard(int b_no) {
        Optional <Board> entity = boardRepository.findById(b_no);
        boardRepository.delete(entity.get());
        return entity;
    }
}
