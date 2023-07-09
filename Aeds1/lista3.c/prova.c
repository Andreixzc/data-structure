#include <stdio.h>

int ehtri(int soma, int z)
{
    if (soma < z)
        return true;
    else
        return false;
}
void ptriangulo(int x, int y, int z, int soma)
{

    if (x == y && y == z)
    {
        printf("Segmentos formam um triangulo Equilatero\n");
    }
    else if (x == y || y == z || z == x)
    {
        printf("Segmentos formam um triangulo Isosceles\n");
    }
    else
        printf("Segmentos formam um triangulo Escaleno\n");
}

int main()
{
    int x, y, z, i, soma;
    for (i = 1; i <= 5; i++)
    {
        printf("Digite o valor de X,Y e Z:");
        scanf("%i%i%i", &x, &y, &z);
        soma = x + y;
        ehtri(soma, z);
        if (ehtri(soma, z) = true)
        {
            printf("Formam um triangulo\n");
            ptriangulo(x, y, z, soma);
        }
        else
        {
            printf("Nao forma um triangulo\n");
        }
    }
}