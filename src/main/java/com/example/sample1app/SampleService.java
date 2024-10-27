package com.example.sample1app;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.sample1app.entities.Post;
import org.springframework.web.client.RestTemplate;

import com.example.sample1app.repositories.PostRepository;

@Service
public class SampleService {

  private String baseUrl = "https://jsonplaceholder.typicode.com/posts";

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  PostRepository repository;

  public Post[] getAllPosts() {
    return restTemplate.getForObject(baseUrl, Post[].class);
  }

  public Post getPost(int id) {
    return restTemplate.getForObject(baseUrl + "/" + id, Post.class);
  }

  public Object[] getLocalPosts() {
    return repository.findAll().toArray();
  }

  public Post getAndSavePost(int id) {
    Post post = restTemplate.getForObject(baseUrl + "/" + id, Post.class);
    repository.save(post);
    return post;
  }
}
