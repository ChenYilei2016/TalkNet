package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenyilei
 * @date 2018/11/26-12:02
 * hello everyone
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult <T>{
    private Long total;
    private List<T> rows;
}
