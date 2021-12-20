package com.lubycon.curriculum.domain.blog.repository;

import com.lubycon.curriculum.domain.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
