#include <stdlib.h>
#include <stdio.h>
#include "Numberwork.c"

#define GRID_DIM (20)
#define SIZE_OF_EACH_NUM (2)

#define NEW_NUM (0)
#define FIRST_DIGIT_READ (1)
#define SECOND_DIGIT_READ (2)

int highest_vertical_prod( int **grid );
int highest_horiz_prod( int **grid );
int highest_left_right_diag_prod( int **grid );
int highest_right_left_diag_prod( int **grid );

int **read_grid();

int main() {
    int **grid = read_grid();
    int highest_product = 0, temp_highest;

    highest_product = highest_vertical_prod( grid );
    temp_highest = highest_horiz_prod( grid );
    if ( temp_highest > highest_product ) {
        highest_product = temp_highest;
    }

    temp_highest = highest_left_right_diag_prod( grid );
    if ( temp_highest > highest_product ) {
        highest_product = temp_highest;
    }

    temp_highest = highest_right_left_diag_prod( grid );
    if ( temp_highest > highest_product ) {
        highest_product = temp_highest;
    }

    printf( "\nThe greatest product of four adjacent numbers is %d\n\n",
        highest_product );
}

int highest_vertical_prod( int **grid ) {
    int highest = 0, c, r, curr_product;

    for ( r = 0; r < GRID_DIM - 3; r++ ) {
        for ( c = 0; c < GRID_DIM; c++ ) {
            curr_product = grid[r][c] * grid[r+1][c] * grid[r+2][c] *
                grid[r+3][c];
            if ( curr_product > highest ) {
                highest = curr_product;
            }
        }
    }
    return highest;
}

int highest_horiz_prod( int **grid ) {
    int highest = 0, c, r, curr_product;

    for ( r = 0; r < GRID_DIM; r++ ) {
        for ( c = 0; c < GRID_DIM - 3; c++ ) {
            curr_product = grid[r][c] * grid[r][c+1] * grid[r][c+2] *
                grid[r][c+3];
            if ( curr_product > highest ) {
                highest = curr_product;
            }
        }
    }
    return highest;
}

int highest_left_right_diag_prod( int **grid ) {
    int highest = 0, c, r, curr_product;

    for ( r = 0; r < GRID_DIM - 3; r++ ) {
        for ( c = 0; c < GRID_DIM - 3; c++ ) {
            curr_product = grid[r][c] * grid[r+1][c+1] * grid[r+2][c+2] *
                grid[r+3][c+3];
            if ( curr_product > highest ) {
                highest = curr_product;
            }
        }
    }
    return highest;
}

int highest_right_left_diag_prod( int **grid ) {
    int highest = 0, c, r, curr_product;

    for ( r = 0; r < GRID_DIM - 3; r++ ) {
        for ( c = 3; c < GRID_DIM; c++ ) {
            curr_product = grid[r][c] * grid[r+1][c-1] * grid[r+2][c-2] *
                grid[r+3][c-3];
            if ( curr_product > highest ) {
                highest = curr_product;
            }
        }
    }
    return highest;
}

int **read_grid() {
    int **grid_row = malloc( sizeof(int *) * GRID_DIM );
    int c = 0, r = 0;
    char status = NEW_NUM;
    char *num_buffer = malloc( SIZE_OF_EACH_NUM );
    char in_char;

    while( r < 20 ) {
        grid_row[r] = malloc( sizeof(int) * GRID_DIM );
        c = 0;
        while( c < 20 ) {
            in_char = getchar();
            if ( status == NEW_NUM ) {
                num_buffer[0] = in_char;
                status = FIRST_DIGIT_READ;
            } else if ( status == FIRST_DIGIT_READ ) {
                num_buffer[1] = in_char;
                status = SECOND_DIGIT_READ;
            } else {  // status == SECOND_DIGIT_READ
                grid_row[r][c] = char_array_to_int( num_buffer,
                    SIZE_OF_EACH_NUM );
                status = NEW_NUM;
                c++;
            }
        }
        r++;
    }

    return grid_row;
}
