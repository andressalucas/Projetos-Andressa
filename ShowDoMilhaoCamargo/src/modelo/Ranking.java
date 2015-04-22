
package modelo;

import java.util.Date;
public class Ranking {
    private Integer id, pontos ;
    private Jogador jogador  ;
    
    public Ranking (){
        jogador = new Jogador();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    private Date data ;

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

   

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
