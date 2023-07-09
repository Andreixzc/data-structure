#include <stdio.h>
#include <stdlib.h>

void copiarConteudo1(FILE *file1, FILE *file2, FILE *file3)
{
    char leitor [1000];
    while (fgets(leitor,1000,file1)!= NULL)
    {
        fputs(leitor,file3);
    }
    while (fgets(leitor,1000,file2)!= NULL)
    {
        fputs(leitor,file3);
    }

    
}
int main ()
{
    FILE *file1 = fopen("E:\\Test files\\ex01Andrei.txt","r");
    FILE *file2 = fopen("E:\\Test files\\ex02Andrei.txt","r");
    FILE *file3 = fopen("E:\\Test files\\ex05Andrei.txt","w");
    copiarConteudo1(file1,file2,file3);
    fclose(file1);
    fclose(file2);
    fclose(file3);

}