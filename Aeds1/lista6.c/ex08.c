#include <stdio.h>
#include <stdlib.h>
int main ()
{
    int veiculo = 0,aluguel = 0;
    int total = 0;
    int faturamento = 0;
    int atraso = 0;
    int multa = 0;
    int multa1 = 0;
    int valor = 0;
    int manutencao = 0;
    printf("Total de veiculos:\n");
    scanf("%i",&veiculo);
    printf("Aluguel mensal:\n");
    scanf("%i",&aluguel);
    faturamento = (veiculo/3)*aluguel*12;
    multa = (20*aluguel)/100;
    atraso = (veiculo/10);
    multa1 = atraso * multa;
    manutencao = (veiculo*2)/100*600;
    printf("Faturamento:%i\n",faturamento);
    printf("Multa:%i\n",multa1);
    printf("Manutencao:%i\n",manutencao);
    FILE *file;
    file = fopen("E:\\Test files\\resultado.txt","w");
    if (file == NULL)
    {
        printf("Erro ao abrir\n");
    }
    else
    fprintf(file,"Faturamento:%i\n",faturamento);
    fprintf(file,"Multa:%i\n",multa1);
    fprintf(file,"manutencao:%i\n",manutencao);
    fclose(file);
    

    
    


}