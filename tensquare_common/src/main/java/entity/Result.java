package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chenyilei
 * @date 2018/11/25-20:15
 * hello everyone
 */

@Data
@AllArgsConstructor
public class Result {
    private boolean flag;//是否成功
    private Integer code;// 返回码
    private String message;//返回信息
    private Object data;// 返回数据
    public Result(){

    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
