package main

public object Mixer{
    val channels = Array(12) {Channel()}

    init{
        for(i in 0 .. 11){
            channels[i].name = "Channel $i"
        }
    }
}