-- 코드를 입력하세요
select a.CAR_ID, a.CAR_TYPE, FLOOR(A.DAILY_FEE * 30 * (1 - B.DISCOUNT_RATE * 0.01)) as FEE
from CAR_RENTAL_COMPANY_CAR a join (
select DISCOUNT_RATE, CAR_TYPE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where DURATION_TYPE like '30%') b on a.CAR_TYPE = b.CAR_TYPE
where a.CAR_ID not in (
select CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01')
and (a.CAR_TYPE = 'SUV' or a.CAR_TYPE = '세단') and 
a.DAILY_FEE * 30 * (100-b.DISCOUNT_RATE) / 100 between 500000 and 2000000
order by FEE desc, CAR_TYPE, CAR_ID desc
