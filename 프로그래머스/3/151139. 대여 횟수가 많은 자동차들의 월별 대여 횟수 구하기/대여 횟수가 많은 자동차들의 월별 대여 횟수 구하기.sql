-- 코드를 입력하세요
-- 1. 8-10월까지 총 대여 횟수가 5회 이상인 자동차들에서 (서브 쿼리로 처리)
-- 2. 위 결과에 대해 월별 자동차 ID 별 총 대여 횟수
-- 3. 서브 쿼리에서 CAR_ID만 뽑은 거니까 밖에서 한번 더 날짜 filtering해야 함.


SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
        AND CAR_ID IN 
        (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
            GROUP BY CAR_ID
            HAVING COUNT(CAR_ID) >= 5
        )
GROUP BY CAR_ID, MONTH
HAVING RECORDS >= 1
ORDER BY MONTH ASC, CAR_ID DESC
;