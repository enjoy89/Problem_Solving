# 데이터 입력
n = int(input())

# 각 데이터를 공백을 기준으로 구분하여 문자열에서 정수형의 리스트형으로 재구성
data = list(map(int, input().split()))

data.sort(reverse=True)
print(data)

# 공백을 기준으로 3개의 문자를 입력 받고, 이를 정수형으로 재구성
a, b, c = map(int, input().split())

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
