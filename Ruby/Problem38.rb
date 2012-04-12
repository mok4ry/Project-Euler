require 'numberwork'

def main
    n = String.new
    valsToTest = Array.new

    for i in 9..9999
        if i.to_s[0..0] == "9"
            valsToTest.push( i )
        end
    end

    highest = 0

    valsToTest.each do |val|
        integer, n = 1, ""
        while n.length < 9
            n += (val*integer).to_s
            integer += 1
        end
        if n.length == 9 and isPandigital_1to9( n.to_i ) and n.to_i > highest
            highest = n.to_i
        end
    end

    puts highest
end

if __FILE__ == $0
    main
end
