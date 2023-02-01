package com.iesvalleinclan.SpringAPP.repositories;

import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import com.iesvalleinclan.SpringAPP.models.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
