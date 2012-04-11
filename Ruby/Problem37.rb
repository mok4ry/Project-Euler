require 'numberwork'

def main
    lrTrunctable = [ 739397 ]  # manually found 739397
    primes = firstNprimes( 550 )[4..549]
    primes.each do |prime|
        if leftTruncPrimes( prime ) and rightTruncPrimes( prime )
            lrTrunctable.push( prime )
        end
    end
    puts lrTrunctable.inject(:+)
end

if __FILE__ == $0
    main
end

