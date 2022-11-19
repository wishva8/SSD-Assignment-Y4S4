package com.ihub.janus.data.enums;

/**
 * The Enum AttachmentType.
 */
public enum AttachmentType {

	/** The image. */
	IMAGE(0, "IMAGE", "Image"),

	/** The document. */
	DOCUMENT(1, "DOCUMENT", "Document");

	/** The key. */
	private int key;

	/** The value. */
	private String value;

	/** The display value. */
	private String displayValue;

	/**
	 * Instantiates a new attachment type.
	 *
	 * @param key the key
	 * @param value the value
	 * @param displayValue the display value
	 */
	private AttachmentType(int key, String value, String displayValue) {
		this.key = key;
		this.value = value;
		this.displayValue = displayValue;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the display value.
	 *
	 * @return the display value
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * Sets the display value.
	 *
	 * @param displayValue the new display value
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

}
