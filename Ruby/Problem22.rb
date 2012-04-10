$ALPHABETIC_SCORES = Hash[ 'A', 1, 'B', 2, 'C', 3, 'D', 4, 'E', 5, 'F', 6, \
                           'G', 7, 'H', 8, 'I', 9, 'J', 10, 'K', 11, 'L', 12, \
                           'M', 13, 'N', 14, 'O', 15, 'P', 16, 'Q', 17, \
                           'R', 18, 'S', 19, 'T', 20, 'U', 21, 'V', 22, \
                           'W', 23, 'X', 24, 'Y', 25, 'Z', 26, '"', 0 ]

def main
    score = 0
    names = Array.new
    File.open( "Problem22.txt" ) do |fileIn|
        line = fileIn.gets
        line.split(",").each do |name|
            names.push( name )
        end
    end

    names = names.sort

    for i in 0...names.size
        score += ( i + 1 ) * wordScore( names[i] )
    end
    puts score
end

def wordScore( name )
    score = 0
    name.each_char do |char|
        score += $ALPHABETIC_SCORES[ char ]
    end
    return score
end

if __FILE__ == $0
    main
end
