package main

public object Mixer{
    val channels = Array(12) {Channel()}
    val effectSlots = Array(4) {EffectSlot()}

    init{
        for(i in 0 .. 11){
            channels[i].name = "Channel $i"
        }
    }
}