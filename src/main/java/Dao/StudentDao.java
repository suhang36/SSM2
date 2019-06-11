package Dao;

import entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {
    List<Student> select();
}
