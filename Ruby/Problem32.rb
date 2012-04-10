require 'numberwork'

def main
    products = Array.new
    for x in 1234..9876
        getDivisorPairs( x, true ).each do |pair|
            if isPandigital_1to9( x.to_s + pair.join )
                products.push( x )
                break
            end
        end
    end
    puts products.inject(:+)
end

if __FILE__ == $0
    main
end
