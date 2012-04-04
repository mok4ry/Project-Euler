def main
    squareOfSum = ( ( 100 * 101 ) /2 ) ** 2
    sumOfSquares = 0
    for i in 1..100
        sumOfSquares += i**2
    end
    puts squareOfSum - sumOfSquares
end

if __FILE__ == $0
    main
end
