#include <stdio.h>
#include <stdlib.h>
void vogais(FILE *file)
{
    file = fopen("E:\\Test files\\ex07Andrei.txt", "r");
    int soma = 0;
    char c;
    while ((c = getc(file)) != EOF)
    {
        printf("%c", c);
        if (c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u')
        {
            soma++;
        }
    }
    printf("\nHa %i vogais neste arquivo.", soma);
    fclose(file);
}

int main()
{
    char frase[50];
    FILE *file;
    file = fopen("E:\\Test files\\ex07Andrei.txt", "w");
    if (file == NULL)
    {
        printf("ERRO");
        exit(0);
    }
    printf("LETRAS:");
    scanf("%s", frase);
    fputs(frase, file);
    fclose(file);
    vogais(file);
}