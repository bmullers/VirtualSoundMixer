package main
import org.lwjgl.openal.AL
import org.lwjgl.openal.ALC
import org.lwjgl.openal.ALC10.*



fun init(){
    //First we verify if the needed extensions are supported
    //Enumeration extension
    if(!alcIsExtensionPresent(0,"ALC_ENUMERATION_EXT")) throw Exception("Enumeration Extension not supported")
    //Effects extension
    if(!alcIsExtensionPresent(0,"ALC_EXT_EFX")) throw Exception("Effects extension not supported")

    //We retrieve the default device's name and open that device
    val defaultDeviceName : String? = alcGetString(0,ALC_DEVICE_SPECIFIER)?: throw Exception("Couldn't retrieve default device name")
    val device : Long = alcOpenDevice(defaultDeviceName)
    if(device as Int == 0) throw Exception("Could not open default device")

    //Creating a context and setting is as current context
    val context : Long = alcCreateContext(device,IntArray(1)) //attributes = {0}
    alcMakeContextCurrent(context)
    val alcCapabilities = ALC.createCapabilities(device)
    val alCapabilities = AL.createCapabilities(alcCapabilities)
}

//TODO : Function to get list of available device names
//TODO : Function to switch context from one device to another