def main
    @sum = 0
    for i in 3..999
        if i % 3 == 0 or i % 5 == 0
            @sum += i
        end
    end
    puts @sum
end

if __FILE__ == $0
    main
end
