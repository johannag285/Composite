package com.composite.app;

import com.composite.orders.SaleOrder;
import com.composite.products.CompositeProduct;
import com.composite.products.SimpleProduct;
import java.util.Random;

/**
 * Application permite al cliente interactuar con las composiciones
 */
@SuppressWarnings("ALL")
public class Application {

    //TODO Tarea! Extender el ejemplo para crear un tipo de PC corporativo con sus propias características y un tipo de laptop (portátil) con sus propias características.

    private final Random random = new Random();

    private SimpleProduct ram4gb;
    private SimpleProduct ram8gb;
    private SimpleProduct disk500gb;
    private SimpleProduct disk1tb;
    private SimpleProduct cpuAMD;
    private SimpleProduct cpuIntel;
    private SimpleProduct smallCabinete;
    private SimpleProduct bigCabinete;
    private SimpleProduct monitor20inch;
    private SimpleProduct monitor30inch;
    private SimpleProduct simpleMouse;
    private SimpleProduct gammerMouse;
    //caracteristicas laptop
    private SimpleProduct ram12gb;
    private SimpleProduct dicoDuroEstadoSolido;
    private SimpleProduct tecladoTipoIsla;
    private SimpleProduct procesadorCore5;
    private SimpleProduct pantallaFullHD;
    //caracteristicas PC corporativo
    private SimpleProduct procesadorRyzen5;
    private SimpleProduct tarjetaVideoRadeonPro;
    private SimpleProduct nucleosQuadCore;
    
    

    private CompositeProduct gammerPC;
    private CompositeProduct homePC;
    private CompositeProduct pc2x1;
    private CompositeProduct corporatePC;
    private CompositeProduct laptop;

    public Application(){
        buildProducts();
    }

    private void buildProducts() {
        //Simple product construction
        ram4gb = new SimpleProduct("RAM 4GB", 750, "KingStone");
        ram8gb = new SimpleProduct("RAM 8GB", 1000, "KingStone");
        disk500gb = new SimpleProduct("HDD 500GB", 1500, "ACME");
        disk1tb = new SimpleProduct("HDD 1TB", 2000, "ACME");
        cpuAMD = new SimpleProduct("AMD phenon", 4000, "AMD");
        cpuIntel = new SimpleProduct("Intel i7", 4500, "Intel");
        smallCabinete = new SimpleProduct("Small cabinet", 2000, "ExCom");
        bigCabinete = new SimpleProduct("Big Cabinet", 2200, "ExCom");
        monitor20inch = new SimpleProduct("Display 20'", 1500, "HP");
        monitor30inch = new SimpleProduct("Display 30'", 2000, "HP");
        simpleMouse = new SimpleProduct("Simple mouse", 150, "Genius");
        gammerMouse = new SimpleProduct("Gammer mouse", 750, "Alien");
        
        //laptop
        ram12gb = new SimpleProduct("RAM 12 GB", 1500, "HP");
        dicoDuroEstadoSolido = new SimpleProduct("DS 500GB", 2500, "ACME");
        tecladoTipoIsla = new SimpleProduct("Teclado Tipo Isla", 500, "HP");
        procesadorCore5 = new SimpleProduct("Intel Core 5", 4000, "Intel");
        pantallaFullHD = new SimpleProduct("Panta HD", 1000, "HP");
        
        //PC Coorporativo
         procesadorRyzen5 = new SimpleProduct("Ryzen 5", 1600, "Ryzen");
         tarjetaVideoRadeonPro = new SimpleProduct("Tarjeta de Video", 1000, "Radeon");
         nucleosQuadCore = new SimpleProduct("Nucleos", 5000, "Ryzen");
        
        //Composite product - Gammer pc with 8gb ram,HDD 1tb, Intel i7 processor
        //large cabinet,display 30' and one gammer mouse.
        gammerPC = new CompositeProduct("Gammer PC");
        gammerPC.addProduct(ram8gb);
        gammerPC.addProduct(disk1tb);
        gammerPC.addProduct(cpuIntel);
        gammerPC.addProduct(bigCabinete);
        gammerPC.addProduct(monitor30inch);
        gammerPC.addProduct(gammerMouse);

        //Composite product - Package consisting of two packages, Gammer PC + Home PC
        pc2x1 = new CompositeProduct("Pack PC Gammer + Home PC");
        pc2x1.addProduct(gammerPC);
        pc2x1.addProduct(homePC);
        
        //Composite Product --  Laptop
        laptop = new CompositeProduct("Laptop");
        laptop.addProduct(ram12gb);
        laptop.addProduct(dicoDuroEstadoSolido);
        laptop.addProduct(tecladoTipoIsla);
        laptop.addProduct(procesadorCore5);
        laptop.addProduct(pantallaFullHD);
        
        //Composite Product -- PC Coorporativo
        corporatePC = new CompositeProduct("PC Corporativo");
        corporatePC.addProduct(ram12gb);
        corporatePC.addProduct(procesadorRyzen5);
        corporatePC.addProduct(tarjetaVideoRadeonPro);
        corporatePC.addProduct(nucleosQuadCore);
        
    }

    public void orderSimpleProducts() {

        SaleOrder simpleProductOrder = new SaleOrder(random.nextInt(), "Juan Pachón");
        simpleProductOrder.addProduct(ram4gb);
        simpleProductOrder.addProduct(disk1tb);
        simpleProductOrder.addProduct(simpleMouse);
        simpleProductOrder.printOrder();
    }

    public void orderGammerPC() {
        SaleOrder gammerOrder = new SaleOrder(1, "Carlos Quijano");
        gammerOrder.addProduct(gammerPC);
        gammerOrder.printOrder();
    }

    public void orderCombo() {
        SaleOrder comboOrder = new SaleOrder(3, "Paquete 2x1 en PC");
        comboOrder.addProduct(pc2x1);
        comboOrder.printOrder();
    }

    public void orderBig() {
        SaleOrder customOrder = new SaleOrder(4, "Cristian Sanchez");
        customOrder.addProduct(homePC);
        customOrder.addProduct(ram8gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(monitor30inch);
        customOrder.addProduct(gammerMouse);
        customOrder.printOrder();
    }

    public void orderCorporatePc(){
        SaleOrder corporatePc = new SaleOrder(5, "Martin Sandoval");
        corporatePc.addProduct(corporatePC);
        corporatePc.printOrder();
    }
    
    public void orderLaptop(){
        SaleOrder laptopPC = new SaleOrder(5, "Johanna González");
        laptopPC.addProduct(laptop);
        laptopPC.printOrder();
    }
}
