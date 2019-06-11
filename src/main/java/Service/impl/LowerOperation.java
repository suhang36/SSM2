package Service.impl;

import Dao.MySpringOperation;
import org.springframework.stereotype.Service;

@Service //告诉spring这是一个service层的bean
public class LowerOperation implements MySpringOperation {
    @Override
    public String operate(String str) {
        return str.toLowerCase();
    }
}
