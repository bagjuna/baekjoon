-- 코드를 작성해주세요

SELECT 
    ROUND(SUM(CASE
        WHEN LENGTH is NULL THEN 10
              ELSE LENGTH
         END ) / count(*),2
) AS 'AVERAGE_LENGTH' 
from FISH_INFO;

