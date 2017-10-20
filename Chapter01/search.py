#!/usr/bin/python

def search(A, v):
    j = None
    for i in range(len(A)):
        if A[i] == v:
            j = i
            break
    return j
