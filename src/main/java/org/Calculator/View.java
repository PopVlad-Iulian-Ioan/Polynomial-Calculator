package org.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View extends JFrame {

    Polynomial pol1;
    Polynomial pol2;
    Operation operation;//what will be done

    JTextArea field=new JTextArea (  );
    JPanel buttons= new JPanel (  );
    JButton add=new JButton (  );
    JButton sub= new JButton (  );
    JButton mul= new JButton (  );
    JButton div= new JButton (  );
    JButton der= new JButton (  );
    JButton integ= new JButton (  );
    JButton equ= new JButton (  );
    JButton newB= new JButton (  );
    JScrollPane scrollPane=new JScrollPane (  );
    View(Polynomial pol1, Polynomial pol2) {
        this.pol1=pol1;
        this.pol2=pol2;
        operation=Operation.NONE;

        JFrame f=new JFrame("Calculator");//creating instance of JFrame
        //field
        field.setBounds ( 50,30,200,40 );
        //scrollbar
        scrollPane.setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        getContentPane ().setBackground ( Color.white );
        scrollPane.setBounds ( 50,30,200,40 );
        scrollPane.getViewport ().setBackground ( Color.WHITE );
        scrollPane.getViewport().add ( field );
        f.add(scrollPane);
        //layout
        buttons.setLayout ( new FlowLayout (  ));
        buttons.setBounds ( 0,100,300,200 );
        buttons.setVisible ( true );
        //add
        add.setText ( "+" );
        buttons.add(add);
        //subtraction
        sub.setText ( "-" );
        buttons.add(sub);
        //multiply
        mul.setText ( "*" );
        buttons.add(mul);
        //division
        div.setText ( "/" );
        buttons.add(div);
        //derivation
        der.setText ( "derivation" );
        buttons.add(der);
        //integration
        integ.setText ( "integration" );
        buttons.add(integ);
        //equal
        equ.setText ( "=" );
        buttons.add(equ);
        //new
        newB.setText ( "new" );
        buttons.add(newB);

        f.add(buttons);
        f.setSize(300,200);
        f.setLayout( null );
        f.setVisible(true);
        f.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
    }
    Polynomial getUserInput(Polynomial polynomial) {
        polynomial.polynomial.clear ();
        String userInput=field.getText();
        String pat="(\\+,-)?\\d+x\\^(-)?\\d+";
        int i=0,j,gradPrev=Integer.MAX_VALUE;;
        char []input=new char[userInput.length ()];
        for(j=0;j<userInput.length ();j++){
            input[j]=userInput.charAt ( j );
        }
        int neg=1;//indicates if a number is negative or positive
        try{
           while (i<userInput.length ()) {
               char[] coefficient= new char[10];//for the coefficient of the polynomial
               char[] grade= new char[10];//for the grade of the polynomial
                char[] pol= new char[30];//for pattern checking
               int iPol=0,iGr=0,iCoeff=0;
               int coeff=0,gradCurr=0,c=0;

                while (i!=userInput.length ()&&input[i]!=' ' ){
                    pol[iPol]=input[i];
                    iPol++;
                    i++;
                }
                iPol=0;
               //check the pattern
                Pattern pattern=Pattern.compile ( pat );
                Matcher m=pattern.matcher (String.valueOf ( pol )  );
                if(!m.find ())
                    throw new NumberFormatException();
                if(pol[iPol]=='+'){
                    iPol++;
                    neg=1;
                }
                else if(pol[iPol]=='-'){
                    iPol++;
                    neg=-1;
                }
                while (Character.isDigit ( pol[iPol] )){
                   coefficient[iCoeff]=pol[iPol];
                   iCoeff++;
                   iPol++;
               }
                iPol=iPol+2;//skip over x^
               while (Character.isDigit ( pol[iPol] )){
                   grade[iGr]=pol[iPol];
                   iGr++;
                   iPol++;
               }
               i++;//skip over the space character
               //make polynomial

               while (Character.isDigit ( coefficient[c] )){
                   coeff=coeff*10+Character.getNumericValue ( coefficient[c] );
                   c++;
               }
               c=0;
               while (Character.isDigit ( grade[c] )){
                   gradCurr=gradCurr*10+Character.getNumericValue ( grade[c] );
                   c++;
               }
               if(gradCurr>gradPrev)
                   throw new IOException ();
               if(neg==-1)
                   coeff=0-coeff;
               polynomial.polynomial.add ( new Monomial ( gradCurr,coeff ));
               gradPrev=gradCurr;
        }

             }
        catch (NumberFormatException e)
        {
            showError ( "Bad input, the structure of a monomial should be numberx^number and the monomials should be separated by a space" );
        }
        catch (IOException e){
            showError ( "The monomial grades must be inserted in decreasing order" );
        }
        return polynomial;
    }

    void setField(Polynomial polynomial) {
        field.setText(polynomial.print ());
    }
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    void addAddListener(ActionListener e) {
        add.addActionListener(e);

    }
    void addSubListener(ActionListener e) {
        sub.addActionListener(e);
    }
    void addMultiplyListener(ActionListener e) {
        mul.addActionListener(e);
    }
    void addDivListener(ActionListener e) {
        div.addActionListener(e);
    }
    void addDerivateListener(ActionListener e) {
        der.addActionListener(e);
    }
    void addIntegrateListener(ActionListener e) {
        integ.addActionListener(e);
    }
    void addEqualListener(ActionListener e) {
        equ.addActionListener(e);
    }
    void addNewListener(ActionListener e) {
        newB.addActionListener(e);
    }

}
