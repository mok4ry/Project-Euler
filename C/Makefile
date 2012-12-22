problem_file=$(shell ls -1 Problem*.c | sort | tail -n 1 )

problem: numberwork bignum
	gcc -o problem $(problem_file)

debug: numberwork
	gcc -g -o problem $(problem_file)
	gdb ./problem

numberwork:
	gcc -c Numberwork.c

bignum:
	gcc -c BigNum.c

clean:
	rm *.o problem
