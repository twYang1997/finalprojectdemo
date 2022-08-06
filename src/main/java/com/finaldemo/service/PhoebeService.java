package com.finaldemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Posts;
import com.finaldemo.model.PostsRepository;
import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class PhoebeService {
	
	//UsersService
	@Autowired
	private UsersRepository UsersRepository;
	
	@Autowired
	private PostsRepository PostsRepository;
	
	public void signUp(Users user) {
		user.setPhotoPath("DefaultUserImage.png");
		UsersRepository.save(user);
	}
	
	public Users checkLogin(String email, String password) {
		return UsersRepository.selectUserByNameAndPwd(email, password);
	}
	
	//PostService
	public Posts addPost(Posts newPost) {
		return PostsRepository.save(newPost);
		
	}
}
