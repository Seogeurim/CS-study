# BaekJoon no. 14888 
# 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A1, A2, ..., AN이 주어진다. 
# (1 ≤ Ai ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 
import itertools
# store the input
num = int(input())
numList = list(map(int, input().split(" ")))
[add, minu, mul, div] = list(map(int, input().split(" ")))

# first try : brute force using itertools => time over
# operator = []
# for _ in range(add):
#     operator.append(0)
# for _ in range(minu):
#     operator.append(1)
# for _ in range(mul):
#     operator.append(2)
# for _ in range(div):
#     operator.append(3)

# possibility = list(itertools.permutations(operator))
# minR = float("inf")
# maxR = float("-inf")
# while possibility:
#     op = possibility.pop()
#     result = numList[0]
#     for i in range(num-1):
#         if op[i] == 0:
#             result += numList[i+1]
#         elif op[i] == 1:
#             result -= numList[i+1]
#         elif op[i] == 2:
#             result *= numList[i+1]
#         else:
#             if result < 0:
#                 result = -((-result)//numList[i+1])
#             else:
#                 result //= numList[i+1]
#     if result < minR:
#         minR = result
#     if result > maxR:
#         maxR = result
# print(minR)
# print(maxR)
# ===========================================================================================================================================================
# second try : brute force using DFS (recursive)

maxR = float("-inf")
minR = float("inf")

def dfs(n, result, add, minu, mul, div):
    global maxR, minR
    if n == num:
        maxR = max(maxR, result)
        minR = min(minR, result)
        return
    if add:
        dfs(n+1, result+numList[n], add-1, minu, mul, div)
    if minu:
        dfs(n+1, result-numList[n], add, minu-1, mul, div)
    if mul:
        dfs(n+1, result*numList[n], add, minu, mul-1, div)
    if div:
        if result < 0:
            result = -((-result)//numList[n])
        else:
            result //= numList[n]
        dfs(n+1, result, add, minu, mul, div-1)

dfs(1, numList[0], add, minu, mul, div)

print(maxR)
print(minR)

# ===========================================================================================================================================================
# 위 첫번째 시도로 실패한 이유
# itertool을 사용해서 순열을 생성할때, 동일한 순열이 생성되는데 이에 대해 고려하지 않음.
# 그래서 이거 고려해서 set로 만들고하면?
# third try : brute force using itertools => time over
# 이러면 틀렸다 뜨는데 이유가 뭘까?
# operator = []
# for _ in range(add):
#     operator.append(0)
# for _ in range(minu):
#     operator.append(1)
# for _ in range(mul):
#     operator.append(2)
# for _ in range(div):
#     operator.append(3)

# possibility = list(itertools.permutations(operator))
# possibility = list(set(possibility))
# minR = float("inf")
# maxR = float("-inf")
# while possibility:
#     op = possibility.pop()
#     result = numList[0]
#     for i in range(num-1):
#         if op[i] == 0:
#             result += numList[i+1]
#         elif op[i] == 1:
#             result -= numList[i+1]
#         elif op[i] == 2:
#             result *= numList[i+1]
#         else:
#             if result < 0:
#                 result = -((-result)//numList[i+1])
#             else:
#                 result //= numList[i+1]
#     if result < minR:
#         minR = result
#     if result > maxR:
#         maxR = result
# print(minR)
# print(maxR)