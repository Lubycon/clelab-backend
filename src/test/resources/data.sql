INSERT INTO curriculum (id, title, description, thumbnail) VALUES (1, '제목', '설명', '썸네일')

INSERT INTO section (id, curriculum_id, description) VALUES (1, 1, '설명')

INSERT INTO blog (section_id, title, link) VALUES (1, '제목', '링크1')
INSERT INTO blog (section_id, title, link) VALUES (1, '제목2', '링크2')

INSERT INTO intro_section (id, curriculum_id, summary, description) VALUES (1, 1, '핵심 설명', '설명')

