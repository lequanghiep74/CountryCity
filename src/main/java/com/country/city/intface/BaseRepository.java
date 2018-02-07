package com.country.city.intface;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
	void delete(T deleted);
	List<T> findAll();
	Optional<T> findById(ID id);
	<S extends T> S save(S entity);
}
