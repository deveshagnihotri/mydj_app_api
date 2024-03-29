package com.dev.rnapp.web;

import com.dev.rnapp.domain.Signup_user;
import com.dev.rnapp.services.MapValidationErrorService;
import com.dev.rnapp.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/signup_user")
public class SignupController {

	@Autowired
	private SignupService signupService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody Signup_user signup_user, BindingResult result){

		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap!=null){
			return errorMap;
		}

		Signup_user signup_user1 = signupService.saveOrUpdate(signup_user);
		return new ResponseEntity<Signup_user>(signup_user1, HttpStatus.CREATED);
	}
}
