select a.EMP_NO, a.EMP_NAME, 
case 
    when AVG(b.SCORE) >= 96 then 'S'
    when AVG(b.SCORE) >= 90 then 'A'
    when AVG(b.SCORE) >= 80 then 'B' else 'C'
    end as 'GRADE',
case 
    when AVG(b.SCORE) >= 96 then a.SAL * 0.2
    when AVG(b.SCORE) >= 90 then a.SAL * 0.15
    when AVG(b.SCORE) >= 80 then a.SAL * 0.1 else 0
    end as 'BONUS'
from HR_EMPLOYEES a join HR_GRADE b on a.EMP_NO = b.EMP_NO
group by a.EMP_NO
order by a.EMP_NO