package Dao;

import entity.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao {
    public School queryForSchoolName(String SchoolName);
}
