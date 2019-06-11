package Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "operation")//value值代表id
public class OperationServiceImpl {
//    @Resource(name = "lowerOperation")
    private LowerOperation Loperation;
    private UpperOperation Uoperation;

    public UpperOperation getUoperation() {
        return Uoperation;
    }
    @Autowired
    public void setUoperation(UpperOperation uoperation) {
        Uoperation = uoperation;
    }

    public LowerOperation getLoperation() { return Loperation; }

    @Autowired
    public void setLoperation(LowerOperation loperation) {
        Loperation = loperation;
    }

    public String tryMyspringOperation (String str){
       return Uoperation.operate(str);
    }
}
