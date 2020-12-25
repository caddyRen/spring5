package org.bougainvillea.spring5.ioc;

/**
 * DI
 *
 * @author renqiankun
 */
public class Book {
    private String bname;
    private String bauthor;

    public Book(String bname, String bauthor) {
        this.bname = bname;
        this.bauthor = bauthor;
    }
     public void show(){
         System.out.println(bauthor+"编写了"+bname);
     }
}
