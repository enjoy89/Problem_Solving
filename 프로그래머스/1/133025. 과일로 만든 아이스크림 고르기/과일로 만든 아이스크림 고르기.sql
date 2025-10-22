-- 코드를 입력하세요
SELECT 
    i.FLAVOR
from FIRST_HALF h
join ICECREAM_INFO i 
    on h.FLAVOR = i.FLAVOR
where h.TOTAL_ORDER >= 3000
    and i.INGREDIENT_TYPE = 'fruit_based'
order by h.TOTAL_ORDER DESC;