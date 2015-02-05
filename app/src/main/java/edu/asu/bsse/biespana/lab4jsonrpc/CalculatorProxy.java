package edu.asu.bsse.biespana.lab4jsonrpc;

/**
 * Created by biespana on 2/5/15.
 */
public class CalculatorProxy {

    private JsonRpcRequestViaHttp server;

    //TODO:In this class, all operations will be sent to the server class, not performed locally
    public double multiply(double left, double right){
        double result = 0;
        result = left*right;
        return result;


    }

    public double dividie(double left, double right){
        double result = 0;
        result = left/right;
        return result;


    }

    public double add(double left, double right){
        double result = 0;
        result = left + right;
        return result;


    }

    public double subtract(double left, double right){
        double result = 0;
        result = left - right;
        return result;


    }
}
