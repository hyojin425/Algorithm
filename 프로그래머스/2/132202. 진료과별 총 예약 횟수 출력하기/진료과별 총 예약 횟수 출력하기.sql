-- 코드를 입력하세요
SELECT MCDP_CD as '진료과 코드', COUNT(APNT_NO) as '5월예약건수'
FROM APPOINTMENT
WHERE APNT_YMD >= '2022-05-01'and APNT_YMD < '2022-06-01'
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_NO) ASC,
    MCDP_CD ASC;