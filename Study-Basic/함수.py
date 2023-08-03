# 함수
def add(a, b):
    return a + b


print(add(1, 2))

# 전역 변수: global
a = 10


def func():
    global a
    a += 1
    print(a)


func()


# 여러 개의 반환 값
def operator(a, b):
    add = a + b
    multiply = a * b
    return add, multiply


a, b = operator(7, 3)
print(a, b)


# 람다 표현식
def add(a, b):
    return a + b


# 일반
print(add(3, 7))

# 람다 표현식으로 구현한 add() 메서드
print((lambda a, b: a + b)(3, 7))

arr = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]


# 람다 표현식 예시
def my_key(x):
    return x[1]


print(sorted(arr, key=my_key))
print(sorted(arr, key=lambda x: x[1]))

# 2개의 리스트의 각 원소의 합
list1 = [1, 2, 3]
list2 = [4, 5, 6]
result = map(lambda a, b: a + b, list1, list2)
print(list(result))

# 내장 함수
result = sum([1, 2, 3, 4, 5])
print(result)

# sorted()
result = sorted([9, 1, 5, 8, 4])
reverse_result = sorted([9, 1, 8, 5, 4], reverse=True)
print(result)
print(reverse_result)

# sorted() with key
arr = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]
result = sorted(arr, key=lambda x: x[1], reverse=True)
print(result)
