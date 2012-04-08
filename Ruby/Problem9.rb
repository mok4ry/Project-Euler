DELTA = 0.0001

def PythagTrip1000
    for a in 1..500
        for b in a..500
            c = Math.sqrt( a**2 + b**2 )
            diff = a + b + c - 1000
            if -DELTA < diff and diff < DELTA
                puts "#{a} #{b} #{c}"
                return a*b*c
            end
        end
    end
end

if __FILE__ == $0
    puts PythagTrip1000()
end
