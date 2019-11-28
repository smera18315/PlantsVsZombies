package mainPackage;


public class Creature extends javafx.scene.image.ImageView {
    boolean isAlive=true;
    private String type;

    Creature(int x, int y, String type){
        super();
        setTranslateX(x);
        setTranslateY(y);
        this.type=type;
    }
    void moveLeft(){
        setTranslateX(getTranslateX()-5);
    }
    void moveRight(){
        setTranslateX(getTranslateX()+5);
    }
}
//    public static void main(String[] args){
//        ArrayList<ArrayList<Integer>> x=new ArrayList<ArrayList<Integer>>();
//        for (int i=0; i<6;i++){
//            x.add(new ArrayList<Integer>(9));
//        }
//        for (int i=0;i<6;i++){
//            for (int j=0;j<10;j++) {
//                x.get(i).add(0);
//            }
//        }
//        x.get(3).set(2,2);
//
//        for (int i=0;i<6;i++){
//            for (int j=0;j<10;j++){
//                System.out.print(x.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }
//    }
