package com.example.sample1app;

import org.springframework.stereotype.Service;
import com.example.sample1app.entities.Post;

@Service
public class SampleService {

  public Post getPost() {
    return new Post(0, 0, "Dummy", "This is sample.");
  }
}
