/* Adaptar o programa acima para que ele calcule o percentual dos valores positivos, 
negativos e zeros em relação ao total de valores fornecidos.
*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int positivo = 0, negativo = 0, zero = 0, entrada = 0, cont = 0, percentualn = 0, percentualp = 0, percentualz = 0;
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
    percentualp = (positivo * 100) / 5;
    percentualn = (negativo * 100) / 5;
    percentualz = (zero * 100) / 5;
    printf("foram contatos %i numeros negativos, que representa %i porcento do total \n", negativo, percentualn);
    printf("foram contatos  %i numeros positivos, que representa %i porcento do total \n", positivo, percentualp);
    printf("foram contatos %i zeros, que representa %i porcento do total\n", zero, percentualz);
    system("pause\n");
}