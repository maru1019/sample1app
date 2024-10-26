package com.example.sample1app;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.sample1app.entities.Post;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleService {

  private String baseUrl = "https://jsonplaceholder.typicode.com/posts";

  @Autowired
  RestTemplate restTemplate;

  public Post[] getAllPosts() {
    return restTemplate.getForObject(baseUrl, Post[].class);
  }

  public Post getPost(int id) {
    return restTemplate.getForObject(baseUrl + "/" + id, Post.class);
  }
}
