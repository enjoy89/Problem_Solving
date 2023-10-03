# 1. 실수형 비교
# round() 함수 사용
a = 0.3 + 0.6
a_1 = round(a, 1)  # a를 소수 둘째 자리에서 반올림
print(a)  # 0.899999999999999
print(a_1)  # 0.9

if a == 0.9:
    print(True)
else:
    print(False)

if a_1 == 0.9:
    print(True)
else:
    print(False)

# 2. 자료형의 연산
a = 7
b = 3

# 나누기
print(a / b)

# 나머지
print(a % b)

# 몫
print(a // b)

# 몫과 나머지
div, mod = divmod(a, b)
print(div, mod)

# 거듭 제곱
print(a ** b)

# 제곱근
print(a ** 0.5)

# 3. 리스트 자료형
a = [1, 2, 3, 4, 5]
print(a)

print(a[2])  # 세 번째 원소에 접근
print(a[-1])  # 뒤에서 첫 번째 원소에 접근

# 리스트 슬라이싱
# 시작 인덱스 : 끝 인덱스 + 1
print(a[0:3])  # 첫 번째 원소부터 두 번째 원소까지 출력

# 리스트 초기화
a = [0] * 10  # 0으로 초기화 된 10칸 짜리 리스트 생성
print(a)

# 리스트 컴프리헨션(초기화)
list = [i for i in range(10)]  # 0부터 9까지의 수를 포함하는 리스트
print(list)

list = [i for i in range(1, 11)]  # 1 ~ 10까지 포함
print(list)

# 0 ~ 20까지의 수 중에서 홀수만 포함하는 리스트 생성 (컴프리헨션)
list = [i for i in range(20) if i % 2 == 1]  # 0~19까지의 수 중에서 홀수만 포함하는 리스트
print(list)

# 일반적인 방법
list = []
for i in range(20):
    if i % 2 == 1:
        list.append(i)  # append(): 리스트에 원소를 하나 삽입할 때 사용
print(list)

list = [i * i for i in range(1, 10)]  # 1~9까지의 수들의 제곱값을 포함하는 리스트
print(list)

# 2차원 리스트 초기화
# 4 X 3
n = 4
m = 3
list = [[0] * m for _ in range(n)]  # 언더바_: 반복을 수행하되 반복을 위한 변수의 값을 무시할 때 사용 -> 단순 반복 작업

# 1부터 9까지의 자연수 더하기
sum = 0
for i in range(1, 10):
    sum += i
print(sum)

# "hello"를 5번 출력하기
for _ in range(5):
    print("hello")

# 리스트 관련 메서드
a = [1, 4, 3]

# 원소 삽입
a.append(2)
print(a)

# 오름차순 정렬
a.sort()
print("오름차순 정렬: ", a)

# 내림차순 정렬
a.sort(reverse=True)
print("내림차순 정렬: ", a)

# 원소 뒤집기
a.reverse()
print("원소 뒤집기: ", a)

# 특정 인덱스에 데이터 추가
a.insert(2, 3)
a.insert(2, 1)
print("인덱스 2에 3 추가: ", a)

# 특정 값 데이터 개수 세기
print("값이 3인 데이터 개수: ", a.count(3))

# 특정 값 데이터 삭제
a.remove(1)
print("값이 1인 데이터 삭제: ", a)

# 특정 값을 가지는 원소 모두 삭제
b = [1, 2, 2, 3, 3, 4, 5]
remove_set = {2, 3}
result = [i for i in b if i not in remove_set]
print(result)

# 4. 문자열 자료형
print('\"Hello\"')

# 문자열 연산
a = "ABCDEF"
print(a[2:4])  # 인덱스 2부터 3까지
str1 = "Hello"
str2 = "World"
print(str1 + " " + str2)

# 5. 튜플 자료형 - 서로 다른 성질의 데이터를 묶어서 관리해야 할 때 사용
# 리스트보다 메모리를 효율적으로 사용해야 할 때
# Hashing의 키 값으로 사용해야할 때
a = (1, 2, 3, 4, 5)

# 6. 사전 자료형
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

data = {
    '사과': 'Apple',
    '바나나': 'Banana',
    '코코넛': 'Coconut'
}

# 키 데이터만 담은 리스트
key_list = data.keys()
# 값 데이터만 담은 리스트
value_list = data.values()

print(key_list)
print(value_list)
print(data['사과'])

# 각 키에 따른 값을 하나씩 출력
for key in key_list:
    print(data[key])

# 6. 집합 자료형
# 순서가 없고, 중복을 허용하지 않음
data = set([1, 2, 3])
data = {1, 2, 3, 4, 4}
print(data)

# 새로운 원소 추가
data.add(7)
print(data)

# 새로운 원소 여러개 추가
data.update([5, 6])
print(data)

# 특정한 값을 갖는 원소 삭제
data.remove(3)
print(data)
