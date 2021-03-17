package org.Calculator;

import java.util.ArrayList;
import java.util.List;

class Polynomial {
    public List<Monomial> polynomial= new ArrayList<Monomial> (  );

    public Polynomial(List<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public Polynomial() {
        polynomial.clear ();
    }

    public Polynomial add(Polynomial polynomial){
        Polynomial result=new Polynomial (  );
        int i=0,j=0;
        while(i!=this.polynomial.size () && j!=polynomial.polynomial.size ()){
            //if there are 2 monomials with the same grade add them and then add the result to the result polynomial
            if(this.polynomial.get ( i ).getGrade ()==polynomial.polynomial.get ( j ).getGrade ()){
                result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue ()+polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
                i++;
                j++;
            }//if the grade of one of the monomials is grater it means that it has no match in the other polynomial
            else if(this.polynomial.get ( i ).getGrade ()>polynomial.polynomial.get ( j ).getGrade ()){
                result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue () ) );
                i++;
            }
            else if(this.polynomial.get ( i ).getGrade ()<polynomial.polynomial.get ( j ).getGrade ()){
                result.polynomial.add ( new Monomial (polynomial.polynomial.get(j).getGrade (),polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
                j++;
            }
        }
        //add the remaining polynomials to the result
        while (i!=this.polynomial.size ()){
            result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue () ) );
            i++;
        }
        while(j!=polynomial.polynomial.size ()) {
            result.polynomial.add ( new Monomial ( polynomial.polynomial.get ( j ).getGrade () , polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
            j++;
        }
        return result;
    }
    public Polynomial subtraction(Polynomial polynomial){
        Polynomial result=new Polynomial (  );
        int i=0,j=0;
        //Same logic applied to the add method
        while(i!=this.polynomial.size () && j!=polynomial.polynomial.size ()){
            if(this.polynomial.get ( i ).getGrade ()==polynomial.polynomial.get ( j ).getGrade ()){
                result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue ()-polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
                i++;
                j++;
            }
            else if(this.polynomial.get ( i ).getGrade ()>polynomial.polynomial.get ( j ).getGrade ()){
                result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue () ) );
                i++;
            }
            else if(this.polynomial.get ( i ).getGrade ()<polynomial.polynomial.get ( j ).getGrade () ){
                result.polynomial.add ( new Monomial (polynomial.polynomial.get(j).getGrade (),(-1)*polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
                j++;
            }
        }
        while (i!=this.polynomial.size ()){
            result.polynomial.add ( new Monomial (this.polynomial.get(i).getGrade (),this.polynomial.get ( i ).getCoefficient ().intValue () ) );
            i++;
        }
        while(j!=polynomial.polynomial.size ()){
            result.polynomial.add ( new Monomial (polynomial.polynomial.get(j).getGrade (),(-1)*polynomial.polynomial.get ( j ).getCoefficient ().intValue () ) );
            j++;
        }
        return result;
    }
    public Polynomial multiply(Polynomial multiplier){
        Polynomial result=new Polynomial (  );
        for (Monomial monomial: this.polynomial) {
            for (Monomial monomialM:multiplier.polynomial){
                result.polynomial.add ( new Monomial ( monomial.getGrade ()+monomialM.getGrade () ,monomial.getCoefficient().intValue () *monomialM.getCoefficient ().intValue () ));
            }
        }
        return result;
    }
    public Polynomial derivation(){
        Polynomial result=new Polynomial (  );
        for (Monomial monomial : this.polynomial){
            result.polynomial.add(new Monomial (monomial.getGrade ()-1,monomial.getCoefficient ().intValue ()*monomial.getGrade ()   ));
        }
        return  result;
    }
    public Polynomial integrate(){
        Polynomial result=new Polynomial (  );
        for (Monomial monomial : this.polynomial){
            result.polynomial.add(new Monomial(monomial.getGrade ()+1,monomial.getCoefficient ().doubleValue ()/(monomial.getGrade ()+1)));
        }
        return result;
    }
    public String print(){
        String result=new String (  );
        for (Monomial monomial:this.polynomial) {
            result=result.concat ( monomial.toString () );
        }
        return result;
    }
}