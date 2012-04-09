def main
    p = Array.new
    File.open( "Problem18.txt" ) do |fileIn|
        i = 0
        while line = fileIn.gets
            p.push( Array.new )
            line.split.each do |num|
                p[ i ].push( num.to_i  )
            end
            i += 1
        end
    end

    13.downto 0 do |i|
        for x in 0...p[i].size
            p[i+1][x] > p[i+1][x+1] ? \
                p[i][x] += p[i+1][x] : \
                p[i][x] += p[i+1][x+1]
        end
    end

    puts p[0][0]
end

if __FILE__ == $0
    main
end
