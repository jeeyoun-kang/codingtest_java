-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성
-- 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나
SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS WHERE NAME IS NOT NULL;