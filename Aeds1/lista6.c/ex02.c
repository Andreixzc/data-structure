#include <stdio.h>
int main ()
{
    FILE *file;
    file = fopen("E:\\Test files\\ex02Andrei.txt","w");
    if (file == NULL)
    {
        printf("Erro");
    }
    else;
    char frase[100];
    printf("Digite a frase:\n");
    scanf("%[^\n]%*c", frase);
    fputs(frase,file);
    fclose(file);    

    
    


    
}