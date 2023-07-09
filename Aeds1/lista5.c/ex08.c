#include <stdio.h>
#include <stdlib.h>

int ordena_num(int *n1, int *n2, int *n3)

{
    int aux1 = 0;
    int aux2 = 0;
    int aux3 = 0;
    if (*n1 > *n2 && *n2 > *n3)
    {
        *n1 = *n1;
        *n2 = *n2;
        *n3 = *n3;

    }

    else if (*n1 > *n3 && *n2 < *n3) //n1,n3,n2 a b c 
    {
        aux1 = *n2;
        *n2 = *n3;
        *n3 = aux1;

    }
    else if (*n2 > *n1 && *n1 > *n3)//n2,n1,n3 (10, 12, 5)  a c b 
    {
        aux1 = *n1;// 
        *n1 = *n2;// 
        *n2 = aux1; //
    }
    else if (*n2 > *n1 && *n1 < *n3)//n2,n1,n3 (10, 20, 15) b c a n2,n3,n1
    {
        aux1 = *n2;// Aux recebe o maior numero
        *n2 = *n3;// n1 recebe o menor numero
        *n3 = *n1; // 
        *n1 = aux1;
    }
    else if (*n3 > *n1 && *n1 > *n2)//10, 5, 15 (c, a, b)
    {
        aux1 = *n3;
        *n1 = *n2;
        *n2 = *n2; 
        *n1 = aux1;
    }


}

int main()
{
    int n1, n2, n3;
    printf("N1:\n");
    scanf("%i", &n1);
    printf("N2:\n");
    scanf("%i", &n2);
    printf("N3:\n");
    scanf("%i", &n3);
    ordena_num(&n1, &n2, &n3);
    printf("%i\n%i\n%i\n",n1,n2,n3);
}