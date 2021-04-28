package com.lubycon.curriculum.blog.repository;

import com.lubycon.curriculum.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
