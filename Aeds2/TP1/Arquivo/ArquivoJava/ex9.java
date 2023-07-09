import java.io.RandomAccessFile;

public class ex9 
{
    public static void main(String args[]) 
    {
        int n = MyIO.readInt();
        int ultimo = (n*8)-8;
        long aux = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile("ree.txt", "rw");
            for (int i = 0; i < n; i++) 
            {
                //Escreve no arquivo
                raf.writeDouble(MyIO.readDouble());
                
            }
            raf.close();
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        try {
            //Abre o arquivo para leitura
            RandomAccessFile rafn = new RandomAccessFile("ree.txt", "r");
            rafn.seek(ultimo);//Seta o ponteiro para a ultima posição do arquivo.
            aux = rafn.getFilePointer();//Aux recebe o ponteiro atual do arquivo. No caso, o último.
            for (int i = 0; i < n; i++) 
            {
                MyIO.println(rafn.readDouble());//Printa o conteudo do arquivo
                rafn.seek(aux-=8);//Diminui uma linha no índice do arquivo para ler de traz pra frente.
                if (aux <0) 
                {
                    break; //Quando o índice for menor que 0, pare o programa.
                }
            }
            
            
            rafn.close();
        } catch (Exception e) {
            // System.out.println(e.getMessage());
        }
    }
    
}
