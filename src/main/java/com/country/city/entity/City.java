package com.country.city.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "cities")
public final class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8553285122871357902L;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}
*/
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	/*
	@Column(name = "creation_time", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	private ZonedDateTime creationTime;
	*/
	@Version
	private long version;
}
