require 'numberwork'

def removeCommonDigit( n, d )
    n, d = n.to_s, d.to_s
    "123456789".each_char do |dig|
        if n.include?( dig ) && d.include?( dig ) && n != d
            if n.delete( dig ) == ""
                n = dig.to_f
            else
                n = n.delete( dig ).to_f
            end
            if d.delete( dig ) == ""
                d = dig.to_f
            else
                d = d.delete( dig ).to_f
            end
            return [ n, d ]
        end
    end
    return nil
end

def main
    curiousFracs = Array.new
    for a in 11..99
        for b in a..99
            n = removeCommonDigit( a, b )
            if n != nil && n[0]/n[1] == a.to_f/b.to_f
                curiousFracs.push( [ a, b ] )
            end
        end
    end
    n, d = 1, 1
    curiousFracs.each do |frac|
        n *= frac[0]
        d *= frac[1]
    end
    reduced = frac_Reduce( n, d )
    puts "Reduced fraction: #{reduced[0]} / #{reduced[1]}"
    puts "Denominator: #{reduced[1]}"
end



if __FILE__ == $0
    main
end
