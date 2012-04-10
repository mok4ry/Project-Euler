
require 'set'

def firstNprimes( n )
    count = 1
    primes = [ 2 ]
    num = 3
    while count < n
        if isPrime( num )
            primes.push( num )
            count += 1
        end
        num += 2
    end
    return primes
end

def nthPrime( n )
    count = 1
    num = 3
    while count != n
        if isPrime( num )
            count += 1
        end
        num += 2
    end
    return num - 2
end

def nthTriangleNumber( n )
    return ( n * (n + 1) ) / 2
end

def termsInCollatz( n )
    i = 1
    while n != 1
        n % 2 == 0 ? n = n / 2 : n = 3 * n + 1
        i += 1
    end
    return i
end

def isPrime( n )
    limit = ( Math.sqrt( n ) + 0.5 ).to_i
    for i in 2..limit
        if n % i == 0
            return false
        end
    end
    return true
end

# unsorted
def getDivisors( n, proper=false )
    proper ? divisors = [ 1 ] : divisors = [ 1, n ]
    limit = Integer( Math.sqrt( n ) + 0.5 )
    for i in 2...limit
        if n % i == 0
            divisors.push( i )
            divisors.push( n / i )
        end
    end
    if n % limit == 0
        divisors.push( limit )
    end
    return divisors
end

def getDivisorPairs( n, proper=false )
    proper ? lowLim = 2 : lowLim = 1
    divisors = []
    limit = Integer( Math.sqrt( n ) + 0.5 )
    for i in lowLim...limit
        if n % i == 0
            divisors.push( [ i, n / i ] )
        end
    end
    if n % limit == 0
        divisors.push( [ limit, limit ] )
    end
    return divisors
end

# sorted
def getPrimeFactorization( n )
    pFact = SortedSet.new
    primes = firstNprimes( 1000 )
    primes.each do |prime|
        while n % prime == 0
            pFact.add( prime )
            n /= prime
        end
    end
    return pFact
end

def largestPrimeFactor( n )
    # TO DO: Figure out a way to determine how many primes need to be
    # calculated.
    primes = firstNprimes( 1000 ).sort.reverse
    primes.each do |prime|
        if n % prime == 0
            return prime
        end
    end
end

def isPalindrome( n )
    n = n.to_s
    return n.reverse == n
end

def isPythagTrip( a, b, c )
    return a**2 + b**2 == c**2
end

def factorial( n, low = 1 )
    return n.downto(low).inject(:*)
end

def isPandigital_1to9( n )
    n = n.to_s
    "123456789".each_char do |x|
        if !( n.include?( x ) )
            return false
        end
    end
    return n.length == 9
end
