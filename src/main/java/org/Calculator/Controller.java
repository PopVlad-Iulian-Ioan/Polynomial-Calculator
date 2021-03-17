package org.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    Controller(View viewInput){
        view=viewInput;
        view.addAddListener ( new Add() );
        view.addSubListener ( new Sub () );
        view.addMultiplyListener ( new Mul () );
        view.addDerivateListener (new Derivation ());
        view.addIntegrateListener ( new Integrate () );
        view.addEqualListener ( new Equal () );
        view.addNewListener ( new New () );

    }
    class Add implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.getUserInput ( view.pol1 );
            view.operation=Operation.ADD;
            view.field.setText ( "" );
        }
    }
    class Sub implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getUserInput ( view.pol1 );
            view.operation = Operation.SUB;
            view.field.setText ( "" );
        }
    }
    class Mul implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getUserInput ( view.pol1 );
            view.operation = Operation.MUL;
            view.field.setText ( "" );
        }
    }
    class Derivation implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getUserInput ( view.pol1 );
            view.operation = Operation.NONE;
            view.setField (view.pol1.derivation ( ));
        }
    }
    class Integrate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getUserInput ( view.pol1 );
            view.operation = Operation.NONE;
            view.setField (view.pol1.integrate ( ));
        }
    }
    class New implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.operation = Operation.NONE;
            view.field.setText ( "" );
        }
    }
    class Equal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getUserInput ( view.pol2 );
            switch (view.operation) {
                case ADD:
                    view.setField ( view.pol1.add ( view.pol2 ) );
                    break;
                case SUB:
                    view.setField (view.pol1.subtraction ( view.pol2  ));
                    break;
                case MUL:
                    view.setField (view.pol1.multiply ( view.pol2  ));
                    break;
                default:
                    view.showError ( "No operation has been selected" );
            }
        }
    }
}
