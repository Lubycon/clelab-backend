package com.lubycon.curriculum.domain.section.dto;

import com.lubycon.curriculum.domain.curriculum.dto.QuizResponse;
import com.lubycon.curriculum.domain.section.domain.Section;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class SectionResponse {

  @NotNull
  private final String title;

  @Nullable
  private final String description;

  private final int order;

  @NotNull
  private final String thumbnail;

  @NotNull
  private final List<BlogResponse> blogs;

  @Nullable
  private final NextSectionResponse nextSection;

  @Nullable
  private final PrevSectionResponse prevSection;

  @Nullable
  private final List<QuizResponse> quizzes;

  @Builder
  public SectionResponse(@NotNull final String title, @Nullable final String description,
      final int order,
      @NotNull final List<BlogResponse> blogs, @Nullable final NextSectionResponse nextSection,
      @Nullable final PrevSectionResponse prevSection, @NotNull final String thumbnail,
      @Nullable final List<QuizResponse> quizzes) {
    this.title = title;
    this.description = description;
    this.order = order;
    this.blogs = blogs;
    this.nextSection = nextSection;
    this.prevSection = prevSection;
    this.thumbnail = thumbnail;
    this.quizzes = quizzes;
  }

  public static SectionResponse toResponse(final Section section,
      final List<QuizResponse> quizzes,
      final PrevSectionResponse prevSection,
      final NextSectionResponse nextSection) {
    return SectionResponse.builder()
        .title(section.getTitle())
        .description(section.getDescription())
        .order(section.getOrder())
        .blogs(section.getBlogs().stream()
            .map(BlogResponse::new)
            .collect(Collectors.toList()))
        .prevSection(prevSection)
        .nextSection(nextSection)
        .thumbnail(section.getCurriculum().getThumbnail())
        .quizzes(quizzes)
        .build();
  }
}
