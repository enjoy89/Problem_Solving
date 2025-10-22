-- 코드를 입력하세요
SELECT
    d.DR_NAME,
    d.DR_ID,
    d.MCDP_CD,
    DATE_FORMAT(d.HIRE_YMD, '%Y-%m-%d') as HIRE_YMD
from DOCTOR d
where d.MCDP_CD in ('CS', 'GS')
order by d.HIRE_YMD DESC, d.DR_NAME ASC;


