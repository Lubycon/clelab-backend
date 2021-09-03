INSERT INTO curriculum (id, title, description, thumbnail, is_show, url_slug) VALUES (1, '1번 커리큘럼의 제목', '1번 커리큘럼의 설명', '1번 커리큘럼의 썸네일', 1, 'curriculum-1')

INSERT INTO section (id, curriculum_id, order_by, title, description, url_slug) VALUES (1, 1, 0, '1번 커리큘럼의 섹션1', '1번 커리큘럼의 1번 섹션입니다.', 'one')
INSERT INTO section (id, curriculum_id, order_by, title, description, url_slug) VALUES (2, 1, 1, '1번 커리큘럼의 섹션2', '1번 커리큘럼의 2번 섹션입니다.', 'two')
INSERT INTO section (id, curriculum_id, order_by, title, description, url_slug) VALUES (105, 1, 3, '1번 커리큘럼의 섹션4', '1번 커리큘럼의 4번 섹션입니다.', 'four')
INSERT INTO section (id, curriculum_id, order_by, title, description, url_slug) VALUES (300, 1, 2, '1번 커리큘럼의 섹션3', '1번 커리큘럼의 3번 섹션입니다.', 'three')

INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (1, 1, '1번 섹션의 블로그 제목1', '1번 섹션의 블로그 링크1', 0, 1, 'a')
INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (2, 1, '1번 섹션의 블로그 제목2', '1번 섹션의 블로그 링크2', 0, 2, 'b')
INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (3, 2, '2번 섹션의 블로그 제목1', '2번 섹션의 블로그 링크1', 0, 1, 'c')
INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (4, 300, '3번 섹션의 블로그 제목1', '3번 섹션의 블로그 링크1', 0, 1, 'a')
INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (5, 300, '3번 섹션의 블로그 제목3', '3번 섹션의 블로그 링크3', 1, 3, 'a')
INSERT INTO blog (id, section_id, title, link, clelab_pick, order_by, writer) VALUES (6, 300, '3번 섹션의 블로그 제목2', '3번 섹션의 블로그 링크2', 1, 2, 'a')

INSERT INTO major_company_frequency (id, title, naver, kakao, line, coupang, woowabros, toss, daangn, yanolja) VALUES (0, '메이저 회사는 React를 얼마나 사용하고 있을까요?', true, false, true, true, true, false, true, true)

INSERT INTO google_trend (id, title, csv_html) VALUES (0, '구글 트렌드 지표', '<p>안녕하세요</p>')

INSERT INTO stack_overflow_trend (id, title, description, image_path) VALUES (0, '스택오버플로우 트렌드', 'StackOverflow Trends', '스택오버플로우 이미지링크')

INSERT INTO intro_section (id, curriculum_id, major_company_frequency_id, google_trend_id, stack_overflow_trend_id, summary, sub_summary, header, footer) VALUES (1, 1, 0, 0, 0, '1번 커리큘럼의 핵심 설명', '1번 커리큘럼의 핵심 설명2222', '헤더', '푸터')

INSERT INTO statistical_info (id, intro_section_id, title, description) VALUES (0, 1, '관련 Github 레포지토리 수', 'Github Public Repositories')

INSERT INTO statistical_value (id, statistical_info_id, keyword, value, course_topic) VALUES (0, 0, 'React', '220만', true)
INSERT INTO statistical_value (id, statistical_info_id, keyword, value, course_topic) VALUES (1, 0, 'Angular', '77만', false)
INSERT INTO statistical_value (id, statistical_info_id, keyword, value, course_topic) VALUES (2, 0, 'Vue', '55만', false)