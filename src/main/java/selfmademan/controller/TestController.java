package selfmademan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import selfmademan.domain.dto.UserDto;

@RestController
public class TestController {

    @GetMapping(value="/test")
    public UserDto test(){
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("hoon");

        return userDto;
    }
}
