def main
    twoToThe1000 = 2
    999.times do
        twoToThe1000 *= 2
    end
    digits = twoToThe1000.to_s
    sum = 0
    digits.each_char do |char|
        sum += char.to_i
    end
    puts sum
end

if __FILE__ == $0
    main
end
