problem_file=$(shell ls -1 *.c | sort | tail -n 1 )

problem: numberwork
	gcc -o problem $(problem_file)

numberwork:
	gcc -c Numberwork.c

clean:
	rm *.o problem
