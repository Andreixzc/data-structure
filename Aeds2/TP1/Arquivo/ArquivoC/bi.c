#include <stdio.h>
#include <stdlib.h>
int main ()
{
    FILE *file;
    int n = 0;
    double entrada = 0;
    scanf("%i",&n);
    file = fopen("teste.txt","wb");
    for (int i = 0; i < n; i++)
    {
        scanf("%d",&entrada);
        fwrite(&entrada,1,sizeof(entrada),file);
    }
    fclose(file);
    FILE * arqNovo = fopen("teste.txt", "r");

    for(int i=1; i<=n; i++){
        fseek(arqNovo,-i*(sizeof(double)),SEEK_END);
        fread(&entrada, sizeof(double), 1, arqNovo);
        printf("%g\n", entrada);
    }
    
    fclose(arqNovo);
    return 0;
}