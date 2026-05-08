-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, b.PUBLISHED_DATE from BOOK b join AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID where b.CATEGORY = '경제' order by b.PUBLISHED_DATE;