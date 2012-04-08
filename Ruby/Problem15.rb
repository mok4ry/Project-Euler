def main
    fact40 = 40.downto(1).inject(:*)
    fact20 = 20.downto(1).inject(:*)
    puts fact40 / ( fact20 ** 2 )
end

if __FILE__ == $0
    main
end
