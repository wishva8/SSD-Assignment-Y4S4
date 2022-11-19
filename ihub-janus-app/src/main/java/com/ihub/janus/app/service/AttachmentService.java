package com.ihub.janus.app.service;

import com.ihub.janus.data.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

@Service
@Transactional
public interface AttachmentService {

    Attachment create(Attachment attachment);

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
