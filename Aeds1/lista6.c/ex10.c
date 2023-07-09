#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE *file;
    file = fopen("E:\\Test files\\ex10Andrei.txt", "w");
    float num;
    float maior;
    float menor=10000000;
    float medio;
    float tot = 0;
    int i = 1;
    for ( i = 0; i < 5; ++i)
    {
        printf("VALOR:\n");
        scanf("%f", &num);
        fprintf(file, "%.2f\n", num);
    }
    printf("%i\n",i);
    fclose(file);
    file = fopen("E:\\Test files\\ex10Andrei.txt", "r");
    float n;
    printf("%i\n",i);
    for (int j = 0; j < i; j++)
    {
        fscanf(file, "%f", &n);
        tot  = tot + n;
        if (num > maior)
        {
            maior = n;
        }
        if (num<menor)
        {
            menor = n;
        }
        
    }
    medio = tot/5;
    printf("MAIOR NUMERO:%f\n", maior);
    printf("MENOR NUMERO:%f\n", menor);
    printf("MEDIA:%lf\n",medio);
}
