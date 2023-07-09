#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE *file;
    int num = 0;
    int sum = 0;
    file = fopen("E:\\Test files\\ex06Andrei.txt", "w");
    if (file == NULL)
    {
        printf("Erro\n");
        exit(0);
    }
    printf("Numero:\n");
    scanf("%i", &num);
    for (int i = 1; i <= num; i++)
    {
        if (num % i == 0)
        {
            printf("%i\n", i);
            sum += i;
        }
    }
    fprintf(file,"%i\n",sum);
    fclose(file);
}