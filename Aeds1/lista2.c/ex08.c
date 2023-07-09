#include <stdlib.h>
#include <stdio.h>
int main()
{
    int l, t1 = 0, t2 = 1, i, prox;
    printf("Digite o valor de l\n"); //armazena o valor de termos
    scanf("%i", &l);
    for (i = 1; i <= l; i++)//inicia o loop com i valendo 1 e indo ate o numero de termos digitado, com incremento de 1
    {

        prox = t1 + t2; //mostra o primeiro termo de cada loop
        t1 = t2; //O termo seguinte sera t1+t2
        t2 = prox;//passa o valor de t2 pra variavel prox
        if (t1 > l)//condicao pra caso o valor de t1 passar o valor de L o programa para.
            break;
        printf("%i\n", t1);//printa o resultado
    }
    system("pause\n");
}