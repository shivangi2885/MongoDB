package mypkg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mypkg.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
