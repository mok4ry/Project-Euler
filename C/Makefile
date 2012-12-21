problem_file=$(shell ls -1 Problem*.c | sort | tail -n 1 )

problem: numberwork
	gcc -o problem $(problem_file)

debug: numberwork
	gcc -g -o problem $(problem_file)
	gdb ./problem

numberwork:
	gcc -c Numberwork.c

clean:
	rm *.o problem
