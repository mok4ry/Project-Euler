def main
    sum = 2
    a1 = 1
    a2 = 2
    temp = 0
    while a1 + a2 < 4000000
        temp = a1 + a2
        if (temp) % 2 == 0
            sum += temp
        end
        a1, a2 = a2, temp
    end
    puts sum
end

if __FILE__ == $0
    main
end
