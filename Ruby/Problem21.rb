
require 'numberwork'
require 'set'

def main
    amicableNums = Set.new
    for a in 2...10000
        if not amicableNums.include?( a )
            sumOfPropDivs = getDivisors( a, true ).inject(:+)
            sumOfPropDivs2 = getDivisors( sumOfPropDivs, true ).inject(:+)
            if sumOfPropDivs2 == a and sumOfPropDivs != a
                amicableNums.add( a )
                amicableNums.add( sumOfPropDivs )
            end
        end
    end
    puts amicableNums.to_a.inject(:+)
end

if __FILE__ == $0
    main
end
