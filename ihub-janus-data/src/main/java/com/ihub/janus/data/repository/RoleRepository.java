//SSD Assignment 2
package com.ihub.janus.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ihub.janus.data.entity.Role;

/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Query(value = "SELECT r FROM Role r WHERE r.voided = 0")
	List<Role> getAll();

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@Query(value = "SELECT r FROM Role r WHERE r.id=?1 AND r.voided = 0")
	Role getById(Long id);
}
