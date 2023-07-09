/*Escreva um procedimento que recebe 3 valores reais X, Y e Z e que verifique se esses 
valores podem ser os comprimentos dos lados de um triângulo e, neste caso, exibe qual é o 
tipo de triângulo formado. Para que X, Y e Z formem um triângulo é necessário que a 
seguinte propriedade seja satisfeita: o comprimento de cada lado de um triângulo é menor 
do que a soma do comprimento dos outros dois lados.*/
#include <stdio.h>
#include <stdlib.h>
void ptriangulo(int x, int y, int z, int soma)
{
    if (soma < z)//caso a soma for maior que Z não se forma um triangulo
    {
        printf("Segmentos informados nao formam um triangulo\n");
    }
    else if (x == y && y == z)//equilatero
    {
        printf("Segmentos formam um triangulo Equilatero\n");
    }
    else if (x == y || y == z || z == x)//isosceles
    {
        printf("Segmentos formam um triangulo Isosceles\n");
    }
    else//escaleno
        printf("Segmentos formam um triangulo Escaleno\n");
}

int main()
{
    int x, y, z, soma;
    printf("Digite o valor de X,Y e Z:");
    scanf("%i%i%i", &x, &y, &z);//armazena as variaveis dos lados do triangulo
    soma = x + y;//armazena a soma de um dos lados para verificar se os segmentos formam um triangulo
    ptriangulo(x, y, z, soma);//aciona o procedimento
    system("pause");
}