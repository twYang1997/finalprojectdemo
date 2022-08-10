package com.finaldemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.finaldemo.model.PostImg;
import com.finaldemo.model.PostImgRepository;
import com.finaldemo.model.Posts;
import com.finaldemo.model.PostsRepository;
import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class PhoebeService {

	// UsersService
	@Autowired
	private UsersRepository UsersRepository;

	// UserService
	public void signUp(Users user) {
		user.setPhotoPath("DefaultUserImage.png");
		UsersRepository.save(user);
	}

	public Users checkLogin(String email, String password) {
		return UsersRepository.selectUserByNameAndPwd(email, password);
	}

	// PostService
	@Autowired
	private PostsRepository PostsRepository;
	@Autowired
	private PostImgRepository PostImgRepository;

	public List<Posts> getPostsByUserId(Integer userId) {
		return PostsRepository.findPostsByUserId(userId);
	}

	public List<PostImg> getPostImgsByPostId(Integer postId) {
		return PostImgRepository.findPostImgsByPostId(postId);
	}

	public Posts addPost(Posts newPost) {
		return PostsRepository.save(newPost);
	}

	public void addPostImg(PostImg newImg) {
		PostImgRepository.addPostImgs(newImg.getPost().getPostId(), newImg.getPostImgPath());
	}

	public void editPost(Posts newPost) {
		PostsRepository.save(newPost);
	}

	public void deleteExtraImgs(Integer postId) {
		PostImgRepository.deleteImgByPostId(postId);
	}

	public void movePostToTrash(Integer whoCanSeeIt, Integer postId) {
		PostsRepository.changeWhoCanSeeItById(whoCanSeeIt, postId);
	}
	
	
}
