import unittest
from numberwork import *

class test_numberwork( unittest.TestCase ):
    def test_getDivisors1(self):
        self.assertTrue(getDivisors(12) == [1, 2, 3, 4, 6, 12])
    
    def test_getDivisors2(self):
        self.assertTrue(getDivisors(-12) == [1, 2, 3, 4, 6, 12])
    
    def test_getProperDivisors1(self):
        self.assertTrue(getDivisors(12, proper=True) == [1, 2, 3, 4, 6])

    def test_getProperDivisors2(self):
        self.assertTrue(getDivisors(-12, proper=True) == [1, 2, 3, 4, 6])
    
    def test_isAbundantNumber1(self):
        self.assertTrue(isAbundantNumber(12))

    def test_isPerfectNumber1(self):
        self.assertTrue(isPerfectNumber(6))

    def test_isDeficientNumber1(self):
        self.assertTrue(isDeficientNumber(10))

if __name__ == "__main__":
    unittest.main()
