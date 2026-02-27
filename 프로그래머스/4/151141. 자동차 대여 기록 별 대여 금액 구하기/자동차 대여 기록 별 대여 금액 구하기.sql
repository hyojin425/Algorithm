-- 코드를 입력하세요
SELECT c.HISTORY_ID, round((c.duration * c.DAILY_FEE) * (100 - IFNULL(DISCOUNT_RATE, 0)) / 100, 0) as FEE
from (
select b.DAILY_FEE, a.HISTORY_ID, 
    DATEDIFF(end_date, start_date) + 1 AS duration,
case 
when datediff(a.end_date, a.start_date) + 1 >= 90 then '90일 이상'
when datediff(a.end_date, a.start_date) + 1 >= 30 then '30일 이상'
when datediff(a.end_date, a.START_DATE) + 1 >= 7 then '7일 이상'
end as DURATION_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a join CAR_RENTAL_COMPANY_CAR b
on a.CAR_ID = b.CAR_ID 
where b.CAR_TYPE = '트럭') c 
                           left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
                           on p.DURATION_TYPE = c.DURATION_TYPE and p.CAR_TYPE = '트럭'
order by FEE desc, HISTORY_ID desc