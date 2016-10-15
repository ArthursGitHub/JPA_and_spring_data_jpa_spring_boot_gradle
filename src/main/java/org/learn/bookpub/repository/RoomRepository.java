package org.learn.bookpub.repository;

import org.learn.bookpub.entity.RoomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface RoomRepository extends Repository<RoomEntity, Long> {

	@Query("select r from RoomEntity r where r.name = ?1")
	RoomEntity findByName(String name);
	
	RoomEntity findById(long id);	

}
