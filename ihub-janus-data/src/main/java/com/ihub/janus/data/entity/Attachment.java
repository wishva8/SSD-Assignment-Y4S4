//SSD Assignment 2
package com.ihub.janus.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.ihub.janus.data.enums.AttachmentStatus;
import com.ihub.janus.data.enums.AttachmentType;
import com.ihub.janus.data.view.Views;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Attachment.
 */
@Entity
@Table(name = "attachment")
@Getter
@Setter
public class Attachment extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 0;

	/** The name. */
	@NotNull
	@Column(name = "name")
	@JsonView(Views.Attachment.class)
	private String name;

	/** The status. */
	@Column(name = "status")
	@JsonView(Views.Attachment.class)
	private AttachmentStatus status;

	/** The type. */
	@Column(name = "type")
	@JsonView(Views.Attachment.class)
	private AttachmentType type;

	/** The description. */
	@Column(name = "description")
	@JsonView(Views.Attachment.class)
	private String description;

	/** The path. */
	@NotNull
	@Column(name = "path")
	@JsonView(Views.Attachment.class)
	private String path;

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Attachment [name=" + name + ", status=" + status + ", type=" + type + ", description=" + description
				+ ", path=" + path + "]";
	}

}
