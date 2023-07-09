#include <stdlib.h>
#include <stdio.h>

float resto(float n,float m)
{
    if (n < m)
    {
        return (n);
    }
    else
    {
        return resto(n - m, m);
    }
}

float main()

{
    float n, d, res;
    printf("Numerador:\n");
    scanf("%f", &n);
    printf("Denominador:\n");
    scanf("%f", &d);
    res = resto(n, d);
    printf("%f", res);
    system("pause\n");
}