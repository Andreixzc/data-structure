/*9. Faça uma função que lê um número indeterminado de notas de alunos, calcula e retorna a 
média das notas dos alunos aprovados (nota maior ou igual a 6). Faça um programa que lê 
o número de alunos e imprime a média retornada pela função.*/
#include <stdio.h>
#include <stdlib.h>
float media(int num)
{
    float nota = 0, totaln = 0, res;
    int cont = 0, i;
    for (i = 1; i <= num; i++)//loop for que vai rodar a quantidade de vezes de alunois informados
    {
        printf("Digite a nota do %i aluno\n", i);
        scanf("%f", &nota);//armazena a nota na variavel nota;
        if (nota >= 6)//condição para os alunos aprovados
    {
        cont += 1;//contador pra calcular o numero total de alunos aprovados
        totaln = totaln + nota;//notas dos alunos aprovados somadas
    }
    }
    res = totaln / cont;//variavel res que armazena a media
    return res;//retorno da media
}

int main()
{
    int num;//armazena o numero de alunos
    float resultado;//armazena o retorno da função
    printf("Digite o numero de alunos:\n");
    scanf("%i", &num);
    resultado = media(num);//aciona a funcao com o retorno sendo armazenado na variavel resultado
    printf("A media dos alunos aprovados e de: %.1f\n",resultado);//printa o resultado
    system("pause\n");
}