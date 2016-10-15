/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.learn.bookpub.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.learn.bookpub.entity.RoomEntity;
import org.learn.bookpub.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Plain JPA based implementation of {@link CustomerRepository}.
 * 
 * @author Oliver Gierke
 */

@Component
@Repository
public class JpaRoomRepository implements RoomRepository {

	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@PersistenceContext
	public EntityManager em;

	
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		return entityManagerFactory;
	}


	public void setEntityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	//	/* 
//	 * (non-Javadoc)
//	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#findOne(java.lang.Long)
//	 */
//	@Override
//	public Customer findOne(Long id) {
//		return em.find(Customer.class, id);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#save(com.oreilly.springdata.jpa.core.Customer)
//	 */
//	
	public RoomEntity save(RoomEntity roomEntity) {
		System.out.println("roomEntity : " + roomEntity);
		em.persist(roomEntity);
		return roomEntity;
	}

	
	@Override
	public RoomEntity findByName(String name) {
		return em.find(RoomEntity.class, name);
	}
	
	@Override
	public RoomEntity findById(long id) {
		return em.find(RoomEntity.class, id);
	}
}


