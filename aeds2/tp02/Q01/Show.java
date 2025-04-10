import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;



public class Show {
    private String show_id;
    private String type;
    private String title;
    private String[] director;
    private String[] cast;
    private String[] country;
    private Date date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;

    public Show() {
        this.show_id = "NaN";
        this.type = "NaN";
        this.title = "NaN";
        this.director = new String[]{"NaN"};
        this.cast = new String[]{"NaN"};
        this.country = new String[]{"NaN"};
        this.date_added = null;
        this.release_year = 0;
        this.rating = "NaN";
        this.duration = "NaN";
        this.listed_in = new String[]{"NaN"};
    }

    public String getId() {return this.show_id; }
    public void setId(String show_id) {this.show_id = show_id; }

    public String getType() {return this.type; }
    public void setType(String type) {this.type = type; }

    public String getTitle() {return this.title; }
    public void setTitle(String title) {this.title = title; }

    public String[] getDirector() {return director; }
    public void setDirector(String[] diretorArray) {this.director = diretorArray;}

    public String[] getCast() {return cast; }
    public void setCast(String[] cast) {this.cast = cast; }

    public String[] getCountry() {return country; }
    public void setCountry(String[] country) {this.country = country; }

    public Date getDate_added() {return date_added; }
    public void setDate_added(Date date_added) {this.date_added = date_added; }

    public int getRelease_year() {return release_year; }
    public void setRelease_year(int release_year) {this.release_year = release_year; }

    public String getRating() {return rating; }
    public void setRating(String rating) {this.rating = rating; }

    public String getDuration() {return duration; }
    public void setDuration(String duration) {this.duration = duration; }

    public String[] getListed_in() {return listed_in; }
    public void setListed_in(String[] listed_in) {this.listed_in = listed_in; }



    public void setarArrayDiretor(String lista){
        // split para separar por vírgula (dentro das aspas) e remover espaços vazios
        String[] listaDiretores = lista.split("\\s*,\\s*");
        setDirector(listaDiretores);
    }



    public void setarArrayCast(String lista){
        // split para separar por vírgula (dentro das aspas) e remover espaços vazios
        String[] listaCast = lista.split("\\s*,\\s*");
        setCast(listaCast);
    }



    public void setarArrayListedIn(String lista){
        // split para separar por vírgula (dentro das aspas) e remover espaços vazios
        String[] listed = lista.split("\\s*,\\s*");
        setListed_in(listed);
    }

    public void setarArrayCountry(String lista){
        // split para separar por vírgula (dentro das aspas) e remover espaços vazios
        String[] country = lista.split("\\s*,\\s*");
        setCountry(country);
    }


