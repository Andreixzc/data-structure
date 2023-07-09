/*Faça um procedimento que recebe 3 valores inteiros por parâmetro e os exiba em ordem 
crescente. Faça um programa que leia N conjuntos de 3 valores e acione o procedimento
para cada conjunto. (N deve ser lido do teclado)*/
#include <stdlib.h>
#include <stdio.h>
void Pcrescente(int a, int b, int c)//procedimento que agrupa a ordem dos numeros em ordem crescente
{
    if (a < b && b < c)
    {
        printf("%i %i %i\n", a, b, c);
    }
    else if (a < c && c < b)
    {
        printf("%i %i % i\n", a, c, b);
    }
    else if (b < a && a < c)
    {
        printf("%i %i %i\n", b, a, c);
    }
    else if (b < c && c < a)
    {
        printf("%i%i%i\n", b, c, a);
    }
    else if (c < a && a < b)
    {
        printf("%i %i %i\n", c, a, b);
    }
    else
    {
        printf("%i %i %i\n", c, b, a);
    }
}

int main()
{
    int n1, n2, n3, n;
    char op;
    while (op != 'N')
    {
        printf("Digite o primeiro numero:\n");
        scanf("%i", &n1);//armazena o primeiro numero
        printf("Digite o segundo numero:\n");
        scanf("%i", &n2);//armazena o segundo numero
        printf("Digite o terceiro numero\n");
        scanf("%i", &n3);//armazena o terceiro numero
        Pcrescente(n1, n2, n3);//aciona o procedimento dando os numeros amarzenados como parametro
        printf("\n");
        fflush(stdin);
        printf("Deseja continuar? S/N\n");//condição de parada
        scanf("%c", &op);
    }
    system("pause\n");
}