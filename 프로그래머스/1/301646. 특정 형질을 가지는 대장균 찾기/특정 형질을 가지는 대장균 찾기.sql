-- 코드를 작성해주세요

SELECT count(*) AS COUNT 
    from ECOLI_DATA 
    where (GENOTYPE & 2) = 0
    AND (GENOTYPE & 1 OR GENOTYPE & 4) ;