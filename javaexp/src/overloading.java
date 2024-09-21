class Box{
    int length;
    int breadth;
    int height;

    public void printvol(){
        System.out.println("Volume = "+this.length*this.breadth*this.height);
    }
}

Box(int length,int breadth,int height){
    this.length=length;
    this.breadth=breadth;
    this.height=height;
    //return length*breadth*height;
}

Box(int length){
    this.length=length;
    this.breadth=length;
    this.height=length;
    //return length*length*length;
}

int volume(){
    return length*breadth*height;
}

public class overloading{
    public static void main(String[] args){
        Box b1 = new Box(1,2,3);
        //Box b2 = new Box(1);
        //int vol1,vol2;
        //vol1=b1.volume();
        //vol2=b2.volume();
        //System.out.println(vol1);
        //System.out.println(vol2);
    }
}