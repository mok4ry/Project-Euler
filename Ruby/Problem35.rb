require 'numberwork'

def main
    num = 1  # separate case for 2 being prime
    n = 3
    while n < 1000000
        if isCircularPrime( n )
            num += 1
        end
        n += 2
    end
    puts num
end

if __FILE__ == $0
    main
end
