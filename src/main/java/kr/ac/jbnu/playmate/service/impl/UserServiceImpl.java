package kr.ac.jbnu.playmate.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public Optional<User> getUserByLoginId(String LoginId){
		return userRepository.findByLoginId(LoginId);
	}
	
	@Transactional
	public boolean userLogin(String loginId,String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password)==null? true:false;
	}
	
	@Transactional
	public void joinUser(User user) {
		userRepository.save(user);
	}
}
