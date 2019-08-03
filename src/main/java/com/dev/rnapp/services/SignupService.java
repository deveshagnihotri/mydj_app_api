package com.dev.rnapp.services;

import com.dev.rnapp.exception.SignupException;
import com.dev.rnapp.repositories.SignupRepository;
import com.dev.rnapp.domain.Signup_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

	@Autowired
	private SignupRepository signupRepository;
	
	public Signup_user saveOrUpdate(Signup_user signup_user) {

		try{
			signup_user.setUser_email(signup_user.getUser_email().toLowerCase());
			return signupRepository.save(signup_user);
		}catch (Exception e){
			throw new SignupException("Signup emailID '" + signup_user.getUser_email().toLowerCase() + " ' already exist");
		}


	}
}
