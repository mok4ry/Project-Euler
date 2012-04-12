require 'numberwork'

def main
    [ 1, 2, 3, 4, 5, 6, 7 ].permutation.sort.reverse.each do |pandig|
        num = pandig.join.to_i
        if isPrime( num )
            puts num
            return
        end
    end
end

if __FILE__ == $0
    main
end
