-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, 
count(DISTINCT USER_ID) as PURCHASED_USERS,
round(count(DISTINCT USER_ID) / 
      (select count(USER_ID) 
from USER_INFO
where JOINED between '2021-01-01' and '2021-12-31'), 1) as PUCHASED_RATIO
from ONLINE_SALE
where USER_ID in (
select USER_ID 
from USER_INFO
where JOINED between '2021-01-01' and '2021-12-31')
group by year, month
order by year, month