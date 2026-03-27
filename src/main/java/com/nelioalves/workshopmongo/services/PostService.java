package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.dto.CommentDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
	}
	
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	
	public Post insertComments(String id,CommentDTO dto) {
		Post obj = findById(id);
		obj.getComments().add(dto);
		return postRepository.save(obj);
	}
	
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
		
	}

}
