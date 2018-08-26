package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Message;
/**
 * dao层
 * @author Administrator
 *
 */
@Repository
public interface DemoDao extends JpaRepository<Message, Long>{
}