    public void Imprimir(String Show_id, Show[] filmes){
        for (Show filme : filmes) {
            if (filme.getId().equals(Show_id)) {
                System.out.print("=> " + filme.getId() + " ## " + filme.getType() + " ## " + filme.getTitle() + " ## ");
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String path = "C:\\\\Temp\\\\disneyplus.csv";
        File arquivo = new File(path);
        Scanner sc = new Scanner(arquivo);
        String linha; //salva a linha de um filme para separar depois os atributos
        String atributo = "";
        Show[] filmes = new Show[1368];
        int n = 0; //contador

        //ignorar a primeira linha (com atributos)
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {
            filmes[n] = new Show();
            linha = sc.nextLine();
            int i = 0;

            //SHOW ID
            //while para separar o show_id
            while(linha.charAt(i) != ','){
                atributo += linha.charAt(i);
                i++;
            }
            i++;
            filmes[n].setId(atributo);
            atributo = "";
            
            //TYPE
            //while para separar o type
            while(linha.charAt(i) != ','){
                atributo += linha.charAt(i);
                i++;
            }
            i++;
            filmes[n].setType(atributo);
            atributo = "";

            //TITLE
            //leitura do título caso ele tenha vírgula (ler de aspas á aspas)
            if(linha.charAt(i) == '"'){
                i++;
                while(linha.charAt(i) != '"'){
                    atributo += linha.charAt(i);
                    i++;
                }
                i++;
                filmes[n].setTitle(atributo);
                atributo = "";
            }
            //leitura do título padrão até a vírgula
            else{
                while(linha.charAt(i) != ','){
                    atributo += linha.charAt(i);
                    i++;
                }
                i++;
                filmes[n].setTitle(atributo);
                atributo = "";
            }

            //DIRECTOR
            //Caso haja mais de um com "", chamaremos a função que realiza o split
            if(linha.charAt(i) == '"'){
                String lista = "";
                i++;
                while(linha.charAt(i) != '"'){
                    lista += linha.charAt(i);
                    i++;
                }
                if(!"".equals(lista)) filmes[n].setarArrayDiretor(lista);
                i++; 
                i++;
            }
            //leitura do diretor padrão até a vírgula
            else{
                if(linha.charAt(i) != ','){
                    while(linha.charAt(i) != ','){
                        atributo += linha.charAt(i);
                        i++;
                    }
                }
                    if(!"".equals(atributo)) {
                        String[] diretor = new String[1];
                        diretor[0] = atributo;
                        filmes[n].setDirector(diretor);
                    }
                    atributo = "";
                    i++;
            }


            //CAST
            //Caso haja mais de um com "", chamaremos a função que realiza o split
            if(linha.charAt(i) == '"'){
                String lista = "";
                i++;
                while(linha.charAt(i) != '"'){
                    lista += linha.charAt(i);
                    i++;
                }
                if(!"".equals(lista)) filmes[n].setarArrayCast(lista);
                i++;
                i++;
            }
            // leitura do elenco padrão até a vírgula
            else{
                while(linha.charAt(i) != ','){
                    atributo += linha.charAt(i);
                    i++;
                }
                if(!"".equals(atributo)) {
                    String[] cast = new String[1];
                    cast[0] = atributo;
                    filmes[n].setCast(cast);
                }
                i++;
                atributo = "";
            }
            //COUNTRY
            //Caso haja mais de um com "", chamaremos a função que realiza o split
            if(linha.charAt(i) == '"'){
                String lista = "";
                i++;
                while(linha.charAt(i) != '"'){
                    lista += linha.charAt(i);
                    i++;
                }
                if(!"".equals(lista)) filmes[n].setarArrayCountry(lista);
                i++;
                i++;
            }
            // leitura do elenco padrão até a vírgula
            else{
                while(linha.charAt(i) != ','){
                    atributo += linha.charAt(i);
                    i++;
                }
                if(!"".equals(atributo)) {
                    String[] country = new String[1];
                    country[0] = atributo;
                    filmes[n].setCountry(country);
                }
                i++;
                atributo = "";
            }
            System.out.println(Arrays.toString(filmes[n].getCountry()));


            // DATE ADDED
            if (linha.charAt(i) == '"') {
                i++;
                while (linha.charAt(i) != '"') {
                    atributo += linha.charAt(i);
                    i++;
                }
                i++;
                if (linha.charAt(i) == ',') i++;
            } else {
                while (linha.charAt(i) != ',') {
                    atributo += linha.charAt(i);
                    i++;
                }
                i++;
            }
            if (!"".equals(atributo)) {
                atributo = atributo.trim();
                // Checa se a data contém vírgula, o que indica presença do ano
                if (atributo.contains(",")) {
                    SimpleDateFormat formato = new SimpleDateFormat("MMMM d, yyyy", java.util.Locale.ENGLISH);
                    try {
                        Date data = formato.parse(atributo);
                        filmes[n].setDate_added(data);
                    } catch (ParseException e) {
                        System.out.println("Erro ao converter data: " + atributo);
                    }
                } else {
                    System.out.println("Data incompleta ou inválida: " + atributo);
                }
            }
            if (linha.charAt(i) == ',') i++;
            atributo = "";
            
            //RELEASE YEAR
            while (linha.charAt(i) != ',') {
                atributo += linha.charAt(i);
                i++;
            }
            //converter string para inteiro antes de chamar a função set
            int lancamento = Integer.parseInt(atributo);
            filmes[n].setRelease_year(lancamento);
            i++;
            atributo = "";

            //RATING
            while (linha.charAt(i) != ',') {
                atributo += linha.charAt(i);
                i++;
            }
            if(!"".equals(atributo)) filmes[n].setRating(atributo);
            i++;
            atributo = "";


            //DURATION
            while (linha.charAt(i) != ',') {
                atributo += linha.charAt(i);
                i++;
            }
            filmes[n].setDuration(atributo);
            i++;
            atributo = "";

            //LISTED IN
            //caso seja uma lista, leitura até as aspas
            if(linha.charAt(i) == '"'){
                String lista = "";
                i++;
                while(linha.charAt(i) != '"'){
                    lista += linha.charAt(i);
                    i++;
                }
                if(!"".equals(lista)) filmes[n].setarArrayListedIn(lista);
            }
            //caso seja apenas um item em listed_in, leitura até a vírgula
            else{
                while(linha.charAt(i) != ','){
                    atributo += linha.charAt(i);
                    i++;
                }
                if(!"".equals(atributo)) {
                    String[] listed = new String[1];
                    listed[0] = atributo;
                    filmes[n].setListed_in(listed);
                }
                i++;
                atributo = "";
            }

            //incrementar o n para o proximo objeto do array
            n++;
            if(n == 21) break;
        }            
        }
    }
