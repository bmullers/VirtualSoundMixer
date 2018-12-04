package main

import org.lwjgl.openal.EXTEfx.alGenFilters

public class Filter{
    private var type : Int = 0
    private var param1 : Int = 0
    private var param2 : Int = 0
    private var alFilterId : Int = 0

    init{
        alFilterId = alGenFilters()
        alCheckError()
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