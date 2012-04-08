require 'numberwork'

def main
    n, count = 1, 2
    while true
        if n % 1 == 0 and n % 2 == 0 and n % 3 == 0 and n % 4 == 0 and n % 5 == 0
            if getDivisors( n ).size > 500
                break
            end
        end
        n += count
        count += 1
    end
    puts n
end

if __FILE__ == $0
    main
end
