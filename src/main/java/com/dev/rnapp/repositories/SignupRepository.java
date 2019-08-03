package com.dev.rnapp.repositories;

import com.dev.rnapp.domain.Signup_user;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface SignupRepository extends CrudRepository<Signup_user, Long> {


}
