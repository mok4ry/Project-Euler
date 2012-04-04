
def main
    number = ""
    File.open( "Problem8.txt" ) do |infile|
        while( line = infile.gets )
            number += line[0...50] # 0-49 (ignore newline)
        end
    end
    
    start, highest = 0, 0
    while start < 995
        thisNum = 1
        number[ start ... start + 5 ].split('').each do |digit|
            thisNum *= digit.to_i
        end
        if thisNum > highest
            highest = thisNum
        end
        start += 1
    end
    puts highest
end

if __FILE__ == $0
    main
end
