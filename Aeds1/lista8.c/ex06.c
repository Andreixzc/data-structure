#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
    srand(time(NULL));
    int matriz[4][4];
    int i = 0;
    int j = 0;
    int sum = 0;
    for (i = 0; i < 4; i++)
    {
        for (j = 0; j < 4; j++)
        {
            matriz[i][j] = rand() % 100;
        }
    }
    printf("Diagonal principal:\n");
    for (i = 0; i < 4; i++)
    {
        for (j = 0; j < 4; j++)
        {
            if (i > j)
            {
                sum += matriz[i][j];
            }
            else if (i == j)
            {
                printf("%i\n", matriz[i][j]);
            }
        }
    }
    printf("Soma dos elemntos abaixo da diagonal principal: %i ", sum);
}