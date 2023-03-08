/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Menu {
    
    public static void Menu(){
        String[] options = {"Conversor de monedas","Conversor a binario"};
        
        String menuOption = (String)JOptionPane.showInputDialog(null,"Escoge una opción","Menu",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        
        if(menuOption == "Conversor de monedas")
        {
            menuMonedas();
        }
        else if(menuOption=="Conversor a binario")
        {
            binarioMenu();
        }
        else if(menuOption == null)
        {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            return;
        }
        
       
    }
    
    public static void menuMonedas()
    {
        String[] options = {"De Sol a Dolar","De Sol a Euro","De Sol a Libras","De Sol a Yen","De Sol a Won Coreano"
                ,"De Dolar a Sol","De Euro a Sol","De Libras a Sol","De Yen a Sol","De Won Coreano a Sol" };
        
        double[] tipoDeCambio = {
            0.26,0.25,0.22,35.87,344.15,
            3.79,4.05,4.56,0.028,0.0029
        };
        
        String[] nombreDeCambio = {" dolares"," euros"," libras"," yenes"," wones coreanos"
                ," soles"," soles"," soles"," soles"," soles" };
        
        
            String monedasMenu = (String) JOptionPane.showInputDialog(null,"Escoge una opción","Menu",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
      
            if(monedasMenu == null)
            {
                finalizar();
                return;
            }
            Monedas(options,monedasMenu,tipoDeCambio,nombreDeCambio);
        
    }
    public static void Monedas(String[] options,String monedasMenu,double[] tipoDeCambio,String[] nombreDeCambio){
     
        
        try {
        
            double dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que desee cambiar"));
            for (int i = 0; i < options.length; i++) {
            if(options[i]==monedasMenu)
            {
                JOptionPane.showMessageDialog(null, "Tienes "+dinero*tipoDeCambio[i]+nombreDeCambio[i]);
            }
        }  
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
            Monedas(options, monedasMenu, tipoDeCambio, nombreDeCambio);
        } catch (NullPointerException e)
        {
            finalizar();
            return;
        }
        finalizar();
     
    }
    
   
    public static void binarioMenu()
    {
        String[] options = {"Convertir de binario a decimal","Convertir de decimal a binario"};
        
        String menuOption = (String)JOptionPane.showInputDialog(null,"Escoge una opción","Menu",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        
        if(menuOption == "Convertir de binario a decimal")
        {
            deBinarioaDecimal();
        }
        else if(menuOption=="Convertir de decimal a binario")
        {
            deDecimalaBinario();
        }
        else if(menuOption == null)
        {
            finalizar();
            return;
        }
    }
    
    public static void deBinarioaDecimal()
    {
            int decimal = 0;
            int potencia = 0;
            String binario = JOptionPane.showInputDialog("Digite un numero binario que quiera convertir a decimal");
            
            if(binario == null)
            {
                finalizar();
                return;
            }
            else if(binario.matches("^[0-1]+$"))
            {
                for (int i = binario.length()-1; i >= 0; i--) {
                   
                    if(binario.charAt(i)=='1')
                    {
                        decimal = (int) (decimal+Math.pow(2, potencia));
                        
                        
                    }
                    potencia++;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese un valor binario");
                deBinarioaDecimal();
                return;
            }
            JOptionPane.showMessageDialog(null, "El numero en decimal es: "+decimal);
            
            finalizar();
        
        
    }
    
    
        public static void deDecimalaBinario()
    {
        StringBuilder binario = new StringBuilder();
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero que quiera convertir a binario"));
            while(numero>1)
            {
                if(numero%2==0)
                {
                    binario.append("0");
                }
                else{
                    binario.append("1");
                }
                numero = numero/2;
            }
            binario.append("1");
            JOptionPane.showMessageDialog(null, "El numero el binario es: "+binario.reverse());
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico");
            deBinarioaDecimal();
            return;
        } catch (NullPointerException e)
        {
            finalizar();
            return;
        }
        finalizar();
        
        
    }
        
    public static void finalizar()
    {
        int continuar = JOptionPane.showConfirmDialog(null, "desea continuar?","Selecione una opción",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null);
        
        if(continuar == 0){
            Menu();
        }
        if(continuar == 1)
        {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            return;
        }
        if(continuar == 2)
        {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            return;
        }
    
    }
    
    public static void main(String[] args) {
       
      Menu();
       
        
    }
}
