package com.anatolik.quiz.security.dao;

import com.anatolik.quiz.security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Long>
{
}
