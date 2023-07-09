#include <stdio.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
bool verifica2(char str[], int inicio, int fim)
{
    {
        if (str[inicio] != str[fim])//verifica se o char na posicao inicio e fim são diferentes
        {
            return false;
        }
        if (inicio < fim + 1)//rodar a recursividade até o indice inicio for maior que o do fim.
        {
            return verifica2(str, inicio + 1, fim - 1);
            // //caso a str sobreviva ate aqui, chame a funcao novamente adicionando 1 do inicio e subtraindo 1 do fim
            // ate que as duas se encontrem.

        }
        return true;//Se a string passar por todas as verificações, igualando o 'inicio' ao 'fim', ela é um palindromo.
    }
}
bool verifica1(char str[])
{
    int inicio = 0;
    int fim = strlen(str) - 1;//fim recebe o lenght do vetor - 1;
    int n = strlen(str);//n recebe o lenght do vetor.
    if (n == 0)//verifica se o input for vazio. Se for, é considerado palindromo.
    {
        return true;
    }
    return verifica2(str, inicio, fim);//Chama a funcao 2
}

int main()
{
    char str[1000];
    char aux[5] = "FIM";
    int res = 1;
    while (res != 0)
    {
        scanf("%[^\n]%*c", str);
        res = strcmp(str, aux);//Compara de o input é igual a FIM
        if (res == 0)//Se igual, pare o programa
        {
            break;
        }
        else
        {
            verifica1(str);
            if (verifica1(str))
            {
                printf("SIM\n");
            }
            else
                printf("NAO\n");
        }
    }
}