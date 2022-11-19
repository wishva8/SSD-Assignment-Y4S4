package com.ihub.janus.app.service;

import com.ihub.janus.data.entity.Message;
import com.ihub.janus.data.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface MessageService {

    Message create(Message message);

    List<Message> getAll();

    public void delete(Long id);
}
