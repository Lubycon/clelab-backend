INSERT INTO curriculum (id, title, description, thumbnail) VALUES (1, '1번 커리큘럼의 제목', '1번 커리큘럼의 설명', '1번 커리큘럼의 썸네일')

INSERT INTO section (id, curriculum_id, order_by, title, description) VALUES (1, 1, 0, '1번 커리큘럼의 섹션1', '1번 커리큘럼의 1번 섹션입니다.')
INSERT INTO section (id, curriculum_id, order_by, title, description) VALUES (2, 1, 1, '1번 커리큘럼의 섹션2', '1번 커리큘럼의 2번 섹션입니다.')

INSERT INTO blog (id, section_id, title, link) VALUES (1, 1, '1번 섹션의 블로그 제목1', '1번 섹션의 블로그 링크1')
INSERT INTO blog (id, section_id, title, link) VALUES (2, 1, '1번 섹션의 블로그 제목2', '1번 섹션의 블로그 링크2')
INSERT INTO blog (id, section_id, title, link) VALUES (3, 2, '2번 섹션의 블로그 제목1', '2번 섹션의 블로그 링크1')

INSERT INTO intro_section (id, curriculum_id, summary, description) VALUES (1, 1, '1번 커리큘럼의 핵심 설명', '1번 커리큘럼의 설명')