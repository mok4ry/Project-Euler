require 'numberwork'
require 'set'

$FIRST_1000_PRIMES = firstNprimes( 1000 )

def main
    num = 10000
    n = firstOfFour( num, 0 )
    while not n == 4
        num += n + 1
        n = firstOfFour( num, 0 )
    end
    puts num
end

def firstOfFour( s, i )
    if i == 4
        return i
    end

    if getPFact( s ).size == 4
        return firstOfFour( s + 1, i + 1 )
    end

    return i
end

def getPFact( n )
    pFact = SortedSet.new
    $FIRST_1000_PRIMES[0..Math.sqrt(n)].each do |prime|
        while n % prime == 0
            pFact.add( prime )
            n /= prime
        end
        n == 1 ? break : nil
    end
    return pFact
end

if __FILE__ == $0
    main
end
