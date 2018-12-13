package main

import org.lwjgl.openal.AL10.*
import org.lwjgl.stb.STBVorbis.stb_vorbis_decode_filename
import org.lwjgl.system.MemoryStack.*
import org.lwjgl.system.libc.LibCStdlib.*

public class Source(address : String){
    public var alSourceId : Int = 0
    public var gain : Float = 0.1f
    public var dataBuffer : Int = 0

    init{
        //TODO : support sound files larger than one buffer
        alSourceId = alGenSources()
        alSource3f(alSourceId, AL_POSITION,0f,0f,0f)
        alCheckError()
        dataBuffer = alGenBuffers()
        alCheckError()

        //allocating buffers to collect data about source file
        stackPush()
        val channelsBuffer = stackMallocInt(1)
        stackPush()
        val sampleRateBuffer = stackMallocInt(1)
        //loading data from source
        val rawAudioBuffer = stb_vorbis_decode_filename(address, channelsBuffer, sampleRateBuffer)
        //storing buffered data into variables and freeing memory space
        val channels = channelsBuffer.get(0)
        val sampleRate = sampleRateBuffer.get(0)
        stackPop()
        stackPop()

        var format = -1
        if (channels == 1) {
            format = AL_FORMAT_MONO16
        } else if (channels == 2) {
            format = AL_FORMAT_STEREO16
        }
        alBufferData(dataBuffer,format,rawAudioBuffer,sampleRate)
        free(rawAudioBuffer)
    }

    fun playSource(){
        alSourcePlay(alSourceId)
    }

    fun deleteSource(){
        //FREE MEMORY
    }
}