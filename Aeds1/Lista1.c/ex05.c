/*Um hotel com 75 apartamentos deseja fazer uma promoção especial de final de semana, 
concedendo um desconto de 25% na diária. Com isto, espera aumentar sua taxa de 
ocupação de 50 para 80%. Sendo dado o valor normal da diária, calcular e imprimir: 
a) o valor da diária promocional; 
b) o valor total arrecadado com 80% de ocupação e diária promocional; 
c) o valor total arrecadado com 50% de ocupação e diária normal; 
d) a diferença entre estes dois valores.
Nome: Andrei Gonçalves Rohlfs Massaini
Data de escrita: 08/09/2021*/
#include <stdio.h>
#include <stdlib.h>
int main(){
    float d,dp,t80p,t50n,dif,desconto;
    printf("Digite o valor da diaria:\n");
    scanf("%f",&d);
    desconto = (d * 25) /100 ;
    dp = d - desconto;
    t80p=60*dp;
    t50n=37*d;
    dif= t80p - t50n;
    printf("O valor da diaria promocinal e de %.1f Reais\n",dp);
    printf("O valor total arrecadado com 80 porcento ocupacao na diaria promocional e %.1f Reais\n",t80p);
    printf("O valor total arrecadado com 50 porcento de ocupacao na diaria normal e de %.1f reais\n",t50n);
    printf("A diference entre os valores e de %.1f\n",dif);
system("pause");
}