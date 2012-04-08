$HUNDREDS = [ 0, 10, 10, 12, 11, 11, 10, 12, 12, 11 ]
$TENS = [ 0, 0, 6, 6, 5, 5, 5, 7, 6, 6 ]
$TEENS = [ 6, 6, 8, 8, 7, 7, 9, 8, 8 ]
$ONES = [ 0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3 ]
$AND = 3

def main
    total = 0
    for n in 1..1000
        total += lettersInNumber( n )
    end
    puts total
end

def lettersInNumber( n )
    if n == 1000
        return 11
    end
    letters = 0
    ones = n % 10
    teens = n % 100
    tens = (teens - ones) / 10
    hundreds = (n - teens) / 100
    if teens < 11
        letters += $ONES[ teens ]
    elsif teens < 20
        letters += $TEENS[ teens - 11 ]
    else
        letters += $TENS[ tens ] + $ONES[ ones ]
    end
    if hundreds > 0
        letters += $HUNDREDS[ hundreds ]
        if teens > 0
            letters += $AND
        end
    end
    return letters
end

if __FILE__ == $0
    main
end
