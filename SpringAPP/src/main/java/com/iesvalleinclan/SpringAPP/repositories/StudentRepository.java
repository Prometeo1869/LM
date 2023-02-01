package com.iesvalleinclan.SpringAPP.repositories;

import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import com.iesvalleinclan.SpringAPP.models.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
