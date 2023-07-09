/*. Leia a velocidade máxima permitida em uma avenida e a velocidade com que o motorista 
estava dirigindo nela. Se o motorista estiver dentro do limite de velocidade, imprima a 
mensagem “Motorista respeitou a lei”. Se o motorista tiver ultrapassado a velocidade 
máxima permitida, calcule e imprima o valor da multa a ser cobrada, sabendo que os 
valores a serem cobrados são os seguintes:
• 50 reais se o motorista ultrapassar em até 10km/h a velocidade permitida (ex: se a 
velocidade máxima for 50km/h e o motorista estiver a 60km/h ou a 56km/h);
• 100 reais, se o motorista ultrapassar de 11 a 30 km/h a velocidade permitida;
• 200 reais, se estiver acima de 30km/h da velocidade permitida
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main (){
    int limite,vm,multa,dif;
    printf("Digite a velocidade que o motorista estava dirigindo:\n");
    scanf("%i",&vm);
    printf("Digite a velocidade maxima da via:\n");
    scanf("%i",&limite);
    multa=0;
    dif = vm - limite;/*formula pra saber se o motorista estava acima da velocidade*/
    if (dif>=31)//caso o motorista estiver a mais de 30km acima do limite//
    {
        multa+=200;
        printf("O valor da multa foi de %i reais\n",multa);
    }else if (dif>=11 && dif<=30)//entre 11 e 30//
    {
        multa+=100;
        printf("O valor da multa foi de %i reais\n",multa);
    }else if (dif<=10 && dif>0)//entre 10 e 0//
    {
        multa+=50;
        printf("O valor da multa foi de %i reais\n",multa);
    }else
    {
        printf("Motorista respeitou a lei\n");//caso o motorista estiver dentro da velocidade//
    }
system("pause");  
    
    
    
    
    
    

    
    
    
       
        
}