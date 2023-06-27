package com.geekster.employeemanagementsystem.repositories;

import com.geekster.employeemanagementsystem.models.HR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHRDao extends CrudRepository<HR,Long> {

}
