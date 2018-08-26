package com.example.hadoop.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hadoop.domain.Message;
@Repository
public interface RedisRespository extends JpaRepository<Message, Long>{

}
