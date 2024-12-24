def find_max_and_index(n):
    numbers = []

    for i in range(n):
        numbers.append(int(input()))

    max_value = max(numbers)
    max_index = numbers.index(max_value)

    print(max_value)
    print(max_index+1)

find_max_and_index(9)