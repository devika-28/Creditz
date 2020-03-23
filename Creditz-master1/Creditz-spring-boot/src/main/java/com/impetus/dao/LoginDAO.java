package com.impetus.dao;
//package com.impetus.rms.dao;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.impetus.rms.model.Login;
//
//@Repository
//@Transactional
//public interface LoginDAO extends CrudRepository<Login, Long> {
//
//    @Query(value = "SELECT password FROM Login WHERE userEmail = :email", nativeQuery = true)
//    Login findByuser_email(Login email);
//
//    @Query(value = "SELECT role FROM Login WHERE userEmail = :email", nativeQuery = true)
//    Login findroleByuser_email(Login email);
//}
