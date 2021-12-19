package com.lubycon.curriculum.domain.section.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.domain.blog.domain.Blog;
import com.lubycon.curriculum.domain.section.domain.Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class SectionRepositoryTest extends RepositoryTest {

  @Autowired
  private SectionRepository sectionRepository;

  @Sql("/make-curriculum.sql")
  @DisplayName("findById() 테스트")
  @Test
  public void findById() {
    final Section findSection = sectionRepository.findById(1L).get();

    final Blog findBlog = findSection.getBlogs().get(0);
    assertThat(findBlog.getTitle()).isEqualTo("1번 섹션의 블로그 제목1");
    assertThat(findBlog.getLink()).isEqualTo("1번 섹션의 블로그 링크1");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("커리큘럼의 아이디와 섹션 아이디로 해당하는 섹션을 찾을 수 있다.")
  @Test
  public void findByCurriculumIdAndSectionIdTest() {
    final Section findSection = sectionRepository.findByCurriculumIdAndId(1L, 300L).get();

    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 3번 섹션입니다.");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("커리큘럼의 아이디와 정렬 순서로 해당하는 섹션을 찾을 수 있다.")
  @Test
  public void findByCurriculumIdAndOrderTest() {
    final Section findSection = sectionRepository.findByCurriculumIdAndOrder(1L, 2).get();

    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션3");
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 3번 섹션입니다.");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("findSectionBySlug() 테스트")
  @Test
  public void findSectionBySlugTest() {
    final Section findSection = sectionRepository.findSectionBySlug("curriculum-1", "one").get();
    assertThat(findSection.getTitle()).isEqualTo("1번 커리큘럼의 섹션1");
    assertThat(findSection.getDescription()).isEqualTo("1번 커리큘럼의 1번 섹션입니다.");
  }
}