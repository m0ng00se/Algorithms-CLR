#!/usr/bin/python

# Solution for Problem 1.4.1.

import math

def newton(F, dF, x):
    """ Return next numerical iteration using Newton's method. """
    return x - F(x)/dF(x)

def F(x):
    """ Value of 64x*lg(x) - 8x^2 """
    return 64*x*math.log(x) - 8*math.pow(x,2)

def dF(x):
    """ Value of derivative of 64x*lg(x) - 8x^2. """
    return 64*math.log(x) + 64 - 16*x

def find_root(F, dF, initial_guess, tolerance):
    """ Find root using Newton's method to specified tolerance, using initial guess. """
    def guess(x0):
        x1 = newton(F, dF, x0)
        diff = abs(x0-x1)
        return (x1,diff)

    # Iterate until we obtain a result within tolerance.
    (x1,diff) = guess(initial_guess)
    while (diff > tolerance):
        (x1, diff) = guess(x1)
    return x1

# Find the root
print find_root(F, dF, 20, 0.01)
