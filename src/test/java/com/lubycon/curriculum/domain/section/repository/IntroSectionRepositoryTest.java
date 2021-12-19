package com.lubycon.curriculum.domain.section.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.lubycon.curriculum.base.RepositoryTest;
import com.lubycon.curriculum.domain.section.domain.GoogleTrend;
import com.lubycon.curriculum.domain.section.domain.IntroSection;
import com.lubycon.curriculum.domain.section.domain.MajorCompanyFrequency;
import com.lubycon.curriculum.domain.section.domain.StackOverflowTrend;
import com.lubycon.curriculum.domain.section.domain.StatisticalInfo;
import com.lubycon.curriculum.domain.section.domain.StatisticalValue;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class IntroSectionRepositoryTest extends RepositoryTest {

  @Autowired
  private IntroSectionRepository introSectionRepository;

  @Sql("/make-curriculum.sql")
  @DisplayName("메이저 회사 사용빈도 OneToOne() 테스트")
  @Test
  public void majorCompanyFrequencyOneToOneTest() {
    final IntroSection findIntroSection = introSectionRepository.findById(1L).get();
    final MajorCompanyFrequency majorCompanyFrequency = findIntroSection.getMajorCompanyFrequency();

    assertThat(majorCompanyFrequency.isNaver()).isTrue();
    assertThat(majorCompanyFrequency.isKakao()).isFalse();
    assertThat(majorCompanyFrequency.isLine()).isTrue();
  }


  @Sql("/make-curriculum.sql")
  @DisplayName("구글 트렌드 OneToOne() 테스트")
  @Test
  public void googleTrendOneToOneTest() {
    final IntroSection findIntroSection = introSectionRepository.findById(1L).get();
    final GoogleTrend googleTrend = findIntroSection.getGoogleTrend();

    assertThat(googleTrend.getTitle()).isEqualTo("구글 트렌드 지표");
    assertThat(googleTrend.getCsvHtml()).isEqualTo("<p>안녕하세요</p>");
  }

  @Sql("/make-curriculum.sql")
  @DisplayName("스택오버플로우 트렌드 OneToOne() 테스트")
  @Test
  public void stackOverflowTrendOneToOneTest() {
    final IntroSection findIntroSection = introSectionRepository.findById(1L).get();
    final StackOverflowTrend stackOverflowTrend = findIntroSection.getStackOverflowTrend();

    assertThat(stackOverflowTrend.getTitle()).isEqualTo("스택오버플로우 트렌드");
    assertThat(stackOverflowTrend.getDescription()).isEqualTo("StackOverflow Trends");
    assertThat(stackOverflowTrend.getImagePath()).isEqualTo("스택오버플로우 이미지링크");
  }


  @Sql("/make-curriculum.sql")
  @DisplayName("통계 정보 OneToMany() 테스트")
  @Test
  public void statisticsOneToManyTest() {
    final IntroSection findIntroSection = introSectionRepository.findById(1L).get();
    final StatisticalInfo statisticalInfo = findIntroSection.getStatisticalInfo().get(0);
    assertThat(statisticalInfo.getTitle()).isEqualTo("관련 Github 레포지토리 수");
    assertThat(statisticalInfo.getDescription()).isEqualTo("Github Public Repositories");

    final List<StatisticalValue> statisticalValues = statisticalInfo.getStatisticalValues();
    final StatisticalValue react = statisticalValues.get(0);
    assertThat(react.getKeyword()).isEqualTo("React");
    assertThat(react.getValue()).isEqualTo("220만");
    assertThat(react.isCourseTopic()).isTrue();

    final StatisticalValue vue = statisticalValues.get(2);
    assertThat(vue.getKeyword()).isEqualTo("Vue");
    assertThat(vue.getValue()).isEqualTo("55만");
    assertThat(vue.isCourseTopic()).isFalse();
  }

}