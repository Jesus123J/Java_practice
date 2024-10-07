package com.idevExpert.testWebSocket.Repository;

import com.idevExpert.testWebSocket.data.entity.PersonTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa extends JpaRepository<PersonTb,Long> {
}
