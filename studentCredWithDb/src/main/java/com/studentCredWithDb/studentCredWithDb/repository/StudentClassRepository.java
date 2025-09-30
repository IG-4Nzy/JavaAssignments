package com.studentCredWithDb.studentCredWithDb.repository;

import com.studentCredWithDb.studentCredWithDb.model.StudentClass;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends MongoRepository<StudentClass, ObjectId> {
}
