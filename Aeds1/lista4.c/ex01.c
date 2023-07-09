#include <stdio.h>
#include <stdlib.h>

int ContarDigitos(int n)
{
    int cont = 1;
    if (n >= 10)
    {
        n = n / 10;
        cont = cont + ContarDigitos(n);
    }
    return cont;
}

int main()
{
    int n, res;
    printf("Numero:\n");
    scanf("%i", &n);
    res = ContarDigitos(n);
    printf("%i Digitos\n", res);
    system("pause\n");
}