package com.ihub.janus.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ihub.janus.data.entity.Attachment;

/**
 * The Interface AttachmentRepository.
 */
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Query(value = "SELECT a FROM Attachment a WHERE a.voided = 0")
	List<Attachment> getAll();

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@Query(value = "SELECT a FROM Attachment a WHERE a.id=?1 AND a.voided = 0")
	Attachment getById(Long id);
}
