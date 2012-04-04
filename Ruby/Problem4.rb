
require 'numberwork'

def main
    highest = 0
    for n in 101..998
        for i in 101..998
            if isPalindrome( n * i ) and n * i > highest
                highest = n * i
            end
        end
    end
    puts highest
end

if __FILE__ == $0
    main
end
