
import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Jogador;

public class TesteBancodeDados {

    public static void main(String[] args) {
        inserir();
        List<Jogador> Lista = Listar();
        for (Jogador jogador : Lista) {
            System.out.println(jogador.getNome()+ "\n");
            
        }
    }
    
    public static List<Jogador>Listar()
    {
        List<Jogador> jogadores = new ArrayList<Jogador>();
        try {
        String sql= "SELECT * FROM jogador";
        PreparedStatement pst
                = Conexao.getPreparedStatement(sql);
       
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                //pega a estrutura do resultset relaciona com a classe
                Jogador jog = new Jogador();
                jog.setNome(res.getString("login"));
                jog.setSenha(res.getString("senha"));
                jog.setEmail(res.getString("email"));
                //adiciona na lista 
                jogadores.add(jog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteBancodeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jogadores;
    }
    
   
       public static void inserir()
       {
           String login , senha, email;
           login= JOptionPane.showInputDialog("Login : ");
           senha= JOptionPane.showInputDialog("Senha : ");
           email= JOptionPane.showInputDialog("Email : ");           
          String sql;
          
          sql= "INSERT INTO jogador(login,senha,email) VALUES (?,? ,?)";
          PreparedStatement pst

                    = Conexao.getPreparedStatement(sql);         
        try {
            pst.setString(1,login);
            pst.setString(2,senha);
            pst.setString(3,email);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TesteBancodeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
    }
     
