package org.Calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Add()
    {
        System.out.println ("Add:");
        Polynomial pol=new Polynomial ( );
        Polynomial pol1= new Polynomial (  );
        pol.polynomial.add ( new Monomial ( 5,7 ) );
        pol.polynomial.add ( new Monomial ( 3,12 ) );
        pol.polynomial.add ( new Monomial ( 2,5 ) );
        pol.polynomial.add ( new Monomial ( 1,-5 ) );
        System.out.println ("first polynomial: "+pol.print ());

        pol1.polynomial.add ( new Monomial ( 4,1 ) );
        pol1.polynomial.add ( new Monomial ( 1,6 ) );
        pol1.polynomial.add (  new Monomial ( 0,4 ) );
        System.out.println ("second polynomial: "+pol1.print ());
        System.out.println ("result: "+pol.add (  pol1 ).print ());
        assertTrue( true );
    }
    @Test
    public void Sub()
    {
        System.out.println ("Subtraction:");
        Polynomial pol=new Polynomial ( );
        Polynomial pol1= new Polynomial (  );
        pol.polynomial.add ( new Monomial ( 5,7 ) );
        pol.polynomial.add ( new Monomial ( 3,12 ) );
        pol.polynomial.add ( new Monomial ( 2,5 ) );
        pol.polynomial.add ( new Monomial ( 1,-5 ) );
        System.out.println ("first polynomial: "+pol.print ());

        pol1.polynomial.add ( new Monomial ( 4,1 ) );
        pol1.polynomial.add ( new Monomial ( 1,6 ) );
        pol1.polynomial.add (  new Monomial ( 0,4 ) );
        System.out.println ("second polynomial: "+pol1.print ());
        System.out.println ("result: "+pol.subtraction (  pol1 ).print ());
        assertTrue( true );
    }
    @Test
    public void Multiply()
    {
        System.out.println ("Multiply:");
        Polynomial pol=new Polynomial ( );
        Polynomial pol1= new Polynomial (  );
        pol.polynomial.add ( new Monomial ( 5,7 ) );
        pol.polynomial.add ( new Monomial ( 3,12 ) );
        pol.polynomial.add ( new Monomial ( 2,5 ) );
        pol.polynomial.add ( new Monomial ( 1,-5 ) );
        System.out.println ("first polynomial: "+pol.print ());

        pol1.polynomial.add ( new Monomial ( 4,1 ) );
        pol1.polynomial.add ( new Monomial ( 1,6 ) );
        pol1.polynomial.add (  new Monomial ( 0,4 ) );
        System.out.println ("second polynomial: "+pol1.print ());
        System.out.println ("result: "+pol.multiply (  pol1 ).print ());
        assertTrue( true );
    }
    @Test
    public void Derivation()
    {
        System.out.println ("Derivation:");
        Polynomial pol=new Polynomial ( );
        Polynomial pol1= new Polynomial (  );
        pol.polynomial.add ( new Monomial ( 5,7 ) );
        pol.polynomial.add ( new Monomial ( 3,12 ) );
        pol.polynomial.add ( new Monomial ( 2,5 ) );
        pol.polynomial.add ( new Monomial ( 1,-5 ) );
        System.out.println ("polynomial: "+pol.print ());

        System.out.println ("result: "+pol.derivation ().print ());
        assertTrue( true );
    }
    @Test
    public void Integrate()
    {
        System.out.println ("Integration:");
        Polynomial pol=new Polynomial ( );
        Polynomial pol1= new Polynomial (  );
        pol.polynomial.add ( new Monomial ( 5,7 ) );
        pol.polynomial.add ( new Monomial ( 3,12 ) );
        pol.polynomial.add ( new Monomial ( 2,5 ) );
        pol.polynomial.add ( new Monomial ( 1,-5 ) );
        System.out.println ("polynomial: "+pol.print ());

        System.out.println ("result: "+pol.integrate ().print ());
        assertTrue( true );
    }
}
