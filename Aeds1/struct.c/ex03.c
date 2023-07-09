#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define tam 3
struct cadastro_de_cliente
{
    int codigo;
    char email[50];
    int horas;
    char pagina;
    float preco;
};
// // primeiras 20 horas de acesso é R$35,00 e as horas que excederam tem o custo de
// R$2,50 por hora. Para os clientes que têm página, adicionar R$40,00
int main()
{
    srand(time(NULL));
    int i, j;
    float aux = 0;
    struct cadastro_de_cliente pessoa[tam];
    for (i = 0; i < tam; i++)
    {
        printf("Codigo:\n");
        scanf("%i",&pessoa[i].codigo);
        fflush(stdin);
        printf("E-mail:\n");
        scanf("%s",pessoa[i].email);
        fflush(stdin);
        printf("Horas:\n");
        scanf("%i",&pessoa[i].horas);
        fflush(stdin);
        printf("Pagina S/N:\n");
        scanf("%c", &pessoa[i].pagina);
        fflush(stdin);
        //  pessoa[i].horas = rand()% (60+1-15)+15;
        //  pessoa[i].pagina = rand()% (2+1-1)+1;
    }
    for (i = 0; i < tam; i++)
    {
        if (pessoa[i].horas <= 20 || pessoa[i].pagina == 's')
        {
            pessoa[i].preco == 35 + 40;
            printf("O cliente %i pagou %f", i, pessoa[i].preco);
        }
        else if (pessoa[i].horas > 20 || pessoa[i].pagina == 's')
        {
            aux = pessoa[i].horas;
            aux - 20;
            pessoa[i].horas * 2.50;
            pessoa[i].preco = aux + pessoa[i].horas;
            pessoa[i].preco + 40;
            printf("O cliente %i pagou %f", i, pessoa[i].preco);
            aux = 0;
        }
        else if (pessoa[i].horas > 20 || pessoa[i].pagina == 'n')
        {
            aux = pessoa[i].horas;
            aux - 20;
            pessoa[i].horas * 2.50;
            pessoa[i].preco = aux + pessoa[i].horas;
            printf("O cliente %i,  pagou %f\n", i, pessoa[i].preco);
            // printf("CLIENTE %i, EMAIL %s, CODIGO: %i PAGOU %i",i,pessoa[i].email,pessoa[i].codigo,pessoa[i].preco);
            aux = 0;
        }
    }
}