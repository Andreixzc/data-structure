#include <stdio.h>
int main ()
{
    FILE *file;
    file = fopen("E:\\Test files\\ex01Andrei.txt","w");
    if (file == NULL)
    {
        printf("Erro");
    }
    else
    for (int i = 0; i <=10; i++)
    {
        fprintf(file,"%i\n",i);
    }
    fclose(file);
    
    


    
}