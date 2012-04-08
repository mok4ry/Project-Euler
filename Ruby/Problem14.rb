require 'numberwork'

def main
    h, hx = 0, 0
    for x in 800000..999999
        t = termsInCollatz( x )
        if t > h
            h = t
            hx = x
        end
    end
    puts hx
end

if __FILE__ == $0
    main
end
