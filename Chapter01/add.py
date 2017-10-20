#!/usr/bin/python

def add(A, B, n):
    A_ = A[:]; A_.reverse()
    B_ = B[:]; B_.reverse()
    C = [0] * (n+1)
    for i in range(n):
        sum_ = A_[i] + B_[i] + C[i]
        C[i] = int(sum_%2)
        C[i+1] = int(sum_/2)
    C.reverse()
    return C
