package djm_lab7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Form1 extends javax.swing.JFrame {
    public String FileName, DirName; // Имя входного файла с данными и его каталог
    public int Row = 5, Col = 6;
    public int myArray[][] = new int[Row][Col]; // Массив для обработки данных
    
    public Form1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Upload = new javax.swing.JButton();
        Solve = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с массивами и файлами в Java");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Serif", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 10, 260, 310);

        Upload.setText("Загрузить");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });
        getContentPane().add(Upload);
        Upload.setBounds(340, 40, 180, 40);

        Solve.setText("Обработать");
        Solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolveActionPerformed(evt);
            }
        });
        getContentPane().add(Solve);
        Solve.setBounds(340, 100, 180, 40);

        Save.setText("Сохранить");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save);
        Save.setBounds(340, 160, 180, 40);

        jLabel1.setText("<html>  <p align=\"center\"> <strong>  Задание: </strong> Если в третьей строке стоят все единицы, то увеличить максимальный элемент первого столбца в два раза, а максимальный элемент второго столбца в три раза.  </p>  </html>");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 220, 230, 90);

        setSize(new java.awt.Dimension(584, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
       JFileChooser choose = new JFileChooser(); // Объект выбора файла
       choose.setCurrentDirectory(new File(".").getAbsoluteFile().getParentFile()); //выбираем текущий каталог
       
       choose.setFileFilter(new FileNameExtensionFilter("TXT files", "txt")); //Фильтр только для текстовых файлов
       choose.setDialogTitle("Выбрать");
       choose.setAcceptAllFileFilterUsed(false); // Выкл "все файлы" в фильтре
       
       int dialog = choose.showDialog(null, "Выбрать");
       if (dialog != JFileChooser.APPROVE_OPTION)
       {
           return; // Если файл не был выбран, то выход
       }
       FileName = choose.getSelectedFile().getPath(); // Получить имя файла Например input.txt
       DirName = choose.getSelectedFile().getParent() + System.getProperty("file.separator"); // Получение директорий файла
       
       
       try{
           Scanner fileInput = new Scanner(new FileInputStream(FileName));
           
           for (int i = 0; i < Row; i++) // Загружаем данные с файла в массив
           {
               for (int j = 0; j < Col; j++)
               {
                  myArray[i][j] = fileInput.nextInt(); //Записываем по символу в массив
               }
           }
           
           jTextArea1.setText("Исходные данные из файла:\n");
           for (int i = 0; i < Row; i++)
           {
               for(int j = 0; j < Col; j++)
               {
                   jTextArea1.append(String.format("%5d", myArray[i][j]));
               }
               jTextArea1.append("\n");
           }
                   
               Solve.setEnabled(true);
               
       }
       catch(Exception e){
            jTextArea1.setText("Error Reading File");
            Solve.setEnabled(false);
            Save.setEnabled(false);
           
       }

    }//GEN-LAST:event_UploadActionPerformed

    private void SolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolveActionPerformed
    int countOne = 0;
        for (int i = 0; i < Col; i++)
        {
            if (myArray[2][i] == 1)
            {
                countOne++;
            }
        }
        if (countOne == Col)
        {
            int  max1 = myArray[0][0], max2 = myArray[0][0], maxDouble = 0, maxTriple = 0;
            for (int i = 0; i < Row; i++)
            {
                System.out.println(myArray[i][0]);
                if(myArray[i][0] > max1) // Находим макс элемент в первом столбце
                {
                    max1 = myArray[i][0];
                }
                if(myArray[i][1] > max2) //// Находим макс элемент во втором столбце
                {
                    max2 = myArray[i][1];
                }
            }
            
            for (int i = 0; i < Row; i++)
            {
                System.out.println(myArray[i][0]);
                if(myArray[i][0] == max1)
                {
                    myArray[i][0] = max1 * 2;
                }
                if(myArray[i][1] == max2)
                {
                    myArray[i][1] = max2 * 3;
                }
            }
            
            for (int i = 0; i < Row; i++)
            {
                
                System.out.println(myArray[i][1]);
            }
            Save.setEnabled(true);
        }
        else
        {
            
            jTextArea1.append("\n Третья строка не состоит только из единиц!");
        }
    }//GEN-LAST:event_SolveActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
    try
        {
            PrintWriter fileOutput = new PrintWriter(new OutputStreamWriter(new FileOutputStream(DirName + "output.txt")));
            for (int i = 0; i < Row; i++) // Сохранение результата в выходной файл
            {
                fileOutput.println("");
                for (int j = 0; j < Col; j++)
                {
                    fileOutput.print(String.format("%5d", myArray[i][j]));
                }
            }
            fileOutput.flush();// Метод Сохранения
            fileOutput.close(); // Метод закрытия файла
            
            jTextArea1.append("\n Результат: \n");
            for(int i = 0; i < Row; i++)
            {
                for (int j = 0; j < Col; j++)
                {
                
                    jTextArea1.append(String.format("%5d", myArray[i][j]));
                }
                jTextArea1.append("\n");
            }
        }
        catch(Exception e)
        {
            jTextArea1.append("Ошибка чтения или записи в файле");
        }
    }//GEN-LAST:event_SaveActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JButton Solve;
    private javax.swing.JButton Upload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
