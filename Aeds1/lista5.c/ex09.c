#include <stdio.h>
#include <stdlib.h>
void calcCircunferencia(float *R, float *compr, float *area)

{
    *compr = (2*3.14) * *R;
    *area = (*R * *R)* 3.14;

}


int main ()
{
    float raio = 0,compr = 0,area = 0;
    printf("RAIO:\n");
    scanf("%f",&raio);
    calcCircunferencia(&raio,&compr,&area);
    printf("Comprimento: %.2f cm\n",compr);
    printf("Area: %.2f cm\n",area);
    system("pause");


}