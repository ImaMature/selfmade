package selfmademan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import selfmademan.domain.entity.Item;

import java.util.List;

//pk타입(@Id)이 Long이라 Long이 들어감
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm);                                //itemNm(상품명)으로 데이터를 조회하는 쿼리 메소드
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); //상품을 상품명과 상품 상세 설명을 or 조건으로 조회하는 쿼리 메소드
    List<Item> findByPriceLessThan(Integer price);                         //파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리 메소드
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);         //파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 내림차순으로 조회하기
                            //Order+속성명+Desc 키워드
    @Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);


}
