package com.prapps.app.core.dataaccess;

import org.springframework.data.repository.CrudRepository;

import com.prapps.app.core.persistence.BlogPostEntity;

public interface BlogRepository extends CrudRepository<BlogPostEntity, Long> {

}
