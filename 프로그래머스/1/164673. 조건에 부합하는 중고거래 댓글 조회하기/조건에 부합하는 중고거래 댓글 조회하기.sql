-- 코드를 입력하세요
SELECT 
    board.TITLE, 
    board.BOARD_ID, 
    reply.REPLY_ID, 
    reply.WRITER_ID, 
    reply.CONTENTS, 
    DATE_FORMAT(reply.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
from USED_GOODS_BOARD board
join USED_GOODS_REPLY reply
    on board.BOARD_ID = reply.BOARD_ID
where board.CREATED_DATE >= '2022-10-01'
AND board.CREATED_DATE < '2022-11-01'
ORDER BY reply.CREATED_DATE, board.TITLE
;