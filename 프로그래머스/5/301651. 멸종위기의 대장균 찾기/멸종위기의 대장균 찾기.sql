with recursive gen as (
    select id, 1 as GENERATION
    from ecoli_data
    where parent_id is null
    
    union all
    
    select a.id, b.GENERATION + 1 as GENERATION  
    from ecoli_data a join gen b 
    on a.parent_id = b.id
)

select count(*) as COUNT, GENERATION
from gen
where id not in(select parent_id from ecoli_data where parent_id is not null)
group by generation
order by generation

