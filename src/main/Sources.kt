package main

import org.lwjgl.openal.AL10.*

public class Source(adress : String){
    public var alSourceId : Int = 0
    public var gain : Float = 0.1f

    init{
        alSourceId = alGenSources()
        alSource3f(alSourceId, AL_POSITION,0f,0f,0f)
        alCheckError()
    }

    fun playSource(){
        //PLAY
    }

    fun deleteSource(){
        //FREE MEMORY
    }
}