package Service.impl;

import Dao.MySpringOperation;
import org.springframework.stereotype.Service;

@Service//初始化一个bean
public class UpperOperation implements MySpringOperation {
    @Override
    public String operate(String str) {
        return str.toUpperCase();
    }
}
