/*Fazer um programa leia uma seqüência de valores inteiros fornecida pelo usuário em uma 
linha de entrada e conte o número de valores positivos, negativos e zeros.*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int positivo = 0, negativo = 0, zero = 0, entrada = 0, cont = 0;
    printf("Digite a sequencia de numeros:");
    while (cont < 5)
    {
        scanf("%i", &entrada);
        if (entrada > 0)
        { //se o numero digitado pelo usuario for maior que 1, o programa armazena na variavel positivo e incrimenta a variavel cont em 1//
            positivo += 1;
            cont += 1;
        }
        else if (entrada < 0)
        { //numero menor que 0, armazena na variavel negativa, e incrimenta a variavel cont em 1
            negativo += 1;
            cont += 1;
        }
        else if (entrada == 0)
        { //numero for 0, armazena na variavel zero, e incremente 1 ao cont//
            zero += 1;
            cont += 1;
        }
        else if (cont == 5) //assim que o cont chegar a 5, pare o loop.
            break;
    }
    printf("foram contatos %i numeros negativos \n", negativo);
    printf("foram contatos  %i numeros positivos \n", positivo);
    printf("foram contatos %i zeros.\n", zero);
    system("pause\n");
}