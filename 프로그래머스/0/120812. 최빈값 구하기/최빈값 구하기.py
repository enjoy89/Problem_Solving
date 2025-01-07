def solution(array):
    # 입력 받은 배열의 최대값 만큼 인덱스 배열을 생성한다
    max_index = max(array)
    frequency = [0] * (max_index + 1)

    for num in array:
        frequency[num] += 1

    max_frequency = max(frequency)

    # 최빈값이 여러개인지 검사
    count = 0
    for value in frequency:
        if value == max_frequency:
            count += 1

        if count == 2:
            return -1

    max_occurred_num = frequency.index(max(frequency))
    answer = max_occurred_num
    
    return answer