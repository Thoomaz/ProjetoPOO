import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {
    public static void main(String[] args) {
        // Criar e configurar o JFrame
        JFrame frame = new JFrame("File Reader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Criar um painel para os botões
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Criar o botão de abrir arquivo
        JButton openButton = new JButton("Open File");

        // Criar a tabela para exibir o conteúdo do arquivo
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        // Adicionar o botão e a tabela ao painel e à janela
        panel.add(openButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Adicionar um ActionListener ao botão para abrir arquivos
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir um seletor de arquivos
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    // Ler e exibir o conteúdo do arquivo
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        DefaultTableModel model = new DefaultTableModel();
                        // Definir cabeçalhos das colunas
                        model.setColumnIdentifiers(new String[]{"Column 1", "Column 2", "Column 3"});

                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Dividir o texto da linha usando o delimitador ";"
                            String[] parts = line.split(";");

                            // Garantir que tenhamos exatamente 3 colunas, preenchendo com texto vazio se necessário
                            String[] row = new String[3];
                            for (int i = 0; i < 3; i++) {
                                if (i < parts.length) {
                                    row[i] = parts[i].trim();
                                } else {
                                    row[i] = "";
                                }
                            }

                            model.addRow(row);
                        }

                        // Atualizar a tabela com os dados lidos
                        table.setModel(model);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
