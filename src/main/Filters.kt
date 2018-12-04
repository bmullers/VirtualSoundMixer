package main

public class Filter{
    private var type : Int = 0
    private var param1 : Int = 0
    private var param2 : Int = 0
    private val alFilterId : Int = 0

    fun Filter(){
        //CREATE FILTER
    }

    fun setType(value : Int){
        //CONTROL VALUE DOMAIN
        type = value
        //SET TO CORRESPONDING FILTER TYPE
    }

    fun setParam1(value : Int){
        //CONTROL VALUE DOMAIN
        param1 = value;
        //SET TO CORRESPONDING PARAM VALUE
    }
}