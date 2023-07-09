#include <stdio.h>
int main ()
{
    FILE *file;
    file = fopen("E:\\Test files\\ex02Andrei.txt","r");
    int cont = 0;
    char c;
    if (file == NULL)
    {
        printf("ERRO\n");
    }
    else
    while ((c = getc(file)) != EOF)
    {
        if (c = 'a')
        {
            cont++;
        }
        else
        printf("Arquivo nao encontrado");
        
    }
    printf("Letras A:%i\n",cont);
    



    
    
   
}