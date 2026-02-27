-- 코드를 작성해주세요
select count(a.FISH_TYPE) as FISH_COUNT, MAX(a.LENGTH) as MAX_LENGTH, a.FISH_TYPE
from FISH_INFO a join (select FISH_TYPE, AVG(
    case when LENGTH is null then 10 else length end) as avg
from FISH_INFO
group by FISH_TYPE
having avg >= 33) b on a.FISH_TYPE = b.FISH_TYPE
group by a.FISH_TYPE
order by a.FISH_TYPE