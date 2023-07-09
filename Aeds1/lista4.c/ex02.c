#include <stdio.h>
#include <stdlib.h>
int soma_digito(int num)
{
    int resto, b;

    resto = num % 10;

    b = (num - resto) / 10;

    if (b <= 0)
    {
        return resto;
    }
    else
    {

        return resto + soma_digito(b);
    }
}
int main()
{
    int n;
    printf("Digite o numero\n: ");
    scanf("%d", &n);
    printf("A Soma dos digitos do numero %d e: %d\n", n, soma_digito(n));
    system("pause\n");

}