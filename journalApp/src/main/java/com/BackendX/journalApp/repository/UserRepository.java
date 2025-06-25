package com.BackendX.journalApp.repository;

import com.BackendX.journalApp.entity.JournalEntry;
import com.BackendX.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.yaml.snakeyaml.events.Event;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);

    void deleteByUserName(String username);

}
