-- 코드를 작성해주세요
select a.DEPT_ID, a.DEPT_NAME_EN, round(b.AVG_SAL, 0) as AVG_SAL
from HR_DEPARTMENT a join (
select AVG(SAL) as AVG_SAL, DEPT_ID
from HR_EMPLOYEES
group by DEPT_ID) b on a.DEPT_ID = b.DEPT_ID
order by AVG_SAL desc
