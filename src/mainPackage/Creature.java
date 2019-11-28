package mainPackage;


import javafx.scene.image.ImageView;

public class Creature {
    boolean isAlive=true;
    private String type;
    public ImageView creatureImage;

    Creature(int x, int y, String type){
        super();
        creatureImage=new ImageView();
        creatureImage.setTranslateX(x);
        creatureImage.setTranslateY(y);
        this.type=type;
    }
    void moveLeft(){
        creatureImage.setTranslateX(creatureImage.getTranslateX()-5);
    }
    void moveRight(){
        creatureImage.setTranslateX(creatureImage.getTranslateX()+50);
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
