package hxy.hbao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String password;

    public UserInfo(String name,Integer age,String password){
        this.name = name;
        this.age = age;
        this.password = password;
    }
    public UserInfo(Integer age,String password){

        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserInfo = [");
        builder.append("id:");
        builder.append(this.id);

        builder.append(" name:");
        builder.append(this.name);

        builder.append(" age:");
        builder.append(this.age);

        if (this.password != null) {
            builder.append(" password:");
            builder.append(this.password);
        }

        return builder.toString();
    }
}
