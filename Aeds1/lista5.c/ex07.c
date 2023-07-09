#include <stdio.h>
#include <stdlib.h>
int trocavalor(int *n1, int *n2)
{
    int aux = 0;
    if (*n2 > *n1)
    {
        aux = *n2;
        *n2 = *n1;
        *n1 = aux;
    }
}

int main()
{
    int n1 = 0, n2 = 0;
    printf("N1:\n");
    scanf("%i", &n1);
    printf("N2:\n");
    scanf("%i", &n2);
    trocavalor(&n1, &n2);
    printf("N1 = %i\n", n1);
    printf("N2 = %i\n", n2);
    system("pause");
}