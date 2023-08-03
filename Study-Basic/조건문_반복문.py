# 1. 조건문
score = 75

if score >= 90:
    print("A")
elif score >= 80:
    print("B")
elif score >= 70:
    print("C")
else:
    print("F")

a = 15
if 0 <= a <= 20:
    print("Yes")

# pass 키워드
if a >= 0:
    pass
else:
    print("통과")

# 조건부 표현식
# 참일 경우 왼쪽, 거짓일 경우 else 문 오른쪽이 result 값에 들어감
score = 85
result = "Success" if score >= 80 else "Fail"
print(result)

# 2. 반복문
# while문
i = 1
result = 0
# i가 9보다 작거나 같을 때 반복적으로 실행
while i <= 9:
    result += i
    i += 1
print(result)

# 1부터 9까지 홀수의 합 구하기
i = 1
result = 0

while i <= 9:
    if i % 2 == 1:
        result += i
    i += 1
print(result)

# for문
arr = [1, 2, 3, 4, 5]
for i in arr:
    print(i)

result = 0
for i in range(1, 10):
    result += i
print(result)

# continue: 반복문에서 남은 코드의 실행을 건너뛰고, 다음 반복을 진행하고자 할 때 사용
result = 0
for i in range(1, 10):
    if (i % 2 == 0):
        continue
    result += i
print(result)

# break: 반복문을 즉시 탈출
i = 1
while True:
    print(i)
    if i == 5:
        break
    i += 1

# 점수가 80점만 넘으면 합격
scores = [50, 90, 77, 97]
for i in range(4):
    if scores[i] >=80:
        print(i + 1, "번 학생은 합격입니다.")

# 2중 반복문
# 구구단 예제
for i in range(2, 10):
    for j in range(1, 10):
        print(i, "X", j, "=", i*j)
    print()