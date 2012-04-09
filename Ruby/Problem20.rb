require 'numberwork'

def main
    sum = 0
    factorial( 100 ).to_s.each_char do |char|
        sum += char.to_i
    end
    puts sum
end

if __FILE__ == $0
    main
end
