-- 코드를 입력하세요
SELECT fh.FLAVOR from FIRST_HALF fh 
    join ICECREAM_INFO ii 
    ON fh.FLAVOR = ii.FLAVOR 
    WHERE fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based' 
    ORDER BY fh.TOTAL_ORDER DESC;