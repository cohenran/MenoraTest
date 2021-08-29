package com.menora.envelope_reader.dal;

import com.menora.envelope_reader.model.db.RequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, String> {
	Optional<RequestEntity> findById(String requestDetailsId);
}
