$DAYS_IN_MONTH = [ 31, nil, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ]

def main
    firstSundays = 0
    day = 2         # January 1, 1901 was a Monday
    for year in 1901..2000
        for month in 0..11
            if month == 1
                year % 4 == 0 and ( !(year % 100 == 0) or year % 400 == 0 ) ? \
                    day = (29 + day) % 7 : day = (28 + day) % 7
            else
                day = ($DAYS_IN_MONTH[ month ] + day) % 7
            end
            day == 0 ? firstSundays += 1 : nil
        end
    end

    puts firstSundays
end

if __FILE__ == $0
    main
end
