def main
    grid = initGrid()
    highest = getHighestProductVert( grid )
    hpHoriz = getHighestProductHoriz( grid )
    hpDiag = getHighestProductDiag( grid )
    if hpHoriz > highest
        highest = hpHoriz
    end
    if hpDiag > highest
        highest = hpDiag
    end

    puts highest
end

def initGrid
    counter = 0
    grid = Array.new( 20 )
    File.open( "Problem11.txt" ) do |fileIn|
        while( line = fileIn.gets )
            grid[ counter ] = Array.new
            line.split.each do |str|
                grid[ counter ].push( str.to_i )
            end
            counter += 1
        end
    end
    return grid
end

def getHighestProductVert( g )
    h = 0
    for column in 0..19
        for start in 0..16
            p = g[column][start] * g[column][start + 1] * g[column][start + 2]\
                * g[column][start + 3]
            if p > h
                h = p
            end
        end
    end
    return h
end

def getHighestProductHoriz( g )
    h = 0
    g.each do |row|
        for start in 0..16
            p = row[start] * row[start + 1] * row[start + 2] * row[start + 3]
            if p > h
                h = p
            end
        end
    end
    return h
end

def getHighestProductDiag( g )
    x, y, h = 0, 0, 0
    17.times do |n|
        x = n
        y = 0
        while x < 17
            p = g[x][y] * g[x+1][y+1] * g[x+2][y+2] * g[x+3][y+3]
            if p > h
                h = p
            end
            x += 1
            y += 1
        end
    end
    17.times do |n|
        x = 0
        y = n
        while y < 17
            p = g[x][y] * g[x+1][y+1] * g[x+2][y+2] * g[x+3][y+3]
            if p > h
                h = p
            end
            x += 1
            y += 1
        end
    end
    17.times do |n|
        x = n + 3
        y = 0
        while x > 2
            p = g[x][y] * g[x-1][y+1] * g[x-2][y+2] * g[x-3][y+3]
            if p > h
                h = p
            end
            x -= 1
            y += 1
        end
    end
    17.times do |n|
        x = 19
        y = n
        while y < 17
            p = g[x][y] * g[x-1][y+1] * g[x-2][y+2] * g[x-3][y+3]
            if p > h
                h = p
            end
            x -= 1
            y += 1
        end
    end

    return h
end

if __FILE__ == $0
    main
end
