/*Um comerciante deseja fazer o levantamento do lucro das mercadorias que ele
comercializa. Para isto, mandou digitar uma linha para cada mercadoria com o preço de 
compra e de venda de cada uma. A última linha contém preço de compra igual a 0. Escreva 
um programa que:
a) Determine e escreva quantas mercadorias proporcionaram:
i) Lucro < 10%
ii) 10% <= lucro <= 20%
iii) Lucro > 20%
b) Determine e escreva o valor total de compra e de venda de todas as mercadorias,
assim como o lucro total.
*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int lucro10 = 0, lucro1020 = 0, lucro20 = 0, mercadoria, venda, compra = 1, lucro, totalc = 0, totalv = 0, ltotal = 0;
    while (compra > 0)
    {
        printf("Digite o preco de compra da mercadoria\n");
        scanf("%i", &compra);
        if (compra > 0)
        {
            totalc = compra + totalc;//armazena o total de compras
            printf("Digite o preco de venda da mercadoria\n");
            scanf("%i", &venda);
            totalv = venda + totalv;//armazena o total de vendas
            lucro = (venda - compra) / compra * 100;//formula pra calcular o lucro
            ltotal = totalc - totalv;//formula pra calcular o lucro total
            if (lucro <= 10)
            {
                lucro10 += 1;
            }
            else if (lucro >= 11 && lucro <= 19)
            {
                lucro1020 += 1;
            }
            else if (lucro >= 20)
            {
                lucro20 += 1;
            }
        }
    }

    printf("Existem %i mercadorias que proporcionaram menos de 10 porcento de lucro\n", lucro10);
    printf("Existem %i mercadorias que proporcionaram entre 10 e 20 porcento de lucro\n", lucro1020);
    printf("Existem %i mercadorias que proporcionaram 20  porcento ou mais de lucro\n", lucro20);
    printf("O valor total de compra e de %i e o valor total de venda e de %i e o valor total de lucro e de %i", totalc, totalv, ltotal);
    system("pause\n");
    
}