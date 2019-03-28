package MyImpl;

import entity.Customer;
import entity.CustomerExample;
import entity.CustomerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    long countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int insert(CustomerWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int insertSelective(CustomerWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    List<CustomerWithBLOBs> selectByExampleWithBLOBs(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int updateByExampleSelective(@Param("record") CustomerWithBLOBs record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") CustomerWithBLOBs record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 21 09:58:55 CST 2019
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);
}