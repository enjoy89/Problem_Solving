# 정수 하나를 입력 받기
n = int(input()) # 한 줄을 읽어와서 정수로 변환
print(n)

# 정수 2개를 입력 받기
# 공백을 기준으로 문자를 분리하고, 이를 정수형 리스트로 형변환
# input.split(구분문자): 구분문자를 기준으로 문자를 나눈다.
# map(형식, 리스트): 리스트에 있는 데이터를 형식에 맞춰 변환
a, b = map(int, input().split())
print(a, b)

# 리스트를 통해 한 줄을 입력 받기
# 각 데이터를 공백을 기준으로 구분하여 문자열에서 정수형 리스트형으로 재구성
num = list(map(int, input().split()))
print(num)
num.sort(reverse=True) #내림차순 정렬
print(num)

# 빠르게 입력 받기
import sys

data = sys.stdin.readline().rstrip()
print(data)

# 줄바꿈 없이 출력하기
a = 1
b = 2
print(a, end=" ")
print(b, end=" ")

# f-string
answer = 7
print(f"정답은 {answer} 입니다.")
