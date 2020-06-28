package ckdprocessing;

import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jeferson
 */


public class CKDProcessing extends JFrame
{
    int idade;
    String nome;
    boolean fumante;
    boolean diabetico;
    String etnia;
    String sexo;
    double creatinina;
    double resultado;
    String resultado2;
    double valorRAC;
    String alteracaoImagem;
    String nomeApresentar;
    String estagio;
    String resultadoRisco;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    
    public CKDProcessing() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.jButton1 = new JButton();
        this.jLabel1 = new JLabel();
        this.jButton2 = new JButton();
        this.setDefaultCloseOperation(3);
        this.setTitle("Robô de diagnóstico de DRC");
        this.setBackground(new Color(51, 51, 51));
        this.jButton1.setBackground(new Color(51, 203, 178));
        this.jButton1.setFont(new Font("Dyuthi", 1, 24));
        this.jButton1.setForeground(new Color(139, 1, 111));
        this.jButton1.setText("Estadiamento");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                CKDProcessing.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/ckdprocessing/medbot3.png")));
        this.jLabel1.setText("jLabel1");
        this.jButton2.setBackground(new Color(51, 203, 178));
        this.jButton2.setFont(new Font("Dyuthi", 1, 24));
        this.jButton2.setForeground(new Color(139, 1, 111));
        this.jButton2.setText("Grau de Risco");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                CKDProcessing.this.jButton2ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 177, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, -2, 177, -2).addComponent(this.jButton2, -2, 177, -2)).addContainerGap(37, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(43, 43, 43).addComponent(this.jLabel1, -2, 209, -2).addContainerGap(67, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton2, -2, 59, -2).addGap(18, 18, 18).addComponent(this.jButton1, -2, 59, -2).addGap(90, 90, 90)));
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        JOptionPane.showMessageDialog(this.jButton1, "Ol\u00e1! Este \u00e9 o m\u00f3dulo de estadiamento da Doen\u00e7a Renal Cr\u00f4nica.");
        JOptionPane.showMessageDialog(this.jButton1, "Digite as informa\u00e7\u00f5es solicitadas, por favor!");
        this.nome = JOptionPane.showInputDialog("Qual o nome do(a) paciente?");
        this.idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do(a) paciente?"));
        this.sexo = JOptionPane.showInputDialog("Qual o sexo do(a) paciente?");
        this.etnia = JOptionPane.showInputDialog("Qual a etnia do(a) paciente?");
        this.creatinina = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da creatinina do(a) paciente?"));
        this.valorRAC = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor RAC do(a) paciente?"));
        this.alteracaoImagem = JOptionPane.showInputDialog("Houve altera\u00e7\u00e3o de imagem no exame do(a) paciente?");
        this.nomeApresentar = this.nome;
        this.nome = this.nome.toLowerCase();
        this.sexo = this.sexo.toLowerCase();
        this.etnia = this.etnia.toLowerCase();
        this.alteracaoImagem = this.alteracaoImagem.toLowerCase();
        final Processamento dados = new Processamento();
        this.resultado = dados.TFG(this.sexo, this.etnia, this.creatinina, this.idade);
        this.resultado2 = dados.RAC(this.valorRAC);
        this.estagio = dados.Estadiamento(this.resultado2.toLowerCase(), this.resultado);
        JOptionPane.showMessageDialog(null, "O paciente de nome " + this.nomeApresentar + ", de " + this.idade + " anos de idade, apresenta DRC no Est\u00e1gio " + this.estagio + ".");
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        JOptionPane.showMessageDialog(this.jButton1, "Olá! Este é o módulo de classificão de risco da Doênça Renal Crônica.");
        JOptionPane.showMessageDialog(this.jButton1, "Digite as informações solicitadas, por favor!");
        this.nome = JOptionPane.showInputDialog("Qual o nome do(a) paciente?");
        this.idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do(a) paciente?"));
        this.sexo = JOptionPane.showInputDialog("Qual o sexo do(a) paciente?");
        this.etnia = JOptionPane.showInputDialog("Qual a etnia do(a) paciente?");
        this.creatinina = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor da creatinina do(a) paciente?"));
        this.valorRAC = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor RAC do(a) paciente?"));
        this.alteracaoImagem = JOptionPane.showInputDialog("Houve alteração de imagem no exame do(a) paciente?");
        this.nomeApresentar = this.nome;
        this.nome = this.nome.toLowerCase();
        this.sexo = this.sexo.toLowerCase();
        this.etnia = this.etnia.toLowerCase();
        this.alteracaoImagem = this.alteracaoImagem.toLowerCase();
        final Processamento dados = new Processamento();
        this.resultado = dados.TFG(this.sexo, this.etnia, this.creatinina, this.idade);
        this.resultado2 = dados.RAC(this.valorRAC);
        this.resultadoRisco = dados.GrupoRisco(this.resultado2.toLowerCase(), this.resultado);
        JOptionPane.showMessageDialog(null, "O paciente de nome " + this.nomeApresentar + ", de " + this.idade + " anos de idade, est\u00e1 com Risco " + this.resultadoRisco + ".");
    }
    
    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(CKDProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(CKDProcessing.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(CKDProcessing.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(CKDProcessing.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CKDProcessing().setVisible(true);
            }
        });
    }
}
