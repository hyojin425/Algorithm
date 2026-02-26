-- 코드를 작성해주세요
with RECURSIVE GEN as (
select ID, PARENT_ID, 1 as GENERATION
from ECOLI_DATA
where PARENT_ID is null 

union all 

select b.ID, b.PARENT_ID, a.GENERATION + 1
from ECOLI_DATA b
join GEN a on a.ID = b.PARENT_ID)

select COUNT(*) as COUNT, g.GENERATION
from GEN g
left join ECOLI_DATA c 
on g.ID = c.PARENT_ID
where c.ID is null
group by g.GENERATION
order by g.GENERATION
