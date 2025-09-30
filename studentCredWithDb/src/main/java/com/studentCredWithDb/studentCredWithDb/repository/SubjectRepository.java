package com.studentCredWithDb.studentCredWithDb.repository;

import com.studentCredWithDb.studentCredWithDb.model.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, ObjectId> {
}
