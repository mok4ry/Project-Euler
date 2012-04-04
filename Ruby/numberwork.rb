
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

def isPrime( n )
    return getDivisors( n ).length == 2
end

# unsorted
def getDivisors( n )
    divisors = []
    limit = Integer( Math.sqrt( n ) + 0.5 )
    for i in 1...limit
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
    return n.to_s.reverse == n.to_s
end
