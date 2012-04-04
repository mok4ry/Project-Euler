def divBy1to20( n )
    for i in 11...20
        if n % i != 0
            return false
        end
    end
    return true
end

def main
    start = 46360
    until divBy1to20( start )
        start += 380
    end
    puts start
end

if __FILE__ == $0
    main
end;
;
