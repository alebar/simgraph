/**
 *
 * @author alebar
 */
import geom.Polyhedron;
import gui.*;
import math.*;
import vertexfinder.*;
import virtualcamera.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IManagement manager = new Zarzadca();
        IMovement move = new Ruch3D(manager);

        double[][] a = {    { 1, 1, 1 },
                            { -1, 0, 0 },
                            { 0, -1, 0 },
                            { 0, 0, -1 },};
        double [] b_tab = { 1000, 0, 0, 0 };
        Matrix A = new Matrix (a);
        Vector b = new Vector(b_tab);
        IVertex ver = new Solver3D();
        ver.setSystem(A, b);
        manager.setVertex(ver.vertexFind());
        IGui gui = new GUI(move, manager);
        manager.setGuiInterface(gui);
        
        manager.start();

    }

}