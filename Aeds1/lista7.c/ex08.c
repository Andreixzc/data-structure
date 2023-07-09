#include <stdio.h>
#include <stdlib.h>

void preencher(int *matriz[10][10]);
void trocar_linhas(int matriz[10][10]);
void trocar_coluna(int matriz[10][10]);
void trocar_diagonal(int matriz[10][10]);
void trocar_coluna_e_linha(int matriz[10][10]);

int main(void)
{
    int matriz[10][10];

    preencher(matriz);

    trocar_linhas(matriz);

    trocar_coluna(matriz);

    trocar_diagonal(matriz);

    trocar_coluna_e_linha(matriz);

    return 0;
}

void preencher(int *matriz[10][10])
{
    int i, t;

    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            matriz[i][t] = (1 + rand() % 9);
        }
    }
    printf("\n\n");
    printf("\n\n  Matriz inicial \n\n");
    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n\n");
}

void trocar_linhas(int matriz[10][10])
{
    int i, t;

    for (t = 0; t < 10; t++)
    {
        matriz[2][t] = matriz[8][t];
        matriz[8][t] = matriz[2][t];
    }

    printf("\n\n");
    printf("\n  Trocar a linha 2 com a linha 8\n\n");
    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n\n");
}
void trocar_coluna(int matriz[10][10])
{
    int i, t;

    for (t = 0; t < 10; t++)
    {
        matriz[t][3] = matriz[t][9];
        matriz[t][9] = matriz[t][3];
    }

    printf("\n\n");
    printf("\n Trocar a  coluna 4 com a coluna 10\n\n");
    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n\n");
}
void trocar_diagonal(int matriz[10][10])
{
    int i, t;

    for (t = 0; t < 10; t++)
    {
        matriz[t][t] = matriz[t][10 - 1 - t];
        matriz[t][10 - 1 - t] = matriz[t][t];
    }

    printf("\n\n");
    printf("\n  Trocar a  diagonal principal com a diagonal secundária\n\n");
    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n\n");
}

void trocar_coluna_e_linha(int matriz[10][10])
{
    int i, t;

    for (t = 0; t < 10; t++)
    {
        matriz[5][t] = matriz[t][9];
        matriz[t][9] = matriz[5][t];
    }

    printf("\n\n");
    printf("\n Trocar a  linha 5 com a coluna 10\n\n");
    for (i = 0; i < 10; i++)
    {
        for (t = 0; t < 10; t++)
        {
            printf("|%i|", matriz[i][t]);
        }
        printf("\n");
    }
    printf("\n\n");
}