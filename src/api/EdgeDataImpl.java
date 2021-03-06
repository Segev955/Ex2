package api;
import java.awt.*;

public class EdgeDataImpl implements EdgeData {
    private int source, destination, tag;
    private double weight;
    private String info;


    public EdgeDataImpl(int source, int destination, double weight,int tag, String info) {
        this.source=source;
        this.destination=destination;
        this.weight =weight;
        this.tag=tag;
        this.info= info;
    }

//    /**this function creates a depp copy of an EdgeData
//     *
//     * @return EdgeData
//     */
//    public EdgeDataImpl copy(){
//        EdgeDataImpl nEdgeData= new EdgeDataImpl(source, destination, weight, tag ,info);
//        return nEdgeData;
//    }
//
    @Override
    public int getSrc() {
        return this.source;
    }

    @Override
    public int getDest() {
        return this.destination;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return info;
        //return "The edge source is: "+this.source+"the destination is: "+this.destination+"the weight is: "+this.weight;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;
    }

    @Override
    public String toString() {
        return "EdgeDataImpl{" +
                "source=" + source +
                ", destination=" + destination +
                ", tag=" + tag +
                ", weight=" + weight +
                ", info='" + info + '\'' +
                '}' + "\n";
    }
}
