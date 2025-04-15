import java.util.*;


    class List {
        int n;
        int array[];
    
        List() {
            array = new int[6];
            n = 0;
        }
    
        List(int tamanho) {
            array = new int[tamanho];
            n = 0;
        }

        void II(int x){

            if(n >= array.length){
                System.out.println("LISTA CHEIA.");
            }
            else {
                for(int i = n; i > 0; i--){
                    array[i] = array[i - 1];
                }

                array[0] = x;
                n++;
            }
        }

        void IF(int x){

            if(n >= array.length){
                System.out.println("LISTA CHEIA");
            }
            else {
                array[n] = x;
                n++;
            }
        }

        int RI() {
            int resp =array[0];

            if(n == 0) {
                System.out.println("LISTA VAZIA");
                return -1;
            }
            else {
                for(int i = 0; i < n; i++) {
                    array[i] = array[i+1];
                }
                n--;
                return resp;
            }
        }

        int RF() {
            int resp = array[n-1];

            if(n == 0){
                System.out.println("LISTA VAZIA");
                return -1;
            }
            else {
                n--;
                return resp;
            }
        }

        void IP(int x , int pos) {

            if(n >= array.length || pos < 0 || pos > n){
                System.out.println("ERRO.");
            }
            else {
                for (int i = n; i > pos; i--) {
                    array[i] = array[i-1];
                }
                array[pos] = x;
                n++;
            }
        }

        int RP(int pos) {
            int resp = array[pos];

            if (n >= array.length || pos < 0 || pos > n) {
                System.out.println("ERRO.");
                return -1;
            }
            else {
                for (int i = pos; i < n; i++) {
                    array[i] = array[i+1];
                }
                n--;
                return resp;
            }
        }

        void ME () {

            if (n == 0){
                System.out.println("LISTA VAZIA");
            }
            else {
                for (int i = 0; i < n; i++) {
                    System.out.print(array[i]+" ");
                }
                System.out.println();
            }
        }

        void selecao() {
            int posMenor, aux;

            for (int i = 0; i < n - 1; i++){
                posMenor = i;
                for(int j = i + 1; j < n; j++) {
                    if(array[j] < array[posMenor]){
                        posMenor = j;
                    }
                }
                aux = array[posMenor];
                array[posMenor] = array[i];
                array[i] = aux;
            }
            System.out.println("Lista ordenada com sucesso.");
        }

        void bolha() {
            int aux;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++){
                    if (array[j+1] < array[j]) {
                        aux = array[j+1];
                        array[j+1] = array[j];
                        array[j] = aux;
                    }
                }
            }
            System.out.println("Lista ordenada com sucesso.");
        }

}





public class Lista {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        List lista = new List(6);

        int op = 0;
        int num;
        int lixo;
        int posicao;

        while(op != 10){

            System.out.println("===================================");
            System.out.println("     Menu    ");
            System.out.println("1 - Inserir início");
            System.out.println("2 - inserir fim");
            System.out.println("3 - Remover início");
            System.out.println("4 - Remover fim");
            System.out.println("5 - Inserir na posição");
            System.out.println("6 - Remover na posição");
            System.out.println("7 - Mostrar elementos");
            System.out.println("8 - Ordenar por seleção");
            System.out.println("9 - Bubble sort");
            System.out.println("10 - Sair");
            System.out.println("===================================");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch(op){
                case 1:
                System.out.println("Número à ser inserido: ");
                    num = sc.nextInt();
                        lista.II(num);
                    break;
                case 2:
                System.out.println("Número à ser inserido: ");
                    num = sc.nextInt();
                    lista.IF(num);
                    break;
                case 3:
                    lixo = lista.RI();
                    System.out.println("Removido com sucesso");
                    break;
                case 4:
                    lixo = lista.RF();
                    System.out.println("Removido com sucesso");
                    break;
                case 5:
                    System.out.println("Número à ser inserido: ");
                    num = sc.nextInt();
                    System.out.println("Posição de inserção: ");
                    posicao = sc.nextInt();
                    lista.IP(num,posicao);
                    break;
                case 6:
                    System.out.println("Posição de remoção: ");
                    posicao = sc.nextInt();
                    lista.RP(posicao);
                    break;
                case 7:
                    lista.ME();
                    break;
                case 8:
                    lista.selecao();
                    break;
                case 9:
                lista.bolha();
                break;
                default:
                    op = 10;
            }
        }
    }
}
