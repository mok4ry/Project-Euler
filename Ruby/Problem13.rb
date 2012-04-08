def main
    numbers = Array.new
    n = 0
    File.open( "Problem13.txt" ) do |fileIn|
        while ( line = fileIn.gets )
            numbers[n] = line.to_i
            n += 1
        end
    end
    s = numbers.inject(:+)
    f = s.to_s[0..9]
    puts "Sum: #{s}"
    puts "First ten digits: #{f}"
end

if __FILE__ == $0
    main
end
