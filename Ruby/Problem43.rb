=begin
Pencil and paper wor pre-coding:
Let d1 be the first digit, d2 be the second digit, etc.
    d4d5d6 must be divisible by 5, so d6 must be either 0 or 5.
    d6 cannot be 0, because d6d7d8 needs to be divisible by 11 and if d6 is 0,
        d7 = d8 (the number is not pandigital)
    d6 = 5 => d6d7d8 ?= 506 517 528 539 561 572 583 594
    => d7d8d9 ?= 065 286 390 728 832
    => d6d7d8d9 ?= 5286 5390 5728 5832
    => d8d9d10 ?= 867 901 289
    => d6d7d8d9d10 ?= 52867 53901 57289
    => d5d6d7d8d9d10 ?= 952867 (1,3,4,0 left over) 357289 (1,4,0,6 left over)
=end


require 'numberwork'

$PRIMES = firstNprimes( 7 )

def main
    panDigNums = Array.new
    perms = [ 1, 3, 4, 0 ].permutation
    perms.each do |perm|
        numString = perm.join + "952867"
        if perm[0] != 0 and eachThreeDiv( numString )
            panDigNums.push( numString.to_i )
        end
    end
    perms = [ 1, 4, 6, 0 ].permutation
    perms.each do |perm|
        numString = perm.join + "357289"
        if perm[0] != 0 and eachThreeDiv( numString )
            panDigNums.push( numString.to_i )
        end
    end
    puts panDigNums.inject(:+)
end

def eachThreeDiv( n )
    pIndex = 0
    for x in 1..7
        if !( n[x..x+2].to_i % $PRIMES[ pIndex ] == 0 )
            
            return false
        end
        pIndex += 1
    end
    return true
end

if __FILE__ == $0
    main
end
