package com.psjava.oceantech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.psjava.oceantech.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'ocean': { $regex: ?0, $options: 'i' } }")
	List<Post> searchOcean(String text);
	
	List<Post> findByOceanContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'ocean': { $regex: ?0, $options: 'i' } }, { 'geoLocation': { $regex: ?0, $options: 'i' } }, { 'acidification': { $regex: ?0, $options: 'i' } }, { 'waterPh': { $regex: ?0, $options: 'i' } }, { 'audit.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
