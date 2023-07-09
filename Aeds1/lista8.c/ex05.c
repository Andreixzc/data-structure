#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void preencheMatriz(int matriz[5][5])
{
    srand(time(NULL));
    int i, j = 0;
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 5; j++)
        {
            matriz[i][j] = rand() % 100;
        }
    }
}
void calculoMatriz(int matriz[5][5])
{
    int linha4 = 0;
    int linha2 = 0;
    int dp = 0;
    int ds = 0;
    int i, j = 0;
    int tot = 0;
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 5; j++)
        {
            if (i == 3)
            {
                linha4 += matriz[i][j];
            }
            if (i == 1)
            {
                linha2 += matriz[i][j];
            }
            if (i == j)
            {
                dp += matriz[i][j];
            }
            if (i + j == 4)
            {
                ds += matriz[i][j];
            }
            tot += matriz[i][j];
        }
    }
    printf("Soma da linha 4:%i\n",linha4);
    printf("Soma da linha 2:%i\n",linha2);
    printf("Soma da diagonal Principal: %i\n",dp);
    printf("Soma da diagonal secundaria: %i\n",ds);
    printf("Soma de todos os elementos:%i\n",tot);
}

int main()
{

    int matriz[5][5];
    preencheMatriz(matriz);
    calculoMatriz(matriz);
}