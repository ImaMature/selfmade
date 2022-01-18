package selfmademan.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import selfmademan.constant.ItemSellStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name="board")
public class Board {
    @Id
    @Column(name="b_no")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int b_no;

    @Column( name="b_title" )
    private String b_title;                  //상품명

    @Column(name="b_contents")
    private String b_contents;                      //가격

    @Column( name="b_writer" )
    private String b_writer;                  //작성자

    private LocalDateTime regTime;          //등록 시간
    private LocalDateTime updateTime;       //수정시간


}
