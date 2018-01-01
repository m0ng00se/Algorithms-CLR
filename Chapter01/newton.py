#!/usr/bin/python

import math

# Solution for Problem 1.4.2.

# Return the next numerical iteration using Newton's method.
def newton(F, FP, x):
    return x - F(x)/FP(x)

# Returns value of 2^x - 100x^2 at x.
def F(x):
    y = math.pow(2, x) - 100 * x * x
    return y

# Returns value of derivative of 2^x - 100x^2 at x.
def FP(x):
    y = math.log(2) * math.pow(2,x) - 200 * x
    return y

# Return a new guess and the diff between new and old guesses
def guess(x0):
    x1 = newton(F, FP, x0)
    diff = abs(x0-x1)
    return (x1, diff)

def find_roots():
    tolerance = 0.01
    (x1, diff) = guess(20)
    while (diff > tolerance):
        (x1, diff) = guess(x1)
    return x1

print find_roots()


