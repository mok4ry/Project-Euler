# First time run (Champernowne constant file not written): use -w option

def main
    d = String.new
    File.open( "Problem40.txt" ).each do |line|
        d = line
    end

    puts d[0].chr.to_i * d[9].chr.to_i * d[99].chr.to_i * d[999].chr.to_i * \
         d[9999].chr.to_i * d[99999].chr.to_i * d[999999].chr.to_i
end

def wDigFile
    d = String.new
    for x in 1..185185
        d += x.to_s
    end
    File.open( "Problem40.txt", 'w' ) { |f| f.write( d ) }
    
    main
end

if __FILE__ == $0
    ARGV[0] == "-w" ? wDigFile : main
end
