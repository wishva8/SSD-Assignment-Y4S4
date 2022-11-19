package com.ihub.janus.data.repository;

import com.ihub.janus.data.entity.Attachment;
import com.ihub.janus.data.entity.Message;
import com.ihub.janus.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT m FROM Message m WHERE m.voided = 0")
    List<Message> getAll();

    @Query(value = "SELECT m FROM Message m WHERE m.id=?1 AND m.voided = 0")
    Message getById(Long id);
}
