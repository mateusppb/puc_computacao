/*Imprimir números em sequência é uma tarefa relativamente simples.
Mas e quando se trata de uma sequência espelho? Essa é uma sequência
que possui um número inicial e um número final, e todos os números entre
eles, inclusive, são dispostos em ordem crescente, sem espaços, e então essa
sequência é refletida de forma invertida, como um reflexo no espelho. Por exemplo,
se a sequência for de 7 a 12, o resultado seria 789101112211101987.
Escreva um programa que, dados dois números inteiros, imprima a respectiva sequência espelho.*/

import java.util.*;

class Espelho {
    int array[];

    //define o tamanho do array de acordo com as entradas
    void tamanhoEspelho(int x, int y){
        array = new int[y - x + 1];
    }

    //preenche o array com os valores entre os numeros de entrada, inclusive
    void preencher(int x){
        int valor = x;
        for (int i = 0; i < array.length; i++) {
            array[i] = valor;
            valor++;
        }
    }

    //método swap para o algoritmo de seleção
    void swap(int menor, int i) {
        int temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;
    }

    //organiza em ordem crescente
    void selecao() {
        int menor;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            menor = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }

    //imprime os valores na tela
    void imprimir() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            inverterInt(array[i]);
        }
    }

    //imprime o espelho dos valores
    void inverterInt(int num) {
        if (num < 10) {
            System.out.print(num);
        }
        else {
            String str = Integer.toString(num);
            String invertida = "";
            for (int i = str.length() - 1; i >=0; i--){
                invertida += str.charAt(i);
            }
            System.out.print(invertida);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;

        while (sc.hasNextInt()) {
            Espelho espelho = new Espelho();
            a = sc.nextInt();
            b = sc.nextInt();
            espelho.tamanhoEspelho(a, b);
            espelho.preencher(a);
            espelho.selecao();
            espelho.imprimir();
            System.out.println();
        }
        sc.close();
    }
}
