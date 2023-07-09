#include <stdio.h>
#include <stdlib.h>
struct registro
{
    char nome[50];
    char endereco[50];
    int telefone;
};

int main ()
{
    struct registro cliente[2];
    for (int i = 0; i < 2; i++)
    {
        printf("NOME:\n");
        scanf("%s", cliente[i].nome);
        printf("ENDERECO:\n");
        scanf("%s",cliente[i].endereco);
        printf("TELEFONE:\n");
        scanf("%i",&cliente[i].telefone);
    }
    

}