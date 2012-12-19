problem_num=$(shell expr `ls -1 *.c | wc -l` - 1 )

problem: numberwork
	gcc -o Problem$(problem_num) Problem$(problem_num).c

numberwork:
	gcc -c Numberwork.c

clean:
	rm *.o Problem$(problem_num)
