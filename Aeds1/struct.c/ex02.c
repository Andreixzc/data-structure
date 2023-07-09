#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define tam 3
struct registro
{
    char nome[40];
    int telefone;
    float preco;
};
int main()
{
    srand(time(NULL));
    struct registro pessoa[tam];
    int i, j;
    float total = 0;
    float media = 0;
    for (i = 0; i < tam; i++)
    {
        printf("Nome:\n");
        scanf("%s", pessoa[i].nome);
        printf("Telefone:\n");
        scanf("%i", &pessoa[i].telefone);
        printf("Preco\n");
        scanf("%f", &pessoa[i].preco);
        // pessoa[i].preco= rand()%(500+1-100)+100;
        total = pessoa[i].preco + total;
    }
    media = total / tam;
    printf("Media dos precos:%f\n",media);
    printf("Abaixo da media:\n");
    for ( i = 0; i < tam; i++)
    {
        if (pessoa[i].preco<media)
        {
           printf("%s - %d\n", pessoa[i].nome, pessoa[i].telefone);

        }
        
    }
    
    
}