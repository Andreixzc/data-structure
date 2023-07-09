#include <stdio.h>
#include <stdlib.h>
int main ()
{
    FILE *file;
    file = fopen("E:\\Test files\\ex09Andrei.txt","w");
    int matricula = 0;
    int telefone = 0;
    for (int i = 1; i <=5; i++)
    {
        printf("Matricula:\n");
        scanf("%i",&matricula);
        fprintf(file,"%i\n",matricula);
        printf("Telefone:\n");
        scanf("%i",&telefone);
        fprintf(file,"%i\n",telefone);
    }
    fclose(file);
    file = fopen("E:\\Test files\\ex09Andrei.txt","r");
    char op;
    char texto[500];
    fflush(stdin);
    printf("Deseja ler os dados armazenados? S/N\n");
    scanf("%c",&op);
    if (op = 's')
    {
        while (fgets(texto,500,file)!=NULL)
        {
            printf("%s\n",texto);
        }
        fclose(file);
        
    }
    else
    fclose(file);
    
    
    



}