package org.Calculator;


public class App 
{
    public static void main( String[] args )
    {

        Polynomial pol1=new Polynomial (  );
        Polynomial pol2=new Polynomial (  );
        View view=new View (pol1,pol2);
        Controller controller=new Controller (view);

    }
}
