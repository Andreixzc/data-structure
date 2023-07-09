#include <stdio.h>
#include <stdlib.h>

static int counter = 0;

int divisao(int numerador, int denominador)
{
    counter++;
    numerador -= denominador;
    if (numerador >= denominador)
        return divisao(numerador, denominador);
    return 0;
}

int main()
{
    int numerador, denominador;
    printf("Informe o numerador: ");
    scanf("%d", &numerador);
    printf("Informe o denominador: ");
    scanf("%d", &denominador);

    divisao(numerador, denominador);

    printf("Resultado da divisao: %d\n", counter);
    system("pause\n");
}