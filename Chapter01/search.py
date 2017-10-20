#!/usr/bin/python

# Solution for Problem 3
def search(A, v):
    j = None
    for i in range(len(A)):
        if A[i] == v:
            j = i
            break
    return j
