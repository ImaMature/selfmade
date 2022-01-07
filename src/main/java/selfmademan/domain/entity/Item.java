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
@Table(name="item")
public class Item {
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;                        //상품코드

    @Column(  length=50 , nullable = false )
    private String itemNm;                  //상품명

    @Column(name="price", nullable = false)
    private int price;                      //가격

    @Column(nullable=false)
    private int stockNumber;                //재고수량

    @Lob
    @Column(nullable=false)
    private String itemDetail;              //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  //상품 판매 상태

    private LocalDateTime regTime;          //등록 시간
    private LocalDateTime updateTime;       //수정시간
}
