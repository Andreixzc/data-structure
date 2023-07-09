/*Dado dois números imprimir somente o maior deles.
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    int num1,num2;
    printf("Digite dois numeros: ");
    scanf("%i%i",&num1,&num2);
    if (num1>num2)//caso o primeiro numero for maior que o segundo//
    {
        printf("O maior numero e %i\n",num1);
    }else
        printf("O numero maior e %i\n",num2);
        system("pause");
        return 0;
    
        
}




 



   


    
    