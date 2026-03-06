select year(sales_date) as YEAR, month(sales_date) as MONTH,
count(DISTINCT user_id) as PURCHASED_USERS, round(count(distinct user_id) / (select count(user_id)
from user_info
where joined between '2021-01-01' and '2021-12-31'), 1) as PURCHASED_RATIO
from online_sale
where user_id in (
select  user_id
from user_info
where joined between '2021-01-01' and '2021-12-31')
group by year(sales_date), month(sales_date)
order by YEAR, MONTH