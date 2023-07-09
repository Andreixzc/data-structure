#include <stdio.h>
#include <stdlib.h>
int fatorial(int n)
{
    int resultado;
    if (n == 0)
    {
        resultado = 1;
    }
    else
    {
        resultado = n * fatorial(n - 1);
    }
    return resultado;
}

int main()
{
    int n,res;
    printf("Digite N\n");
    scanf("%i", &n);
    res = fatorial(n);
    printf("%i\n",res);
    system("pause\n");
}