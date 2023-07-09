#include <stdio.h>
#include <stdlib.h>

#define M 5

void preencher(int *matriz[5][5]);
int soma_linha4(int *matriz[5][5]);
int coluna2(int *matriz[5][5]);
int diagonal_principal(int *matriz[5][5]);
int diagonal_secundaria(int *matriz[5][5]);
int soma_total(int *matriz[5][5]);

int main(void)
{

    int matriz[5][5];

    preencher(matriz);

    soma_linha4(matriz);

    coluna2(matriz);

    diagonal_principal(matriz);

    diagonal_secundaria(matriz);

    soma_total(matriz);
    return 0;
}

void preencher(int *matriz[5][5])
{
    int i, t;
    for (i = 0; i < M; i++)
    {
        for (t = 0; t < M; t++)
        {
            matriz[i][t] = (1 + rand() % 9);
        }
    }

    printf("\n\n");
    for (i = 0; i < M; i++)
    {
        for (t = 0; t < M; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n");
}

int soma_linha4(int *matriz[5][5])
{
    int i = 0, t = 0;
    int soma = 0;
    int soma2 = 0;

    printf("\nLinha 4\n");
    for (t = 0; t < 5; t++)
    {
        printf("|%i|", matriz[3][t]);
        soma = matriz[3][t];
        soma2 += soma;
    }

    printf("\nSoma linha 4 =%d\n", soma2);
    return soma2;
}

int coluna2(int *matriz[5][5])
{
    int i = 0, t = 0;
    int soma = 0;
    int soma2 = 0;

    printf("\nColuna 2\n");
    for (t = 0; t < 5; t++)
    {
        printf("|%i|", matriz[t][1]);
        soma = matriz[t][1];
        soma2 += soma;
    }

    printf("\nSoma da coluna 2 = %d\n", soma2);
    return soma2;
}

int diagonal_principal(int *matriz[5][5])
{
    int i = 0, t = 0;
    int soma = 0;
    int soma2 = 0;

    printf("\nDiagonal principal:\n");
    for (t = 0; t < 5; t++)
    {
        printf("|%i|", matriz[t][t]);
        soma = matriz[t][t];
        soma2 += soma;
    }

    printf("\nSoma da Diagonal principal = %d\n", soma2);
    return soma2;
}

int diagonal_secundaria(int *matriz[5][5])
{
    int i = 0, t = 0;
    int soma = 0;
    int soma2 = 0;

    printf("\nDiagonal Secundaria:\n");
    for (t = 0; t < 5; t++)
    {
        printf("|%i|", matriz[t][M - 1 - t]);
        soma = matriz[t][M - 1 - t];
        soma2 += soma;
    }

    printf("\nSoma da Diagonal Secundaria = %d\n", soma2);
    return soma2;
}

int soma_total(int *matriz[5][5])
{
    int i = 0, t = 0;
    int soma = 0;
    int soma2 = 0;

    for (i = 0; i < M; i++)
    {
        for (t = 0; t < M; t++)
        {

            soma = matriz[i][t];
            soma2 += soma;
        }
    }

    printf("\nSoma Total = %d\n", soma2);
    return soma2;
}