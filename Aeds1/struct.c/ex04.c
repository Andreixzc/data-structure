#include <stdio.h>
#include <stdlib.h>
#define tam 1500
struct livros
{
    int codigo;
    char donate;
    char nomeObra[30];
    char autor[30];
    char editora[30];
    int area;
};

int main()
{
    int i, j;
    struct livros vol[tam];
    int v1[1500];
    int v2[1500];
    int v3[1500];
    for (i = 0; i < tam; i++)
    {
        printf("Codigo:\n");
        scanf("%i", &vol[i].codigo);
        fflush(stdin);
        printf("Doacao? S/N:\n");
        scanf("%c", &vol[i].donate);
        fflush(stdin);
        printf("Nome Da Obra:\n");
        scanf("%s", vol[i].nomeObra);
        fflush(stdin);
        printf("Autor:\n");
        scanf("%s", vol[i].autor);
        fflush(stdin);
        printf("Editora:\n");
        scanf("%s", vol[i].editora);
        fflush(stdin);
        printf("Area\n1-exatas\n2 -humanas\n3-biologias\n");
        scanf("%i", &vol[i].area);
    }
    for (i = 0; i < tam; i++)
    {
        if (vol[i].area == 1)
        {
            v1[i] = vol[i].area;
        }
        else if (vol[i].area == 2)
        {
            v2[i] = vol[i].area;
        }
        else if (vol[i].area == 3)
        {
            v3[i] = vol[i].area;
        }
    }

    printf("Consulta:\n");
    int aux1;
    int aux2;
    for (i = 0; i < tam; i++)
    {
        printf("CODIGO:");
        scanf("%i", &aux1);
        if (aux1 == -1)
        {
            break;
        }
        printf("Area:");
        scanf("%i", &aux2);
        if (aux1 == vol[i].codigo || aux2 == vol[i].area)
        {
            printf("Dados do livro:\n Doacao:%c\n Nome da obra:%s\n Nome do autor:%s\n Editora:%s\n", vol[i].donate, vol[i].nomeObra, vol[i].autor, vol[i].editora);
        }
    }
}
