package com.psjava.oceantech.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.psjava.oceantech.domain.Post;
import com.psjava.oceantech.domain.User;
import com.psjava.oceantech.dto.AuthorDTO;
import com.psjava.oceantech.dto.CommentDTO;
import com.psjava.oceantech.repository.PostRepository;
import com.psjava.oceantech.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		User adelson = new User(null, "Adelson", "Scientist");
		User matheus = new User(null, "Matheus", "Scientist");
		User chiode = new User(null, "Chiode", "Manager");
		
		userReposiroty.saveAll(Arrays.asList(adelson, matheus, chiode));

		Post post1 = new Post(null, new Date(), "Pacific", "2.32.323", "42", "8.4", new AuthorDTO(adelson));
		Post post2 = new Post(null, new Date(), "Atlantic", "32.32.34.5", "42", "8.4", new AuthorDTO(adelson));

		CommentDTO c1 = new CommentDTO("40", "8.4", new Date(), new AuthorDTO(matheus));
		CommentDTO c2 = new CommentDTO("42", "8.3", new Date(), new AuthorDTO(chiode));
		CommentDTO c3 = new CommentDTO("46", "8.5", new Date(), new AuthorDTO(matheus));
		
		post1.getAudit().addAll(Arrays.asList(c1, c2));
		post2.getAudit().addAll(Arrays.asList(c3));
		
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
		adelson.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(adelson);
	}

}
