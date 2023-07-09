class hash {
    private int size;
    private int[] vet;

    public int[] getVet() {
        return vet;
    }

    public hash(int size) {
        this.size = size;
        this.vet = new int[this.size];
        for (int i = 0; i < size; i++) {
            vet[i] = -1;
        }
    }

    public int h(int valor) {
        return valor % size;
    }

    public int reHash(int valor) {
        return ++valor % size;
    }

    public boolean inserir(int valor) {
        int pos = h(valor);
        System.out.println(pos);
        if (vet[pos] == -1) {
            vet[pos] = valor;
            return true;
        } else {
            pos = reHash(valor);
            if (vet[pos] == -1) {
                vet[pos] = valor;
                return true;
            }
        }
        return false;
    }

    public boolean pesquisar(int valor) {
        int pos = h(valor);// pos 0
        if (vet[pos] == valor) {
            return true;
        } else {
            pos = reHash(valor);
            if (vet[pos] == valor) {
                return true;
            }
        }
        return false;
    }
}
public class chibata {
    public static void main(String[] args) {
        hash hash = new hash(10);
        hash.inserir(1);



    }
}
