select a.CAR_ID, a.CAR_TYPE,round(a.daily_fee * 30 * ((100 - b.discount_rate) / 100), 0) as FEE
from car_rental_company_car a join (
select car_type, discount_rate
from car_rental_company_discount_plan
where duration_type like '30일%') b on a.car_type = b.car_type

where car_id not in(
select car_id
from car_rental_company_rental_history
where start_date <= '2022-11-30' and end_date >= '2022-11-01')

and (a.car_type = '세단' or a.car_type = 'SUV')
and a.daily_fee * 30 * ((100 - b.discount_rate) / 100) between 500000 and 2000000
order by fee desc, car_type, car_id desc
