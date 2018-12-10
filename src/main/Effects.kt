package main

import org.lwjgl.openal.AL10.AL_FALSE
import org.lwjgl.openal.EXTEfx.*

/**
 * This class represents an effect
 * This is an immutable object
 * There are 13 supported effect types, each represented by an integer
 * 0 : null
 * 1 : reverb
 * 2 : chorus
 * 3 : distortion
 * not implemented after this point
 * 4 : echo
 * 5 : flanger
 * 6 : frequency shifter
 * 7 : vocal morpher
 * 8 : pitch shifter
 * 9 : ring modulator
 * 10 : autowah
 * 11 : compressor
 * 12 : equalizer
 */
public class Effect{
    private var alEffectId : Int = 0
    //This constructor is really exhaustive
    //It generates
    constructor(type : Int, parameters : Array<Float>?,name : String){
        alEffectId = alGenEffects()
        when(type){
            1 -> {
                alEffecti(alEffectId, AL_EFFECT_TYPE, AL_EFFECT_REVERB)
                alCheckError()
                if(parameters == null) return
                if(parameters[0] in 0.0f .. 1.0f) alEffectf(alEffectId,AL_REVERB_DENSITY,parameters[0]) //Density
                if(parameters[1] in 0.0f .. 1.0f) alEffectf(alEffectId,AL_REVERB_DIFFUSION,parameters[1]) //Diffusion
                if(parameters[2] in 0.0f .. 1.0f) alEffectf(alEffectId,AL_REVERB_GAIN,parameters[2]) //Gain
                if(parameters[3] in 0.0f .. 1.0f) alEffectf(alEffectId,AL_REVERB_GAINHF,parameters[3]) //Gain HF
                if(parameters[4] in 0.1f .. 20f) alEffectf(alEffectId, AL_REVERB_DECAY_TIME,parameters[4])  //Decay time
                if(parameters[5] in 0.1f .. 20f) alEffectf(alEffectId, AL_REVERB_DECAY_HFRATIO,parameters[5]) //decay hfratio
                if(parameters[6] in 0.0f .. 3.16f) alEffectf(alEffectId, AL_REVERB_REFLECTIONS_GAIN,parameters[6]) //reflections gain
                if(parameters[7] in 0.0f .. 0.3f) alEffectf(alEffectId, AL_REVERB_REFLECTIONS_DELAY,parameters[7]) //reflections delay
                if(parameters[8] in 0.0f .. 10.0f) alEffectf(alEffectId, AL_REVERB_LATE_REVERB_DELAY,parameters[8]) //late reverb gain
                if(parameters[9] in 0.0f .. 0.1f) alEffectf(alEffectId, AL_REVERB_LATE_REVERB_DELAY,parameters[9]) //late reverb delay
                if(parameters[10] in 0.892f .. 0.1f) alEffectf(alEffectId, AL_REVERB_AIR_ABSORPTION_GAINHF,parameters[10]) //air absorption gain hf
                if(parameters[11] in 0.0f .. 10.0f) alEffectf(alEffectId, AL_REVERB_ROOM_ROLLOFF_FACTOR,parameters[11]) //room rolloff
                if(parameters[12] as Int == AL_FALSE) alEffectf(alEffectId, AL_REVERB_DECAY_HFLIMIT,parameters[12]) //decay hf limit
                alCheckError()
            }
            2 -> {
                alEffecti(alEffectId, AL_EFFECT_TYPE,AL_EFFECT_CHORUS)
                alCheckError()
                if(parameters == null) return
                if(parameters[0] as Int == AL_CHORUS_WAVEFORM_SINUSOID) alEffectf(alEffectId, AL_CHORUS_WAVEFORM,parameters[0]) //Waveform
                if(parameters[1] in -180f .. 180f) alEffectf(alEffectId, AL_CHORUS_PHASE,parameters[1]) //Phase
                if(parameters[2] in 0.0f .. 10.0f) alEffectf(alEffectId, AL_CHORUS_RATE,parameters[2]) //rate
                if(parameters[3] in 0.0f .. 1.0f) alEffectf(alEffectId, AL_CHORUS_DEPTH,parameters[3]) //depth
                if(parameters[4] in -1.0f .. 1.0f) alEffectf(alEffectId, AL_CHORUS_FEEDBACK,parameters[4]) //feedback
                if(parameters[5] in 0.0f .. 0.016f) alEffectf(alEffectId, AL_CHORUS_DELAY,parameters[5]) //delay
            }
            3 -> {
                alEffecti(alEffectId, AL_EFFECT_TYPE, AL_EFFECT_DISTORTION)
                alCheckError()
                if(parameters == null) return
                if(parameters[0] in 0.0f .. 1.0f) alEffectf(alEffectId, AL_DISTORTION_EDGE,parameters[0]) //edge
                if(parameters[1] in 0.01f .. 1.0f) alEffectf(alEffectId, AL_DISTORTION_GAIN,parameters[1]) //gain
                if(parameters[2] in 80.0f .. 24000f) alEffectf(alEffectId, AL_DISTORTION_LOWPASS_CUTOFF,parameters[2]) //lowpass cutoff
                if(parameters[3] in 80.0f .. 24000f) alEffectf(alEffectId, AL_DISTORTION_EQCENTER,parameters[3]) //eqcenter
                if(parameters[4] in 80.0f .. 24000f) alEffectf(alEffectId, AL_DISTORTION_EQBANDWIDTH,parameters[4]) //eq bandwidth
            }
        }
    }
}

public class EffectSlot{
    public var effectAttached : Effect? = null
    private var alEffectSlotId : Int = 0

    init{
        alEffectSlotId = alGenAuxiliaryEffectSlots()
        alCheckError()
    }
}
