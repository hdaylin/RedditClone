package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/22/17.
 */
public interface LinkRepository extends CrudRepository<Link, Long>{
    public List<Link> findAllByOrderByTimeStampAsc();
}
