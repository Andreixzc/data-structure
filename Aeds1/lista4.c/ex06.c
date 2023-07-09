#include <stdio.h>

void tarefa(int r)
{
    for (int e = 1; e <= r; e++)
        printf(" %d  ", r);
    printf("\n");
}

int main()
{
    int x;
    x = 5;
    for (int j = 1; j <= x; j++)
        tarefa(j);
}