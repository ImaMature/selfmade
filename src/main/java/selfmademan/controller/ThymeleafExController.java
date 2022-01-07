package selfmademan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import selfmademan.domain.dto.ItemDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/thymeleaf") //매핑한 수 만큼 경로를 추가해야함
                                    //실행시키기 위해서는  http://localhost:8083/thymeleaf/ex01이렇게 해야됨
public class ThymeleafExController {

    //그냥 텍스트 출력해보기
    @GetMapping(value="/ex01")
    public String thymeleafExample01(Model model){
        model.addAttribute("data", "타임리프 예제입니다.");
        return "thymeleafEx/thymeleafEx01";
    }

    //th:text로 상품 출력
    @GetMapping(value="/ex02")
    public String thymeleafExample02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    //th:each로 상품 리스트 출력
    @GetMapping(value="/ex03")
    public String thymeleafExample03(Model model){
        List<ItemDto> itemDtolist = new ArrayList<>();
        for(int i=0; i<=10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtolist.add(itemDto);
        }
        model.addAttribute("itemDtoL",itemDtolist);
        return "thymeleafEx/thymeleafEx03";
    }

    //th:if, th:unless 조건문 예제 (unless = else)
    @GetMapping(value="/ex04")
    public String thymeleafExample04(Model model){
        List<ItemDto> itemDtolist = new ArrayList<>();
        for(int i=0; i<=10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtolist.add(itemDto);
        }
        model.addAttribute("itemDtoL",itemDtolist);
        return "thymeleafEx/thymeleafEx04";
    }
    //th:switch, th:case 조건문2
    @GetMapping(value="/ex05")
    public String thymeleafExample05(Model model){
        List<ItemDto> itemDtolist = new ArrayList<>();
        for(int i=0; i<=10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtolist.add(itemDto);
        }
        model.addAttribute("itemDtoL",itemDtolist);
        return "thymeleafEx/thymeleafEx05";
    }

    //th:href 사용하기 링크 이동
    @GetMapping(value="/ex06")
    public String thymeleafExample06(){
        return "thymeleafEx/thymeleafEx06";
    }

    //th:href 이용해서 파라미터 데이터 전달하기
    @GetMapping(value="/ex07")
    public String thymeleafExample07(String param1, String param2, Model model){ //Ex05에서 전달했던 매개변수와 같은 이름의 String변수를 파라미터로 설정하면 자동으로 데이터가 바인딩됩니다.
        model.addAttribute("param1","param1"); // 매개변수를 model에 담아서 view로 전달합니다.
        model.addAttribute("param2","param2");
        return "thymeleafEx/thymeleafEx07";
    }

    //Thymeleaf 페이지 레이아웃 예제
    @GetMapping(value="/ex08")
    public String thymeleafExample08(){
        return "thymeleafEx/thymeleafEx08";
    }

}
