/*7. Faça um programa para calcular e imprimir o valor de Y, dado um valor de X:
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    int x,y;
    printf("Digite o valor de X\n");
    scanf("%i",&x);
    if (x<=1)
    y=1;
    else if (1<x && x <=2)
    y=2;
    else if (2<x && x<=3)
    y=x*x;
    else if (x>3)
    y=x*x*x;
printf("O valor de y e %i\n",y);
system("pause");
}