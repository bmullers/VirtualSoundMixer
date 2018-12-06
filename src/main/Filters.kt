package main

import org.lwjgl.openal.EXTEfx.*

public class Filter{
    private var type : Int = 0
    private var gain : Float = 0f
    private var gainLF : Float = 0f
    private var gainHF : Float = 0f
    private var alFilterId : Int = 0

    init{
        alFilterId = alGenFilters()
        alCheckError()
    }

    /**
     * sets the type of the filter to the type corresponding to value
     * 0 : null
     * 1 : lowpass
     * 2 : highpass
     * 3 : bandpass
     */
    fun setType(value : Int){
        if (value > 3 || value < 0){
            throw Exception("Value out of range")
        }
        type = value
        alFilteri(alFilterId,AL_FILTER_TYPE,value)
        alCheckError()
    }

    fun setGain(value : Float){
        if(value !in 0f .. 1f) return
        when(type){
            0 -> return
            1 -> alFilterf(alFilterId,AL_LOWPASS_GAIN,value)
            2 -> alFilterf(alFilterId,AL_HIGHPASS_GAIN,value)
            3 -> alFilterf(alFilterId,AL_BANDPASS_GAIN,value)
        }
        alCheckError()
        gain = value

    }

    fun setGainHF(value : Float){
        if(value !in 0f .. 1f) return
        when(type){
            0 -> return
            1 -> alFilterf(alFilterId, AL_LOWPASS_GAINHF,value)
            2 -> return
            3 -> alFilterf(alFilterId,AL_BANDPASS_GAINHF,value)
        }
        alCheckError()
        gainHF = value
    }

    fun setGainLF(value : Float){
        if(value !in 0f .. 1f) return
        when(type){
            0 -> return
            1 -> return
            2 -> alFilterf(alFilterId,AL_HIGHPASS_GAINLF,value)
            3 -> alFilterf(alFilterId,AL_BANDPASS_GAINLF,value)
        }
        alCheckError()
        gainLF = value
    }
}