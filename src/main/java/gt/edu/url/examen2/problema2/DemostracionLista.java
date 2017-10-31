/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema2;

/**
 *
 * @author lam_m
 */
public class DemostracionLista implements DemoList{
    ArrayList<Integer> u = new ArrayList();
    
    @Override
    public List<Integer> crearDemoLista() {
        u.add(0, 4);
        u.add(0, 3);
        u.add(0, 2);
        u.add(2, 1);
        u.add(1, 5);
        u.add(1, 6);
        u.add(3, 7);
        u.add(0, 8);
        return u;
        
    }
    public int tam(){
        return u.size();
    }
    
}
