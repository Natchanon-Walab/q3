import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class XO_test extends JPanel
{   
   // int size = 5 ;// 5*5
    static JButton[] buttons; 
    static int size;
    static int turn  = 0;//ถ้าเลขนี้เป็นเลขคู่ให้ใส่ X แต่ถ้าเป็นเลขคี่ให้ใส่ O

    public XO_test()
    {
      setLayout(new GridLayout(size,size));
      initializebuttons(); 
    }

    public void initializebuttons()
    {
        for(int i = 0; i <= (size*size)-1; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);     
            //เพิ่มปุ่มนี้ใน JPanel (หมายเหตุ: ไม่จำเป็นสำหรับ JPanel.add(...)
            //เพราะทั้งคลาสนี้เป็น JPanel แล้ว    
        }
    }

    public void resetButtons()
    {
        for(int i = 0; i <= (size*size)-1; i++)
        {
            buttons[i].setText("");
        }
    }
// เมื่อคลิกปุ่มจะสร้าง ActionEvent ดังนั้น แต่ละปุ่มต้องมี ActionListener เมื่อคลิกแล้ว จะไปที่คลาส Listener 
    private class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if(turn%2 == 0){
               buttonClicked.setText("X"); 
               turn++;  
            }
                
            else{
                buttonClicked.setText("O");
                turn++;  
            }  
            
            if(checkForWin() == true){
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            } 
            
        }

        public boolean checkForWin()
        {           
            //check row win
            for(int row ; row < size ;row++){
                boolean win = true;
                String player = "";
                for(int col ; col < size ; col++){
                    if (buttons[ col + row * size ].getText().equals("")){
                        win = false;
                        break;
                    }else if(buttons[ col + row * size ].getText().equals("X")){
                        if(player == ""){
                            player = "X";
                        }else if(player == "O"){
                            win = false;
                            break;
                        }
                    }else if(buttons[ col + row * size ].getText().equals("O")){
                        if(player == ""){
                            player = "O";
                        }else if(player == "X"){
                            win = false;
                            break;
                        }
                    }
                    if ( win == true ) {
                    return true;
                }
                
                }
            }

            //check col win
            for(int col ; col < size ; col++){
                boolean win = true;
                String player = "";
                for(int row ; row < size ; row++){
                    if (buttons[ col + row * size ].getText().equals("")){
                        win = false;
                        break;
                    }else if(buttons[ col + row * size ].getText().equals("X")){
                        if(player == ""){
                            player = "X";
                        }else if(player == "O"){
                            win = false;
                            break;
                        }
                    }else if(buttons[ col + row * size ].getText().equals("O")){
                        if(player == ""){
                            player = "O";
                        }else if(player == "X"){
                            win = false;
                            break;
                        }
                    }
                }
                if ( win == true ) {
                    return true;
                }
            }
            

            for(int i ; i < size ; i++ ){
                boolean win = true;
                String player = "";
                if (buttons[ i + i * size ].getText().equals("")){
                        win = false;
                        break;
                    }else if(buttons[ i + i * size ].getText().equals("X")){
                        if(player == ""){
                            player = "X";
                        }else if(player == "O"){
                            win = false;
                            break;
                        }
                    }else if(buttons[ i + i * size ].getText().equals("O")){
                        if(player == ""){
                            player = "O";
                        }else if(player == "X"){
                            win = false;
                            break;
                        }
                    }
                }
                if ( win == true ) {
                    return true;
                }

                for(int i ; i < size ; i++ ){
                boolean win = true;
                String player = "";
                if (buttons[ size - i + i * size ].getText().equals("")){
                        win = false;
                        break;
                    }else if(buttons[ size - i + i * size ].getText().equals("X")){
                        if(player == ""){
                            player = "X";
                        }else if(player == "O"){
                            win = false;
                            break;
                        }
                    }else if(buttons[ size - i + i * size ].getText().equals("O")){
                        if(player == ""){
                            player = "O";
                        }else if(player == "X"){
                            win = false;
                            break;
                        }
                    }
                }
                if ( win == true ) {
                    return true;
                }
            return false;
            }
    }  


/*
            if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            //vertical win check ชนะแนวตั้ง
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            //diagonal win check ชนะแนวทะเเยง
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
        }
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        } 
    }
    */
    public static void main(String[] args) 
    {
        System.out.println("ใส่ขนาดที่ต้องการเล่น n x n : ");
        Scanner input = new Scanner(System.in);  
        size = Integer.parseInt(input.nextLine());
        buttons = new JButton[(int) Math.pow(size, 2)];
        JFrame window = new JFrame("XO_Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new XO_test());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }

}
