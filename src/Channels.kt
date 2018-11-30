public class Channel(val number : Int){
    private var source : Source? = null
    public var name : String = "Channel $number"
    private var filter : Filter? = null

    fun setSource(s : Source){
        source?.deleteSource()?: println("Tried to delete a null source")
        source = s
    }
}