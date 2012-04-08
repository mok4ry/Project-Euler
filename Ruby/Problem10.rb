require 'numberwork'

def main
    sum, n = 2, 3
    while ( n < 2000000 )
        if isPrime( n )
            sum += n
        end
        n += 2
    end

    puts sum
end

if __FILE__ == $0
    main
end
