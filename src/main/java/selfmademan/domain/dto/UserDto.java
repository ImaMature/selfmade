package selfmademan.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
public class UserDto {
    private String name;
    private Integer age;

    public UserDto(){

    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        String var10000 = this.getName();
        return "UserDto(name=" + var10000 + ", age=" + this.getAge() + ")";
    }

}
