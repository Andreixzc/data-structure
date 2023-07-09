#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE *file;
    char line[255];
    int cont = 0;
    file = fopen("E:\\Test files\\ex02Andrei.txt", "r");
    if (file == NULL)
    {
        printf("Erro ao abrir arquivo");
        exit(0);
    }
    while (fgets(line, 255, file) != NULL)
    {
        printf("%s\n", line);
        cont++;
    }
    printf("%i\n", cont);
    fclose(file);
}