package com.psjava.oceantech.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psjava.oceantech.model.Post;
import com.psjava.oceantech.controllers.util.URL;
import com.psjava.oceantech.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {

	@Autowired
	private PostService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/oceansearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByOcean(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByOcean(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
