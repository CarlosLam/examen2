/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.examen2.main;
import gt.edu.url.examen2.problema2.DemostracionLista;
import gt.edu.url.examen2.problema5.ArrayStack;
import gt.edu.url.examen2.problema3.Position;
import gt.edu.url.examen2.problema3.LinkedPositionalList;
import gt.edu.url.examen2.problema4.PositionalLinkedList;
/**
 *
 * @author lam_m
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DemostracionLista dL = new DemostracionLista();
        //Problema 2 
        int index = dL.crearDemoLista().size();
        
        for(int i =0;i<index;i++){
            System.out.println(dL.crearDemoLista().get(i));
        }
        
        //Problema 5
        ArrayStack<String>aS = new ArrayStack<>();
        aS.push("Hola");
        aS.push("QUE");
        aS.push("hace");
        aS.push("Se");
        aS.push("Agranda");
        
        //Problema 3
        LinkedPositionalList<String> LPL = new LinkedPositionalList<>();
        Position<String> P1, P2, P3;
        
        P1 = LPL.addFirst("Primero");
        P1 = LPL.addAfter(P1, "Segundo");
        P2 = LPL.addAfter(P1, "Cuarto");
        P2 = LPL.addAfter(P2, "Quinto");
        LPL.swap(P1, P2);
       
        //Problema 4
        PositionalLinkedList<String> PLL = new PositionalLinkedList<>();
        PLL.addFirst("Primero");
        PLL.addFirst("Segundo");
        PLL.addLast("Tercero");
        System.out.println(PLL.positionAtIndex(3).getElement());
        
    }
    
}
