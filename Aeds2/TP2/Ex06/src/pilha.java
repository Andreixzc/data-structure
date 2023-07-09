class Pilha {
    private int qtdElementos = 0;
    private Filme[] arrPilha = new Filme[qtdElementos];


    public static void copiarArray(Filme[] arrNormal, Filme[] arrAux) {
        for (int i = 0; i < arrNormal.length; i++) {
            arrAux[i] = arrNormal[i];
        }
    }

    public int getQtdElementos() {
        return qtdElementos;
    }

    public void setQtdElementos(int qtdElementos) {
        this.qtdElementos = qtdElementos;
    }

    public Filme[] getArrLista() {
        return arrPilha;
    }

    public void setArrLista(Filme[] arrLista) {
        this.arrPilha = arrLista;
    }

    public void empilhar(Filme s) {
        Filme[] arrayAux = new Filme[arrPilha.length];
        copiarArray(arrPilha, arrayAux);
        qtdElementos++;
        arrPilha = new Filme[qtdElementos];
        copiarArray(arrayAux, arrPilha);
        arrPilha[arrPilha.length - 1] = s;

    }

    public void mostrar() {

        for (int i = 0; i < qtdElementos; i++) {
            System.out.print("[" + i + "] ");
            arrPilha[i].imprimir();
        }
    }

    public Filme desempilhar() {
        int i;
        Filme[] arrayAux = new Filme[qtdElementos];
        qtdElementos--;
        copiarArray(arrPilha, arrayAux);
        arrPilha = new Filme[qtdElementos];
        for (i = 0; i < qtdElementos; i++)
            arrPilha[i] = arrayAux[i];

        return arrayAux[i];
    }


}
